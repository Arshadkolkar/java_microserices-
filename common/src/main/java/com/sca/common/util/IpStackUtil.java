/**
 * 
 */
package com.sca.common.util;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sca.common.logger.DiagnosticLogger;
import com.sca.common.properties.MainParamProperties;
import com.sca.dto.audit.IpStackResponseDto;

/**
 * 
 * @author subhash
 *
 */
@Component
public class IpStackUtil {

	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(IpStackUtil.class);

	@Autowired
	private MainParamProperties mainParamProperties;

	/**
	 * 
	 * @param clientIpAddress
	 * @return
	 */
	public IpStackResponseDto setClientIpDetails(String clientIpAddress) {
		IpStackResponseDto ipStackResponseDto = null;
		try {
			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			StringBuilder ipStackApiUrl = new StringBuilder(mainParamProperties.getIpStackUrl()).append(clientIpAddress)
					.append("?access_key=").append(mainParamProperties.getIpStackKey());

			HttpEntity<?> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(ipStackApiUrl.toString(), HttpMethod.GET,
					requestEntity, String.class);
			String response = responseEntity.getBody();
			ipStackResponseDto = JsonUtil.unmarshal(response, IpStackResponseDto.class);
			ipStackResponseDto.setClientIpLookupResponse(response);
		} catch (Exception e) {
			logger.error(String.format("Error while getting details for ipaddress: %s", clientIpAddress), e);
		}

		return ipStackResponseDto;
	}

}
