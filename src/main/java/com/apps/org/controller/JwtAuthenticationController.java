package com.apps.org.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apps.org.model.JwtRequest;
import com.apps.org.model.JwtResponse;
import com.apps.org.model.UserDTO;
import com.apps.org.service.JwtUserDetailsService;
import com.apps.org.util.JwtTokenUtil;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);

	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		logger.info("Authentication Request received : {}", jwtRequest);

		authenticate(jwtRequest.getName(), jwtRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getName());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		
		logger.info("Registration Request received : {}", user);
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String name, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(name, password));			
		} catch (DisabledException de) {
			throw new Exception("USER_DISABLED", de);
		} catch (BadCredentialsException bce) {
			throw new Exception("INVALID_CREDENTIALS", bce);
		}
	}
}
