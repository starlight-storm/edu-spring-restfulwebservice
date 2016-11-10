package com.example.api.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.business.domain.Company;
import com.example.business.domain.Employee;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeRestController {
	
	// Advance REST ClientでURLにhttp://localhost:8080/employee, GET
	@RequestMapping(method = RequestMethod.GET) // Spring4.3からは@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<Employee>();
		
		Company comp = new Company(1, "夕暮製菓");
		Employee emp = new Employee(201, "山田 花子", "yama@yugure.cp.jp", comp);
		empList.add(emp);
		
		return empList;
	}
}
