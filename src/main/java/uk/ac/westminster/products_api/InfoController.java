package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

	@GetMapping("/info")
	public String info() {
		return "products-api is a Spring Boot tutorial application for 5COSC019W.";
	}

}
