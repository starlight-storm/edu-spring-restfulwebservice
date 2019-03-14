package com.example.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
public class CooperationRestController {
	
	@Autowired
	private HystrixClient hystrixClient;

	@GetMapping
	public List<Employee> getEmployee() {	
		List<Employee> emps = hystrixClient.findAll();
		return emps;
	}
	
	@GetMapping(value = "/{employeeId}")
	public Employee getEmployees(@PathVariable String employeeId) {
		Employee emp = hystrixClient.findById(employeeId);		
		return emp;
	}
}