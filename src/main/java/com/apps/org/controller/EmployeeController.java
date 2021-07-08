package com.apps.org.controller;

import org.springframework.http.ResponseEntity;

public interface EmployeeController {
	
	public ResponseEntity<?> getEmployees(Long id);
	
	//public ResponseEntity<Address> getEmployeeAddress(@PathVariable Long employeeId, @RequestHeader Long userId) ;

}
