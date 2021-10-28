package com.te.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springproject.dao.EmployeeDao;
import com.te.springproject.dto.Employee;
import com.te.springproject.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee authenticate(int id, String pass) {
		if (id <= 0) {
			return null;
		} else {
			return employeeDao.authenticate(id, pass);
		}
	}

	@Override
	public Employee find(int id) {
		if (id <= 0) {
			return null;
		} else {
			return employeeDao.find(id);
		}
	}

	@Override
	public boolean add(Employee employee) {
		if (employee != null) {
			return employeeDao.add(employee);
		} else {
			throw new EmployeeException("data is not filled properly check again");
		}
	}

	@Override
	public boolean delete(int id) {
		if (id > 0) {
			return employeeDao.delete(id);
		} else {
			return false;
		}
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public boolean update(Employee employee) {
		if (employee.getId() <= 0) {
			return false;
		} else {
			return employeeDao.update(employee);
		}
	}

}
