/**
 * 
 */
package com.sca.common.logger;

import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 
 * @author subhash
 *
 */
@Component
@Aspect
public class MethodLogger {

	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(MethodLogger.class);

	static final String[] sensitiveParams = { "activationKey" };
//	"accessToken", "userToken", "anonymousAccessToken",

	/**
	 * 
	 * @param joinPoint
	 */
	@Before("execution(* com.sca.*.web..*(..))")
	public void logBeforeWebMethod(JoinPoint joinPoint) {
		try {
			MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

			Object[] args = joinPoint.getArgs();
			if (joinPoint.getTarget() instanceof Proxy) {
//			System.out.println("getInterfaces:" + joinPoint.getTarget().getClass().getInterfaces());
				logger.info("Entering into class: {} ; method: {}()", joinPoint.getTarget().getClass().getName(),
						methodSignature.getName());
			} else {
				logger.info("Entering into class: {} ; method: {}() ; with arguments: {}",
						joinPoint.getTarget().getClass().getName(), methodSignature.getName(),
						buildParamsMessage(methodSignature, args));
			}
		} catch (Exception ex) {
			logger.error("Error in logBeforeWebMethod: {}", ex.getMessage());
		}
	}

	/**
	 * 
	 * @param joinPoint
	 * @param returnValue
	 */
//	@AfterReturning(pointcut = "execution(* com.sca..*.*(..))", returning = "returnValue")
	@AfterReturning(pointcut = "execution(* com.sca.*.web..*(..))", returning = "returnValue")
	public void logAfterWebMethod(JoinPoint joinPoint, Object returnValue) {
		try {
//			logger.info("Returning from Class: {} ; Method: {} ; Return value: {}",
//					joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(),
//					returnValue == null ? null : returnValue.toString());
			logger.info("Returning from Class: {} ; Method: {} ", joinPoint.getTarget().getClass().getName(),
					joinPoint.getSignature().getName());
		} catch (Exception ex) {
			logger.error("Error in logBeforeWebMethod: {}", ex.getMessage());
		}
	}

	/**
	 * 
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("execution(* com.sca.*.service.impl..*(..))")
	public void logBeforeServiceMethod(JoinPoint joinPoint) throws Throwable {
		try {
			MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

			Object[] args = joinPoint.getArgs();
			if (joinPoint.getTarget() instanceof Proxy) {
//			System.out.println("getInterfaces:" + joinPoint.getTarget().getClass().getInterfaces());
				logger.info("Entering into class: {} ; method: {}()", joinPoint.getTarget().getClass().getName(),
						methodSignature.getName());
			} else {
				logger.info("Entering into class: {} ; method: {}() ; with arguments: {}",
						joinPoint.getTarget().getClass().getName(), methodSignature.getName(),
						buildParamsMessage(methodSignature, args));
			}
		} catch (Exception ex) {
			logger.error("Error in logBeforeWebMethod: {}", ex.getMessage());
		}
	}

	/**
	 * 
	 * @param joinPoint
	 * @param returnValue
	 */
	@AfterReturning(pointcut = "execution(* com.sca.*.service.impl..*(..))", returning = "returnValue")
	public void logAfterServiceMethod(JoinPoint joinPoint, Object returnValue) {
		try {
//			logger.info("Returning from Class: {} ; Method: {} ; Return value: {}",
//					joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(),
//					returnValue == null ? null : returnValue.toString());
			logger.info("Returning from Class: {} ; Method: {}", joinPoint.getTarget().getClass().getName(),
					joinPoint.getSignature().getName());
		} catch (Exception ex) {
			logger.error("Error in logBeforeWebMethod: {}", ex.getMessage());
		}
	}

//	@AfterThrowing(pointcut = "execution(* com.sca.common.exception.ExceptionUtil.*(..))", throwing = "exception")
//	public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
//		logger.error("We have caught exception in Class: {} ; Method: {} ; with arguments: {} ; Exception is: {}",
//				joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(),
//				Arrays.toString(joinPoint.getArgs()), exception.getMessage());
//	}

	private StringBuffer buildParamsMessage(MethodSignature methodSignature, Object[] args) {
		String[] parameterNames = methodSignature.getParameterNames();
		StringBuffer paramsMessage = new StringBuffer();
		if (args.length > 0) {
			for (int i = 0; i < parameterNames.length; i++) {

				if (parameterNames[i] != null && (Arrays.stream(sensitiveParams).anyMatch(parameterNames[i]::equals))) {
					continue;
				}

				paramsMessage.append(parameterNames[i]).append(":").append(args[i]).append(",");
			}

			if (paramsMessage.toString().endsWith(",")) {
				paramsMessage.deleteCharAt(paramsMessage.length() - 1);
			}
		}

		return paramsMessage;
	}
}
