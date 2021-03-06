package com.example.Strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class StringsApplication {

	@RequestMapping("/")
	public String hello() {
		
		return "Hello client";
	}
	
	@RequestMapping("/random")
	public String random() {
		
		return "Random Page";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}

}
