package com.te.springproject.service;

import java.util.List;

import com.te.springproject.dto.Employee;

public interface EmployeeService {
	public Employee authenticate(int id, String pass);

	public Employee find(int id);

	public boolean add(Employee employee);

	public boolean delete(int id);

	public List<Employee> findAll();
	
	public boolean update(Employee employee);
}
