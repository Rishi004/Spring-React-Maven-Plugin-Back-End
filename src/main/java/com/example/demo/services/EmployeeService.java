package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entities.Employee;

public interface EmployeeService {

	boolean isNicAlreadyExists(String nic);

	void saveEmployee(EmployeeDto employeeDto);

	List<Employee> getAllEmployees();

}
