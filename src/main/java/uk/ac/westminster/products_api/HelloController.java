package uk.ac.westminster.products_api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private static final DateTimeFormatter CLOCK = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@GetMapping("/hello")
	public String hello() {
		return "Hello from Spring Boot!";
	}

	@GetMapping("/goodbye")
	public String goodbye() {
		return "Goodbye from Spring Boot!";
	}

	@GetMapping("/status")
	public String status() {
		return "harindu running - " + LocalDateTime.now().format(CLOCK);
	}

	@GetMapping(value = "/status/live", produces = MediaType.TEXT_HTML_VALUE)
	public String liveStatus() {
		return """
				<!DOCTYPE html>
				<html>
				<head>
				  <meta charset="UTF-8">
				  <title>Status</title>
				</head>
				<body>
				  <p id="status">loading...</p>
				  <script>
				    async function tick() {
				      const text = await fetch("/status").then((response) => response.text());
				      document.getElementById("status").textContent = text;
				    }
				    tick();
				    setInterval(tick, 1000);
				  </script>
				</body>
				</html>
				""";
	}

}
