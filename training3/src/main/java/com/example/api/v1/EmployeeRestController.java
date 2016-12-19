package com.example.api.v1;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.business.domain.Employee;
import com.example.business.service.EmployeeService;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;

	// Advance REST ClientでURLにhttp://localhost:8080/v1/employees/, POST,
	// Row Payloadに入力データを設定（ex: {"name":"斎藤", "mail":"saito@sample.jp"} ）
	@PostMapping
	public ResponseEntity<Employee> create(@RequestBody @Valid Employee emp, UriComponentsBuilder uriBuilder) {
		
		employeeService.create(emp);

        URI location = uriBuilder
        		.path("v1/employees/{id}")
                .buildAndExpand(emp.getEmployeeId())
                .toUri();

        return ResponseEntity
        		.created(location)
        		.body(emp);
	}
	
	// TODO 演習3(オプション) 全件検索
	// Advance REST ClientでURLにhttp://localhost:8080/v1/employees/, GET,
	
	// TODO 演習3(オプション) EMPLOYEE_ID検索
	// Advance REST ClientでURLにhttp://localhost:8080/v1/employees/{0|1}, GET
}
