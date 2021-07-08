package com.apps.org.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.apps.org.entity.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	public Employee findByEmpId(String empId);
	
	public Employee findByEmpName(String empName);
	
	public Page<Employee> findAll(Pageable pageable);
	
}