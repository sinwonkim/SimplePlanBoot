package com.simpleplan.boot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	@RequestMapping("/")
	private String main() {
		return "main";
	}
	
}
