/**
 * 
 */
package com.sca.zuul.config;

import org.springframework.stereotype.Component;

import com.sca.common.logger.DiagnosticLogger;
import com.sca.dao.util.CalendarUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * @author subhash
 *
 */
@Component
public class UserEventPreFilter extends ZuulFilter {

	private static final DiagnosticLogger log = DiagnosticLogger.getLogger(UserEventPreFilter.class);

	/**
	 * 
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		try {
			ctx.getRequest().setAttribute("created-date", CalendarUtil.getCurrentTimeStamp());
		} catch (Exception e) {
			log.error("Error while setting request attribute:" + e.getMessage());
		}

		return null;
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
		return "pre";
	}

}
