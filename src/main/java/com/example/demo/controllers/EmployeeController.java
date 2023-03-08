package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.enums.RestApiResponseStatus;
import com.example.demo.responses.BasicResponse;
import com.example.demo.responses.ContentResponse;
import com.example.demo.responses.ValidationFailureResponse;
import com.example.demo.services.EmployeeService;
import com.example.demo.util.Constants;
import com.example.demo.util.EndPointURI;
import com.example.demo.util.ValidationFailureStatusCodes;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ValidationFailureStatusCodes validationFailureStatusCodes;

	@PostMapping(value = EndPointURI.EMPLOYEE)
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDto employeeDto) {
		if (employeeService.isNicAlreadyExists(employeeDto.getNic())) {
			return new ResponseEntity<>(new ValidationFailureResponse(Constants.NIC_ALREADY_EXISTS,
					validationFailureStatusCodes.getEmployeeNicAlreadyExist()), HttpStatus.BAD_REQUEST);
		}

		employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(new BasicResponse<>(RestApiResponseStatus.OK, Constants.ADD_EMPLOYEE_SUCCESS),
				HttpStatus.OK);
	}

	@GetMapping(value = EndPointURI.EMPLOYEE)
	public ResponseEntity<Object> getAllEmployee() {
		return new ResponseEntity<>(
				new ContentResponse<>(Constants.EMPLOYEE, employeeService.getAllEmployees(), RestApiResponseStatus.OK),
				null, HttpStatus.OK);
	}
}
