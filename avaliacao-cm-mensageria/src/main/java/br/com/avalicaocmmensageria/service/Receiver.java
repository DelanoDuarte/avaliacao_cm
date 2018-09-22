package br.com.avalicaocmmensageria.service;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.avalicaocmmensageria.model.User;

@Component
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);
	static String appUrl = "http://localhost:8080/api/avalicao_cm/user/admin";
	private RestTemplate restTemplate = new RestTemplate();

	public void receiveMessage(String message) {
		latch.countDown();
		ResponseEntity<List<User>> response = restTemplate.exchange(appUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});
		List<User> adminUsers = response.getBody();
		adminUsers.forEach(u -> {
			System.out.println("Sending Message <" + message + ">" + " to: " + u.getEmail());
		});
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}