package com.example.api.v1;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.business.domain.Employee;
import com.example.business.service.EmployeeService;

//演習2 TODO： 必要なアノテーションを記述しなさい
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;
	
	// Advance REST ClientでURLにhttp://localhost:8080/v1/employees/, POST,
	// Data Formに入力データを設定（ex: name 斎藤, mail saito@sample.jp）
	//演習2 TODO： 必要なアノテーションを記述しなさい
	public ResponseEntity<Employee> create(Employee emp, UriComponentsBuilder uriBuilder) {
		
		employeeService.create(emp);

        URI location = uriBuilder.path("/v1/employees/{id}")
                        .buildAndExpand(emp.getEmployeeId())
                        .toUri();

        //演習2 TODO： 必要な処理を記述し、return nullを直しなさい
        return null;
	}
	
	// 演習2オプション TODO：全件検索
	// Advance REST ClientでURLにhttp://localhost:8080/v1/employees/, GET,
	
	// 演習2オプション TODO：EMPLOYEE_ID検索
	// Advance REST ClientでURLにhttp://localhost:8080/v1/employees/{0|1}, GET

}
