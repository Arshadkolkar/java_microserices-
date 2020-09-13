/**
 * 
 */
package com.sca.common.message;

import com.sca.common.mail.MailCampaign;
import com.sca.common.mail.MailMessage;
import com.sca.dao.domain.audit.AmqErrorLog;
import com.sca.dto.audit.UserEventDto;

/**
 * 
 * @author subhash
 *
 */
public enum MessageBodyParamType {

	MailMessage(MailMessage.class), AmqErrorLog(AmqErrorLog.class), UserEvent(UserEventDto.class),
	MailCampaign(MailCampaign.class);

	private final Class<?> type;

	private MessageBodyParamType(Class<?> type) {
		this.type = type;
	}

	/**
	 * 
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> Class<T> getClazzType() {
		return (Class<T>) this.type;
	}
}
