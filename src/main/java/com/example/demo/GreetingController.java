package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
public class GreetingController {
	@RequestMapping(value = "/**")
	public ResponseEntity<byte[]> route(HttpServletRequest request,   @RequestBody byte[] body,
									@RequestHeader MultiValueMap<String, String> headers) {
		String queryString = request.getQueryString();
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<byte[]> result = restTemplate.exchange("http://127.0.0.1:8081?"+queryString, HttpMethod.valueOf(request.getMethod()),
				new HttpEntity<byte[]>(body, headers), byte[].class);
		return result;
	}

}
