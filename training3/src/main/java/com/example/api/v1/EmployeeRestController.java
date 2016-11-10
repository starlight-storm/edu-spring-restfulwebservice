package com.example.api.v1;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	// Data Formに入力データを設定（ex: name 斎藤, mail saito@sample.jp）
	@RequestMapping(method = RequestMethod.POST) // Spring4.3からは@PostMapping
	public ResponseEntity<Employee> create(@RequestBody @Valid Employee emp, UriComponentsBuilder uriBuilder) {
		
		employeeService.create(emp);

        URI location = uriBuilder.path("v1/employees/{id}")
                        .buildAndExpand(emp.getEmployeeId())
                        .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        return new ResponseEntity<>(
                emp, headers, HttpStatus.CREATED);
	}
	
	// 演習2オプション TODO：全件検索
	// Advance REST ClientでURLにhttp://localhost:8080/v1/employees/, GET,
	
	// 演習2オプション TODO：EMPLOYEE_ID検索
	// Advance REST ClientでURLにhttp://localhost:8080/v1/employees/{0|1}, GET
}
