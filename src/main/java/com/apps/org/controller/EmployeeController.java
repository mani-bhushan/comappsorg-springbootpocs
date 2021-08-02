package com.apps.org.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apps.org.custom.exceptions.handler.CustomExceptionHandler;
import com.apps.org.entity.Employee;
import com.apps.org.model.request.EmployeeRequest;
import com.apps.org.model.response.PageResponse;
import com.apps.org.service.EmployeeService;
import com.apps.org.util.EmployeeUtils;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")
public class EmployeeController {


	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<PageResponse> getAllEmployees(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {

		PageResponse response = employeeService.getAllEmployees(page, size);
		HttpHeaders headers = EmployeeUtils.populateHttpHeaders(response);
		return ResponseEntity.ok().headers(headers).body(response);
	}

	@PostMapping("/employees")
	public ResponseEntity<?> addNewEmployee (
			@RequestBody EmployeeRequest employeeRequest) {
		
		try {
			PageResponse response = employeeService.addNewEmployee(employeeRequest);
			return new ResponseEntity<PageResponse>(response, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@GetMapping(value="/employees/{id}", produces="application/json")
	public ResponseEntity<?> getEmployees(@PathVariable @Valid Long id) {
		try { 
			Employee employee = employeeService.getEmployee(id);
			return ResponseEntity.ok().body(employee);
		} catch (CustomExceptionHandler ex) {
			return new ResponseEntity<>(ex.getErrorMessage(), ex.getHttpStatus());
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping("/employees/{empId}") 
	public ResponseEntity<PageResponse> updateeEmployee(@RequestBody EmployeeRequest employeeRequest) {
		PageResponse response = employeeService.updateEmployee(employeeRequest);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<PageResponse> deleteEmployee(@PathVariable @Valid Long id) {
		//repository.deleteById(id); 
		return null;
	}

}