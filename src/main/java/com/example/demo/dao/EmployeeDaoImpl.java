package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
//	@Qualifier("jdbcHCLService")
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	public Integer getEmpCount() {
//		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Employee", Integer.class);
//	}
	
	

	@Override
	public List<Employee> employeeList() {
		Session currentSession = getSession();
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> list = query.list();
		return list;
	}

	@Override
	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer getEmpCount() {
		// TODO Auto-generated method stub
		return null;
	}

}
