/**
 * 
 */
package com.sca.common.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.sca.common.logger.DiagnosticLogger;
import com.sca.common.mail.MailAttachment;
import com.sca.common.mail.MailCampaign;
import com.sca.common.mail.MailMessage;
import com.sca.common.mail.MailParams;
import com.sca.common.message.MessageAction;
import com.sca.common.message.MessageBody;
import com.sca.common.message.MessageBodyParam;
import com.sca.common.message.MessageBodyParamType;
import com.sca.common.message.MessageHeader;
import com.sca.common.message.QueueGenericMessage;
import com.sca.common.properties.MainParamProperties;
import com.sca.common.properties.MessageQueuingProperties;
import com.sca.common.util.EmailTemplates;
import com.sca.common.util.EncodingUtil;
import com.sca.common.util.HashingUtils;
import com.sca.common.util.JsonUtil;
import com.sca.common.util.ScaService;
import com.sca.dao.domain.audit.AmqErrorLog;
import com.sca.dto.audit.UserEventDto;

/**
 * 
 * @author subhash
 *
 */
@Service
public class CommonService {

	private final static DiagnosticLogger logger = DiagnosticLogger.getLogger(CommonService.class);

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private MessageQueuingProperties messageQueuingProperties;

	@Autowired
	private MainParamProperties mainParamProperties;

	@Value("${spring.application.name}")
	private String appName;

	/**
	 * 
	 * Gets the next possible server received from eureka by serverName passed
	 * 
	 * @param serverName
	 * @return
	 */
	public String getServerUri(String serverName) {
		
		String serviceUri = null;
		
		try {
			InstanceInfo loadBalancedInstance = eurekaClient.getNextServerFromEureka(serverName, false);
			if (loadBalancedInstance != null) {
				serviceUri = loadBalancedInstance.getHomePageUrl();
			}
		} catch (Exception e) {
			logger.error("Unable to find the server info from eureka" + e.getMessage());
		}

		return serviceUri;
	}

	/**
	 * 
	 * @param amqMessage
	 * @param errorMessage
	 * @param publisherServiceId
	 * @param userId
	 */
	public void writeAmqErrorLog(String amqMessage, String errorMessage, Integer publisherServiceId, Long userId) {
		
		MessageHeader messageHeader = new MessageHeader();
		messageHeader.setSourceApplciation(appName);
		messageHeader.setRequestedOn(Calendar.getInstance());
		messageHeader.setUserId(userId);
		messageHeader.setAction(MessageAction.SAVE_AMQ_ERROR_LOG);

		// Get serviceId based on applicationName
		Integer serviceId = ScaService.valueOf(appName).getServiceId();

		AmqErrorLog amqErrorLog = new AmqErrorLog();
		amqErrorLog.setAmqMessage(amqMessage);
		amqErrorLog.setErrorMessage(errorMessage);
		amqErrorLog.setPublisherServiceId(publisherServiceId);
		amqErrorLog.setSubscriberServiceId(serviceId);

		MessageBodyParam messageBodyParam = new MessageBodyParam();
		messageBodyParam.setName("amqErrorLog");
		messageBodyParam.setValue(amqErrorLog);
		messageBodyParam.setType(MessageBodyParamType.AmqErrorLog);

		List<MessageBodyParam> bodyParams = new ArrayList<MessageBodyParam>();
		bodyParams.add(messageBodyParam);

		MessageBody messageBody = new MessageBody();
		messageBody.setBodyParams(bodyParams);

		QueueGenericMessage queueMessage = new QueueGenericMessage();
		queueMessage.setMessageHeader(messageHeader);
		queueMessage.setMessageBody(messageBody);

		logger.debug("writeAmqErrorLog queueMessage:" + queueMessage);
		String jsonQueueMessage = JsonUtil.marshal(queueMessage, QueueGenericMessage.class);
		logger.debug("queueMessage json string:" + jsonQueueMessage);

		logger.debug("Sending message to queue");
		amqpTemplate.convertAndSend(messageQueuingProperties.getMessageExchanges().get("audit-service"),
				messageQueuingProperties.getMessageQueues().get("audit-service"), jsonQueueMessage);
		logger.debug("Sent the message to queue");
	}

	/**
	 * 
	 * @param userEventDto
	 * @param userId
	 */
	public void saveUserEventViaMQ(UserEventDto userEventDto, Long userId) {
		
		MessageHeader messageHeader = new MessageHeader();
		messageHeader.setSourceApplciation(appName);
		messageHeader.setRequestedOn(Calendar.getInstance());
		messageHeader.setUserId(userId);
		messageHeader.setAction(MessageAction.SAVE_USER_EVENT);

		MessageBodyParam messageBodyParam = new MessageBodyParam();
		messageBodyParam.setName("userEvent");
		messageBodyParam.setValue(userEventDto);
		messageBodyParam.setType(MessageBodyParamType.UserEvent);

		List<MessageBodyParam> bodyParams = new ArrayList<MessageBodyParam>();
		bodyParams.add(messageBodyParam);

		MessageBody messageBody = new MessageBody();
		messageBody.setBodyParams(bodyParams);

		QueueGenericMessage queueMessage = new QueueGenericMessage();
		queueMessage.setMessageHeader(messageHeader);
		queueMessage.setMessageBody(messageBody);

		logger.debug("saveUserEvent queueMessage:" + queueMessage);
		String jsonQueueMessage = JsonUtil.marshal(queueMessage, QueueGenericMessage.class);
		logger.debug("queueMessage json string:" + jsonQueueMessage);

		logger.debug("Sending message to queue");
		amqpTemplate.convertAndSend(messageQueuingProperties.getMessageExchanges().get("audit-service"),
				messageQueuingProperties.getMessageQueues().get("audit-service"), jsonQueueMessage);
		logger.debug("Sent the message to queue");
	}

	/**
	 * 
	 * @param userEmail
	 * @param fullName
	 * @param url
	 * @param userActivationKey
	 * @param referUrl
	 * @param userId
	 * @param userRoleId
	 */
	public void sendUserConfirmEmail(String userEmail, String fullName, String url, String userActivationKey,
			String referUrl, Long userId, Long userRoleId) {
		// Set mailParams
		MailParams mailParams = new MailParams();
		mailParams.setTo(userEmail);
		mailParams.setHtmlMessage(true);
		mailParams.setTemplate(EmailTemplates.USER_ADDED);
		String signUpWebURL = "";

		if (userActivationKey != null && !userActivationKey.trim().isEmpty()) {
			String refererUrl = "/user/confirm-user/?tokenId=".concat(userActivationKey).concat("&referer_url_2=")
					.concat(referUrl == null ? "" : referUrl);
			signUpWebURL = mainParamProperties.getScaMainUrl().concat("login?referer_url=")
					.concat(EncodingUtil.urlEncode(refererUrl));
			if (referUrl != null && referUrl.contains("event")) {
				refererUrl = referUrl;
				signUpWebURL = mainParamProperties.getScaMainUrl().concat("user/confirm-user/?tokenId=")
						.concat(userActivationKey).concat("&referer_url_2=").concat(EncodingUtil.urlEncode(refererUrl));
			}
		}

		// Set messageVariables
		Map<String, Object> messageVariables = new HashMap<>();
		messageVariables.put("userName", fullName);
		messageVariables.put("url", url);
		messageVariables.put("signUpWebURL", signUpWebURL);
		messageVariables.put("scaMainURL", mainParamProperties.getScaMainUrl());
		messageVariables.put("userRole", userRoleId);

		sendEmail(mailParams, messageVariables, null, userId);
	}

	/**
	 * 
	 * @param mailParams
	 * @param messageVariables
	 * @param mailAttachments
	 * @param userId
	 */
	public void sendEmail(MailParams mailParams, Map<String, Object> messageVariables,
			List<MailAttachment> mailAttachments, Long userId) {
		
		MailMessage mailMessage = new MailMessage(mailParams, messageVariables, mailAttachments, userId);

		MessageHeader messageHeader = new MessageHeader();
		messageHeader.setSourceApplciation(appName);
		messageHeader.setRequestedOn(Calendar.getInstance());
		messageHeader.setUserId(userId);
		messageHeader.setAction(MessageAction.SEND_EMAIL);

		MessageBodyParam messageBodyParam = new MessageBodyParam();
		messageBodyParam.setName("mailMessage");
		messageBodyParam.setValue(mailMessage);
		messageBodyParam.setType(MessageBodyParamType.MailMessage);

		List<MessageBodyParam> bodyParams = new ArrayList<MessageBodyParam>();
		bodyParams.add(messageBodyParam);

		MessageBody messageBody = new MessageBody();
		messageBody.setBodyParams(bodyParams);

		QueueGenericMessage queueMessage = new QueueGenericMessage();
		queueMessage.setMessageHeader(messageHeader);
		queueMessage.setMessageBody(messageBody);

		logger.debug("sendEmail queueMessage:" + queueMessage);
		String jsonQueueMessage = JsonUtil.marshal(queueMessage, QueueGenericMessage.class);
		logger.debug("queueMessage json string:" + jsonQueueMessage);
		logger.debug("Sending message to queue");
		try {
			amqpTemplate.convertAndSend(messageQueuingProperties.getMessageExchanges().get("email-service"),
					messageQueuingProperties.getMessageQueues().get("email-service"), jsonQueueMessage);
			logger.debug("Sent the message to queue");
		} catch (Exception e) {
			logger.error("Error while sending message to queue ", e);
		}
	}

	/**
	 * 
	 * @param folderToUpload
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String uploadFile(String folderToUpload, MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		String md5FileName = new StringBuilder(HashingUtils.md5(file.getOriginalFilename()))
				.append(System.currentTimeMillis()).toString();
		Path path = Paths.get(folderToUpload, md5FileName);
		// Create Parent directory if not exists
		if (!Files.exists(path.getParent())) {
			Files.createDirectories(path.getParent());
		}
		// Writes files to uploadlocation
		Files.write(path, bytes);

		return md5FileName;
	}

	/**
	 * 
	 * @param folderPath
	 * @param fileName
	 * @return
	 */
	public boolean deleteFile(String folderPath, String fileName) {
		Path path = Paths.get(folderPath, fileName);
		// Delete file from folderPath
		try {
			Files.delete(path);
			logger.debug("Deleted fileName:" + path.getFileName());
		} catch (IOException e) {
			logger.error("Unable to delete the filName:" + path.getFileName() + " Exception:" + e.getMessage());
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @param folderPath
	 * @param fileName
	 * @return
	 */
	public Resource downloadFile(String folderPath, String fileName) {
		Path filePath = Paths.get(folderPath, fileName);
		// GET file from folderPath
		Resource resource = null;
		try {
			resource = new UrlResource(filePath.toUri());
		} catch (MalformedURLException e) {
			logger.error("Unable to downloadFile filName:" + filePath.getFileName() + " Exception:" + e.getMessage());
			return null;
		}
		if (resource.exists()) {
			return resource;
		} else {
			return null;
		}
	}

	class MultipartInputStreamFileResource extends InputStreamResource {

		private final String filename;

		MultipartInputStreamFileResource(InputStream inputStream, String filename) {
			super(inputStream);
			this.filename = filename;
		}

		@Override
		public String getFilename() {
			return this.filename;
		}

		@Override
		public long contentLength() throws IOException {
			return -1; // we do not want to generally read the whole stream into
						// memory ...
		}
	}

	/**
	 * 
	 * @param updatedBy
	 * @param userId
	 * @return
	 */
	public Long setUpdatedBy(Long updatedBy, Long userId) {
		return (updatedBy != null && updatedBy > 1) ? updatedBy : userId;
	}

}
