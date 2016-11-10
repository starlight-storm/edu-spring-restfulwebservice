package com.example.business.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.business.domain.Employee;

@XmlRootElement (name="employees")
public class EmployeeList {
    private List<Employee> emps = new ArrayList<Employee>();
 
    public List<Employee> getEmployees() {
        return emps;
    }
 
    public void setEmployees(List<Employee> emps) {
        this.emps = emps;
    }
    
    public void addEmployee(Employee emp) {
    	emps.add(emp);
    }
}