package com.example.client;

import java.util.List;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "employees", 
			url = "http://localhost:8080/api/v1/employees/",
			fallback = HystrixClientFallback.class)
@EnableCircuitBreaker
public interface HystrixClient {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> findAll();
	
	@RequestMapping(method = RequestMethod.GET, value="/{employeeId}")
	public Employee findById(@PathVariable("employeeId") String employeeId);
}
