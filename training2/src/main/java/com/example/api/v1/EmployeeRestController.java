package com.example.api.v1;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.business.domain.Employee;
import com.example.business.service.EmployeeService;

// TODO 演習2 必要なアノテーションを記述しなさい
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;
	
	// Advance REST ClientでURLにhttp://localhost:8080/v1/employees/, POST,
	// Row Payloadに入力データを設定（ex: {"name":"斎藤", "mail":"saito@sample.jp"} ）
	// TODO 演習2 必要なアノテーションを記述しなさい
	public ResponseEntity<Employee> create(Employee emp, UriComponentsBuilder uriBuilder) {
		
		employeeService.create(emp);

        URI location = uriBuilder.path("/v1/employees/{id}")
                        .buildAndExpand(emp.getEmployeeId())
                        .toUri();

        // TODO 演習2 必要な処理を記述し、return nullを直しなさい
        return null;
	}
	
	// TODO 演習2(オプション) 全件検索
	// Advance REST ClientでURLにhttp://localhost:8080/v1/employees/, GET,
	
	// TODO 演習2(オプション) EMPLOYEE_ID検索
	// Advance REST ClientでURLにhttp://localhost:8080/v1/employees/{0|1}, GET

}
