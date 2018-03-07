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
        this.restTemplate = restTemplateBuilder.build();
    }

	@GetMapping
	public List<Employee> getEmployee() {	
		ResponseEntity <List<Employee>> responseEntity = restTemplate.exchange(employeeApi,
			    HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>(){});
		
		// HttpStatus statusCode = responseEntity.getStatusCode();
		// HttpHeaders header = responseEntity.getHeaders();
		List<Employee> emps = responseEntity.getBody();
		return emps;
	}
	
	@GetMapping(value = "/{employeeId}")
	public Employee getEmployees(@PathVariable String employeeId) {
		ResponseEntity<Employee> responseEntity 
		    = restTemplate.getForEntity(UriComponentsBuilder
                .fromUri(employeeApi)
                .pathSegment(employeeId)
                .build()
                .toUri(), Employee.class);

		// HttpStatus statusCode = responseEntity.getStatusCode();
		// HttpHeaders header = responseEntity.getHeaders();
		Employee emp = responseEntity.getBody();
		
		return emp;
	}
}