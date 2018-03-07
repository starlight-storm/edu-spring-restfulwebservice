package com.example.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CooperationRestController {

	@Value("http://localhost:8080/api/v1/employees/")
	URI employeeApi;
	
	private RestTemplate restTemplate;
	
	public CooperationRestController(RestTemplateBuilder restTemplateBuilder) {
        // TODO 演習7 必要な処理を書きなさい
    }

	@GetMapping
	public List<Employee> getEmployee() {	
		// TODO 演習7(オプション) 必要な処理を書きなさい
		return null;
	}
	
	@GetMapping(value = "/{employeeId}")
	public Employee getEmployees(@PathVariable String employeeId) {
		// TODO 演習7 必要な処理を書きなさい
				return null;
	}
}