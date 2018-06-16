package com.example.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.business.domain.Employee;
import com.example.business.repository.EmployeeRepository;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int employeeId) {
		return employeeRepository.findById(employeeId);
	}

	@Override
	public int create(Employee emp) {
		return employeeRepository.create(emp);
	}
}