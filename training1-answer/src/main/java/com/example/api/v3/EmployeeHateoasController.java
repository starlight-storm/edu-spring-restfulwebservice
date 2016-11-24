package com.example.api.v3;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.v1.EmployeeRestController;
import com.example.business.domain.Company;
import com.example.business.domain.Employee;

@RestController
@RequestMapping("/v3/employees")
public class EmployeeHateoasController {

	// *** HATEOAS用に変更 ***
	// Advance REST ClientでURLにhttp://localhost:8080/v3/employee, GET
	@GetMapping //Spring4.3からは@GetMapping @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Employee> findAll() {
		List<Employee> empList = new ArrayList<Employee>();
		
		Company comp = new Company(1, "夕暮製菓");
		Employee emp = new Employee(201, "山田 花子", "yama@yugure.cp.jp", comp);
		empList.add(emp);
		
		// *** HATEOAS用にキャンセルのLinkを作る ***
		emp.add(linkTo(EmployeeRestController.class).slash(emp.getEmployeeId()).withRel("cancel"));
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
}
