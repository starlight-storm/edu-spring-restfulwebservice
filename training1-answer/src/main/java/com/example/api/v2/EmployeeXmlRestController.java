package com.example.api.v2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.business.domain.Company;
import com.example.business.domain.Employee;
import com.example.business.domain.EmployeeList;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeXmlRestController {
	
	// Advance REST ClientでURLにhttp://localhost:8080/employee, GET
	@RequestMapping(method = RequestMethod.GET) // Spring4.3からは@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public EmployeeList findAll() {
		EmployeeList empList = new EmployeeList();
		
		Company comp = new Company(1, "夕暮製菓");
		Employee emp = new Employee(201, "山田 花子", "yama@yugure.cp.jp", comp);
		empList.addEmployee(emp);
		
		return empList;
	}
}
