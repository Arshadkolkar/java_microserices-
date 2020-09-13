/**
 * 
 */
package com.sca.zuul.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sca.common.logger.DiagnosticLogger;
import com.sca.common.service.CommonService;
import com.sca.common.util.Constants;
import com.sca.dao.domain.common.RequestHttpMethod;
import com.sca.dao.util.CalendarUtil;
import com.sca.dto.audit.UserEventDto;

/**
 * 
 * @author subhash
 *
 */
@Component
public class UserEventPostFilter extends ZuulFilter {

	private static final DiagnosticLogger log = DiagnosticLogger.getLogger(UserEventPostFilter.class);

	@Autowired
	private CommonService commonService;

	/**
	 * 
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		try {
			UserEventDto userEventDto = setUserEventDto(ctx);
			commonService.saveUserEventViaMQ(userEventDto, userEventDto.getUserId());
		} catch (Exception e) {
			log.error("Error while saving userEvent for API requests:" + e.getMessage(), e);
		}

		return null;
	}

	private UserEventDto setUserEventDto(RequestContext ctx) {
		HttpServletRequest request = ctx.getRequest();
		UserEventDto userEventDto = new UserEventDto();

		setScaServiceUrl(userEventDto, request);
		userEventDto.setScaServiceHttpMethod(RequestHttpMethod.valueOf(request.getMethod()));
		if (!isMultipart(request.getContentType())) {
			setScaServiceRequest(userEventDto, request);
		}
		if (!isMultipart(request.getHeader(HttpHeaders.ACCEPT))) {
			setScaServiceResponse(userEventDto, ctx);
		}
		setServiceRequestStatus(userEventDto, ctx.getResponseStatusCode());
		setUserId(userEventDto, request);
		setClientIpAddress(userEventDto, request);
		if (request.getAttribute("created-date") != null) {
			userEventDto.setCreatedDate((Calendar) request.getAttribute("created-date"));
		} else {
			userEventDto.setCreatedDate(CalendarUtil.getCurrentTimeStamp());
		}
		userEventDto.setUpdatedDate(CalendarUtil.getCurrentTimeStamp());

		return userEventDto;
	}

	private boolean isMultipart(final String contentType) {
		return contentType != null && (contentType.startsWith(MediaType.MULTIPART_FORM_DATA_VALUE)
				|| contentType.startsWith(MediaType.APPLICATION_OCTET_STREAM_VALUE));
	}

	private void setServiceRequestStatus(UserEventDto userEventDto, int status) {
		// FOR HTTP STATUS CODES 4xx and 5xx
		if (String.valueOf(status).startsWith("3") || String.valueOf(status).startsWith("4")
				|| String.valueOf(status).startsWith("5")) {
			userEventDto.setServiceRequestStatus(false);
		}
	}

	private void setClientIpAddress(UserEventDto userEventDto, HttpServletRequest request) {
		if (request.getHeader(Constants.HTTP_HEADER_CLIENT_IP_ADDRESS) != null
				&& !request.getHeader(Constants.HTTP_HEADER_CLIENT_IP_ADDRESS).trim().isEmpty()) {
			userEventDto.setClientIpAddress(request.getHeader(Constants.HTTP_HEADER_CLIENT_IP_ADDRESS));
		} else {
			userEventDto.setClientIpAddress(request.getRemoteAddr());
		}
	}

	private void setUserId(UserEventDto userEventDto, HttpServletRequest request) {
		userEventDto.setUserId((long) 1);
	}

	private void setScaServiceRequest(UserEventDto userEventDto, HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase(RequestHttpMethod.POST.name())
				|| request.getMethod().equalsIgnoreCase(RequestHttpMethod.PUT.name())) {
			try {
				if (request != null && request.getContentLength() > 0) {
					userEventDto.setscaServiceRequest(
							request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
				}
			} catch (IOException exception) {
				log.error("Error while getting request body:" + exception.getMessage(), exception);
			}
		}
	}

	private void setScaServiceUrl(UserEventDto userEventDto, HttpServletRequest request) {
		try {
			userEventDto
					.setScaServiceUrl(
							(request.getQueryString() != null)
									? new StringBuilder(request.getRequestURL()).append("?")
											.append(URLDecoder.decode(request.getQueryString(),
													Constants.ENCODING_UTF_8))
											.toString()
									: request.getRequestURL().toString());
		} catch (UnsupportedEncodingException exception) {
			exception.printStackTrace();
			log.error("Error while getting requestUrl:" + exception.getMessage());
		}
	}

	private void setScaServiceResponse(UserEventDto userEventDto, RequestContext ctx) {
		try (final InputStream responseDataStream = ctx.getResponseDataStream()) {
			final String responseData = CharStreams
					.toString(new InputStreamReader(responseDataStream, Constants.ENCODING_UTF_8));
			ctx.setResponseBody(responseData);
			userEventDto.setScaServiceResponse(responseData);
		} catch (IOException exception) {
			log.error("Error while getting response body:" + exception.getMessage(), exception);
		}
	}

	/**
	 * 
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 
	 */
	@Override
	public int filterOrder() {
		return 1;
	}

	/**
	 * 
	 */
	@Override
	public String filterType() {
		return "post";
	}

}
