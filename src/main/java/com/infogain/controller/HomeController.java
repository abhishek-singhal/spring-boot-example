/**
 * 
 */
package com.infogain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author abhishek-singhal
 *
 */

@Controller
public class HomeController {

	@GetMapping("/")
	public String homePage() {
		return "home";
	}
}
