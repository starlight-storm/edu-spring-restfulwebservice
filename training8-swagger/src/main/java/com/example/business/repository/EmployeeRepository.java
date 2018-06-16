package com.example.business.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.example.business.domain.Employee;

@Mapper
public interface EmployeeRepository {
	@Select("SELECT EMPLOYEE_ID,NAME,MAIL FROM EMPLOYEE")
	List<Employee> findAll();

	@Select("SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = #{employeeId}")
	Employee findById(int employeeId);

	@Insert("INSERT INTO EMPLOYEE(NAME,MAIL) VALUES(#{name},#{mail})")
	@SelectKey(statement="call identity()", keyProperty="employeeId", before=false, resultType=int.class)
	int create(Employee emp);
}
