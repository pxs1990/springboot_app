package com.ays.springboot_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ays.springboot_app.dao.EmployeeDTO;
import com.ays.springboot_app.dao.EmployeeDetails;
import com.ays.springboot_app.dao.ResultMsg;
import com.ays.springboot_app.service.EmployeeService;

@RestController 
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService; 

	@PostMapping(value="employee")
//EmployeeService has getEmpD. and saveEmp.(saves Emp and returns "success"
//ResultMsg has message and status. 
	public ResultMsg doEmp(@RequestBody EmployeeDetails employeeDetails) {
		ResultMsg resultMsg = new ResultMsg();
		if( employeeService.saveEmployee(employeeDetails).equals("success")) {
			resultMsg.setMessage("Data saved successfully");
			resultMsg.setStatus("200");
		}else {
			resultMsg.setMessage("Failed to save");
			resultMsg.setStatus("500");
		}
		return resultMsg;
	}
	
	@GetMapping(value="employee")
	public List<EmployeeDetails> getEmployeebyName(@RequestBody EmployeeDTO employeeDTO){
		return employeeService.getEmpDetails(employeeDTO);
	}
	
	@GetMapping(value="employees")
	public List<EmployeeDetails> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
}
