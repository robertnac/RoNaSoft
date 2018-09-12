package de.ronasoft.springboot.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controllerbase")
public class FirstController {
	
	@GetMapping(path="/method")
	public String meineGetMethode() {
		System.out.println("bin hier.");
		return "Jetzt ist:" + new Date().toString();
	}

}
