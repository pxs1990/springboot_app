package com.ays.springboot_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.ays.springboot_app.dao.EmployeeDTO;
import com.ays.springboot_app.dao.EmployeeDetails;
import com.ays.springboot_app.dpo.Employee;
import com.ays.springboot_app.repo.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDetails> getEmpDetails(EmployeeDTO employeeDTO) {
		List<EmployeeDetails> empd = new ArrayList<>();

		List<Employee> listEmp = employeeRepository.findByName(employeeDTO.getEmployeeName());
		for(Employee employee: listEmp) {
			EmployeeDetails empDetails =  new EmployeeDetails();
			empDetails.setName(employee.getName());
			empDetails.setAge(employee.getAge());
			empDetails.setAddress(employee.getAddress());
			empDetails.setGender(employee.getGender());
			empDetails.setEmail(employee.getEmail());
			empd.add(empDetails);
		}
		return empd;

	}

	@Override
	public String saveEmployee(EmployeeDetails empDetails) {
		Employee employee = new Employee();
		employee.setName(empDetails.getName());
		employee.setAge(empDetails.getAge());
		employee.setAddress(empDetails.getAddress());
		employee.setEmail(empDetails.getEmail());
		employee.setGender(empDetails.getGender());
		employeeRepository.save(employee);
		return "success";

	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		List<Employee> listEmp = (List<Employee>) employeeRepository.findAll();
		List<EmployeeDetails> empd = new ArrayList<>();
		for(Employee employee: listEmp) {
			EmployeeDetails empDetails =  new EmployeeDetails();
			empDetails.setName(employee.getName());
			empDetails.setAge(employee.getAge());
			empDetails.setAddress(employee.getAddress());
			empDetails.setGender(employee.getGender());
			empDetails.setEmail(employee.getEmail());
			empd.add(empDetails);
		}
		return empd;

	}

}
