package com.rest.client.api;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.client.dto.AuthRequest;
import com.rest.client.dto.Employee;
import com.rest.client.service.EmployeeClientService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client-api/employee")
@Slf4j
public class EmployeeClientApi {

	private final EmployeeClientService employeeClientService;

	@PostMapping("/login")
	public ResponseEntity<Map<Object, Object>> authenticateUser(@RequestBody AuthRequest authRequest) {
		log.info("Attempting logged in......");
		return ResponseEntity.ok(employeeClientService.login(authRequest));

	}

	@PostMapping("/sign-up")
	ResponseEntity<Map<Object, Object>> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeClientService.signUp(employee), HttpStatus.CREATED);
	}

	@GetMapping("/{empId}")
	ResponseEntity<Map<Object, Object>> getEmployeeById(@PathVariable Integer empId) {
		log.info("fatching employee details by id{}", empId);
		return ResponseEntity.ok(employeeClientService.getEmployeeById(empId));
	}

	@GetMapping("/all")
	ResponseEntity<Map<Object, Object>> getAllEmployee() {
		log.info("fatching employee details ...");
		return ResponseEntity.ok(employeeClientService.getAllEmployees());
	}

}
