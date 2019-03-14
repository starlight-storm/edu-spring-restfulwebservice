package com.example.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class HystrixClientFallback implements HystrixClient {
    public List<Employee> findAll() {
    	List<Employee> employeeList = new ArrayList<Employee>();
    	employeeList.add(new Employee(100, "FallBack!", "bar@fallbackcom"));
    	return employeeList;
    }
    
    public Employee findById(@PathVariable("employeeId") String employeeId) {
    	return new Employee(99, "FallBack!", "foo@fallbackcom");
    }
}