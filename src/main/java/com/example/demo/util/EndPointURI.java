package com.example.demo.util;

public class EndPointURI {

	private static final String BASE_API_PATH = "/api/v1/";
	private static final String SLASH = "/";
	private static final String ID = "{id}";

	public static final String EMPLOYEE = BASE_API_PATH + "employee";
	public static final String EMPLOYEE_BY_ID = BASE_API_PATH + "employee" + SLASH + ID;

}
