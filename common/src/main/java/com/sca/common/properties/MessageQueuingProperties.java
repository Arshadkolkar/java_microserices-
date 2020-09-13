/**
 * 
 */
package com.sca.common.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author subhash
 *
 */
@Component
// prefix message, find message.* values
@ConfigurationProperties("message")
public class MessageQueuingProperties {
	private final Map<String, String> messageExchanges = new HashMap<>();
	private final Map<String, String> messageQueues = new HashMap<>();

	/**
	 * @return the messageExchanges
	 */
	public Map<String, String> getMessageExchanges() {
		return messageExchanges;
	}

	/**
	 * @return the messageQueues
	 */
	public Map<String, String> getMessageQueues() {
		return messageQueues;
	}

}
