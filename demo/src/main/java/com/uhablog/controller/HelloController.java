package com.uhablog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


// https://uha-blog.com/java/eclipse-spring-boot/#st-toc-h-2

@Controller
public class HelloController {
	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}
}
