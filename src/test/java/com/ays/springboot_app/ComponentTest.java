package com.ays.springboot_app;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ays.springboot_app.dao.User;


@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ComponentTest {

	 @LocalServerPort
	 int randomServerPort;
	 
	 @Test
	 public void runTest() throws URISyntaxException {
		 RestTemplate restTemplate = new RestTemplate();
	     
		    final String baseUrl = "http://localhost:"+randomServerPort+"/api/v1/jackapp/login";
		    URI uri = new URI(baseUrl);
		     
		    User user = new User();
		    user.setUsername("jack");
		    user.setPassword("Jack$123");
		    ResponseEntity<String> result = restTemplate.postForEntity(uri, user, String.class);
		    System.out.println(result);
	 }
}
