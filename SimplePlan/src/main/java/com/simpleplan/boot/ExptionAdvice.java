package com.simpleplan.boot;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExptionAdvice {
	
	@ExceptionHandler(IOException.class)
	@ResponseBody
	public /*ModelAndView*/String testExption(IOException ex) {
		/*ModelAndView mv = new ModelAndView();
		mv.setViewName("test");
		return mv;*/
		return "testExption";
	}
	

}
