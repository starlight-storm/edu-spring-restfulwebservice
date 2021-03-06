package com.example.api.v1;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.business.domain.Employee;
import com.example.business.service.EmployeeService;
import com.example.common.exception.EmployeeDeleteException;
import com.example.common.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;

	// Advance REST ClientでURLにhttp://localhost:8080/api/v1/employees/, GET,
	@GetMapping // Spring4.3からは@GetMapping
	public List<Employee> findAll() {
		List<Employee> employees = employeeService.findAll();
        return employees;
	}
	
	// Advance REST ClientでURLにhttp://localhost:8080/api/v1/employees/{0|1}, GET
	@GetMapping(value = "/{employeeId}") // Spring4.3からは@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public Employee findById(@PathVariable int employeeId) {
		Employee emp = employeeService.findById(employeeId);
		if(emp == null) throw new EmployeeNotFoundException("そんな人はいません");
		return emp;
	}
	
	// Advance REST ClientでURLにhttp://localhost:8080/api/v1/employees/{0|1}, DELETE
	@DeleteMapping(value = "/{employeeId}") // Spring4.3からは@DeleteMapping
	public Employee delete(@PathVariable int employeeId) {
		throw new EmployeeDeleteException("消せません");
	}

	// Advance REST ClientでURLにhttp://localhost:8080/api/v1/employees/, POST,
	// Row Payloadに入力データを設定（ex: {"name":"斎藤", "mail":"saito@sample.jp"} ）
	@PostMapping // Spring4.3からは@PostMapping
	public ResponseEntity<Employee> create(@RequestBody @Valid Employee emp, UriComponentsBuilder uriBuilder) {
		
		employeeService.create(emp);

        URI location = uriBuilder
        		.path("api/v1/employees/{id}")
                .buildAndExpand(emp.getEmployeeId())
                .toUri();

        return ResponseEntity
        		.created(location)
        		.body(emp);
	}
	
	// エラーハンドラ
	// TODO 演習4 EmployeeNotFoundExceptionが発生したら、404になるようなアノテーションを記述しなさい
    RestControllerError handleOrderException(EmployeeNotFoundException e) {
        return new RestControllerError(e.getMessage(), "http://localhost:8080/api/v1/employees");
    }
    
	// TODO 演習4(オプション) 全件検索
	// Advance REST ClientでURLにhttp://localhost:8080/api/v1/employees/, GET,

}
