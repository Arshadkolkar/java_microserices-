/**
 * This is the queue listener of Audit service.
 */
package com.sca.auditservice.listener;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sca.auditservice.service.UserEventService;
import com.sca.common.logger.DiagnosticLogger;
import com.sca.common.message.MessageBodyParam;
import com.sca.common.message.MessageBodyParamType;
import com.sca.common.message.QueueGenericMessage;
import com.sca.common.util.JsonUtil;
import com.sca.common.util.ScaService;
import com.sca.dao.domain.audit.AmqErrorLog;
import com.sca.dao.repository.audit.AmqErrorLogRepository;
import com.sca.dto.audit.UserEventDto;

/**
 * 
 * @author subhash
 *
 */
@Component
public class AuditServiceMessageListener {

	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(AuditServiceMessageListener.class);

	@Autowired
	private AmqErrorLogRepository amqErrorLogRepository;

	@Autowired
	private UserEventService userEventService;

	/**
	 * This method is invoked whenever any new message is put in the queue.
	 * 
	 * @param message
	 */
	@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${message.message-queues.audit-service}", durable = "true"), exchange = @Exchange(value = "${message.message-exchanges.audit-service}", durable = "true", type = ExchangeTypes.TOPIC), key = "${message.message-queues.audit-service}"))
	public void receiveAuditMessage(String message) {
		try {
			logger.info("AuditMessageRabbitListener Message received...");
			QueueGenericMessage queueMessage = JsonUtil.unmarshal(message, QueueGenericMessage.class);
			if (!queueMessage.isValid()) {
				logger.error("Incorrect message received");

				saveAmqErrorLog(message, "Incorrect message received", queueMessage.getPublisherServiceId(),
						queueMessage.getOrganizationId());

				return;
			}

			switch (queueMessage.getMessageHeader().getAction()) {
			case SAVE_AMQ_ERROR_LOG:
				MessageBodyParam amqMessageBodyParam = queueMessage.getMessageBody().getBodyParams().stream()
						.filter(bodyParam -> bodyParam.getName().equals("amqErrorLog")).findFirst().orElse(null);

				if (amqMessageBodyParam != null) {
					if (amqMessageBodyParam.getType() != null
							&& amqMessageBodyParam.getType().equals(MessageBodyParamType.AmqErrorLog)) {
						AmqErrorLog amqErrorLog = JsonUtil.unmarshal(JsonUtil.marshal(amqMessageBodyParam.getValue()),
								amqMessageBodyParam.getType().getClazzType());
						if (amqErrorLog != null) {
							amqErrorLogRepository.save(amqErrorLog);
						}
					}
				}

				break;
			case SAVE_USER_EVENT:
				MessageBodyParam userEventMessageBodyParam = queueMessage.getMessageBody().getBodyParams().stream()
						.filter(bodyParam -> bodyParam.getName().equals("userEvent")).findFirst().orElse(null);

				if (userEventMessageBodyParam != null) {
					if (userEventMessageBodyParam.getType() != null
							&& userEventMessageBodyParam.getType().equals(MessageBodyParamType.UserEvent)) {
						UserEventDto userEventDto = JsonUtil.unmarshal(
								JsonUtil.marshal(userEventMessageBodyParam.getValue()),
								userEventMessageBodyParam.getType().getClazzType());
						userEventService.saveUserEventForApiReqs(userEventDto);
					}
				}

				break;
			default:
				break;
			}

			logger.info("AuditMessageRabbitListener Message processed...");
		} catch (Exception e) {
			logger.error("Error while processing message: " + e);
			try {
				QueueGenericMessage queueMessage = JsonUtil.unmarshal(message, QueueGenericMessage.class);
				saveAmqErrorLog(message, "Error while processing message: " + e, queueMessage.getPublisherServiceId(),
						queueMessage.getOrganizationId());
			} catch (Exception e2) {
				logger.error("Error while saving AmqErrorLog: " + e2);
			}
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}

	private void saveAmqErrorLog(String amqMessage, String errorMessage, Integer publisherServiceId,
			Long organizationId) {
		AmqErrorLog amqErrorLog = new AmqErrorLog();
		amqErrorLog.setAmqMessage(amqMessage);
		amqErrorLog.setErrorMessage(errorMessage);
		amqErrorLog.setPublisherServiceId(publisherServiceId);
		amqErrorLog.setSubscriberServiceId(ScaService.sca_audit_service.getServiceId());

		amqErrorLogRepository.save(amqErrorLog);
	}
}
