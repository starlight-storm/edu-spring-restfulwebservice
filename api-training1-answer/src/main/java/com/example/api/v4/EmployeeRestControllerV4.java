package com.example.api.v4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.business.domain.Company;
import com.example.business.domain.Employee;

@RestController
@RequestMapping("/api/v4/employees")
public class EmployeeRestControllerV4 {

	// Advance REST ClientでURLにhttp://localhost:8080/api/v4/employees, GET
	@GetMapping // Spring4.3からは@GetMapping @RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> find() {
		List<Employee> empList = new ArrayList<Employee>();

		Company comp = new Company(1, "夕暮製菓");
		Employee emp = new Employee(201, "山田 花子", "yama@yugure.cp.jp", comp);
		empList.add(emp);

		return empList;
	}

	// Advance REST ClientでURLにhttp://localhost:8080/api/v1/employees/数字, GET
	@GetMapping("{employeeId}") // Spring4.3からは@GetMapping @RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Employee findById(@PathVariable int employeeId) {
		Company comp = new Company(1, "夕暮製菓");
		Employee emp = new Employee(employeeId, "山田 花子", "yama@yugure.cp.jp", comp);
		return emp;
	}
	
	// Advance REST ClientでURLにhttp://localhost:8080/api/v4/employees?name=YAMADA, GET
	@GetMapping(params = "name") // Spring4.3からは@GetMapping @RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> find(String name) {
		List<Employee> empList = new ArrayList<Employee>();

		Company comp = new Company(1, "夕暮製菓");
		Employee emp = new Employee(333, name, "yama@yugure.cp.jp", comp);
		empList.add(emp);
		
		return empList;
	}
}