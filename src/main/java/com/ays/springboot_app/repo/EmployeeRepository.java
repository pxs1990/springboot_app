package com.ays.springboot_app.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ays.springboot_app.dpo.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String>{
	public List<Employee> findByName(String name);
}
