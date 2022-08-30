package com.ays.springboot_app.service;


import java.util.List;

import com.ays.springboot_app.dao.EmployeeDTO;
import com.ays.springboot_app.dao.EmployeeDetails;

public interface EmployeeService {

	
	public List<EmployeeDetails> getEmpDetails(EmployeeDTO employeeDTO);
	public List<EmployeeDetails> getAllEmployees();
	public String saveEmployee(EmployeeDetails details);
	
	
}
