package com.example.api.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.business.domain.Company;
import com.example.business.domain.Employee;

// TODO 演習1 必要なアノテーションを記述しなさい
public class EmployeeRestController {
	
	// Advance REST ClientでURLにhttp://localhost:8080/v1/employee, GET
	@GetMapping //Spring4.3からは@GetMapping @RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<Employee>();
		
		Company comp = new Company(1, "夕暮製菓");
		Employee emp = new Employee(201, "山田 花子", "yama@yugure.cp.jp", comp);
		empList.add(emp);
		
		return empList;
	}
}
