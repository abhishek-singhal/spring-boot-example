/**
 * 
 */
package com.infogain.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Abhishek1.Singhal
 *
 */

@Aspect
@Component
public class AspectRequest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("@annotation(requestMapping)")
	public void controllers(RequestMapping requestMapping) {
		
	}
	
	@Before("controllers(requestMapping)")
	public void controllerAspect(JoinPoint theJoinPoint, RequestMapping requestMapping) {
		log.info(theJoinPoint.getSignature().toShortString());
	}
}
