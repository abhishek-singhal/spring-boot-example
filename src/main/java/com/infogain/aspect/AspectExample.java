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

/**
 * @author Abhishek1.Singhal
 *
 */

@Aspect
@Component
public class AspectExample {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution (* com.infogain.controller.CustomerController.*(..))")
	public void CustomerController() {
	}

	@Pointcut("execution (* com.infogain.controller.CustomerDetailController.*(..))")
	public void CustomerDetailController() {
	}

	@Pointcut("execution (* com.infogain.controller.CarController.*(..))")
	public void CarController() {
	}

	@Before("CustomerController()")
	public void CustomerAspect(JoinPoint theJoinPoint) {
		log.info(theJoinPoint.getSignature().toShortString());
		System.out.println("Inside Customer Controller");
	}

	@Before("CustomerDetailController()")
	public void CustomerDetailAspect() {
		System.out.println("Inside Customer Detail Controller");
	}

	@Before("CarController()")
	public void CarAspect() {
		System.out.println("Inside Car Controller");
	}
}
