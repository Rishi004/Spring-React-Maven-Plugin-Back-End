package com.example.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@PropertySource("classpath:ValidationMessages.properties")
public class ValidationFailureStatusCodes {

	// employee
	@Value("${validation.employee.employeeNicAlreadyExist}")
	private String employeeNicAlreadyExist;
	@Value("${validation.employee.employeeMailAlreadyExist}")
	private String employeeMailAlreadyExist;

}
