package de.ronasoft.springboot.firstSpringboot.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstCotroller {
	
	@GetMapping("/first")
	public String myGetMethod() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		String output = "Jetzt ist: [" + dtf.format(now) + "]";
		
		return  output;		
	}

}
