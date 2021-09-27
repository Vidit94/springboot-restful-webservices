package com.example.demo.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@Autowired
	private MessageSource messageSource;

	@GetMapping("hello-world")
	public String helloWorld() {
		return "HelloWorld";
	}

	@GetMapping("hello-world-internationalized")
	public String helloWorldInternationalized() {
//	public String helloWorldInternationalized(@RequestHeader (name = "Accept-language",required=false)Locale locale){
		return messageSource.getMessage("hello.world.message", null, "DefultMessage: Hello World",
				LocaleContextHolder.getLocale());
	}
}
