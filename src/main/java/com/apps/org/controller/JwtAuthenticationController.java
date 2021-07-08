package com.apps.org.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.apps.org.model.JwtRequest;
import com.apps.org.model.UserDTO;

public interface JwtAuthenticationController {

	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception;
	
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception;
}
