/**
 * 
 */
package com.infogain.aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Abhishek1.Singhal
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.infogain")
public class Config {
	
}
