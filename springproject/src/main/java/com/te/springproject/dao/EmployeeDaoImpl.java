package com.te.springproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import com.te.springproject.config.LocalEntityManager;
import com.te.springproject.dto.Employee;
import com.te.springproject.exception.EmployeeException;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceUnit
	private EntityManagerFactory factory;

	EntityTransaction transaction;

	@Override
	public Employee authenticate(int id, String pass) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = factory.createEntityManager();
		Employee employee = manager.find(Employee.class, id);
		if (employee != null) {
			if (employee.getPassword().equals(pass)) {
				return employee;
			} else {
				throw new EmployeeException("INVALID PASSWORD");
			}
		} else {
			throw new EmployeeException("INVALID ID");
		}

	}

	@Override
	public Employee find(int id) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = factory.createEntityManager();
		Employee employee = manager.find(Employee.class, id);
		if (employee != null) {
			return employee;
		}
		throw new EmployeeException("INVALID ID");
	}

	@Override
	public boolean add(Employee employee) {
		boolean check = false;
		try {
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(employee);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		boolean check = false;
		try {
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			Employee employee = manager.find(Employee.class, id);
			transaction.begin();
			manager.remove(employee);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
		}
		return false;
	}

	@Override
	public List<Employee> findAll() {
		EntityManager manager = factory.createEntityManager();
		String find = "from Employee";
		Query query = manager.createQuery(find);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public boolean update(Employee employee) {
		try {
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Employee employee1 = manager.find(Employee.class, employee.getId());
			employee1.setDate(employee.getDate());
			employee1.setPassword(employee.getPassword());
			employee1.setUsername(employee.getUsername());
			manager.persist(employee1);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
		}
		return false;
	}

}
