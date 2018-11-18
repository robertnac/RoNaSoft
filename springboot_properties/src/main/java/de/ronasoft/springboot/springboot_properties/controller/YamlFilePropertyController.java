
package de.ronasoft.springboot.springboot_properties.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring MVC Contoller für die Demonstration von
 * Konfiguration über Yaml Datei.
 * 
 * @author robert
 *
 */
@RestController
@RequestMapping("/yamlproperty")
public class YamlFilePropertyController {
	
	@Value("${yaml.property}")
    private String propertyWert;
	
	@GetMapping
	public String meineGetMethode() {
		System.out.println("bin hier.");
		return "Propertyinhalt:[" + propertyWert + "]";
	}
}
