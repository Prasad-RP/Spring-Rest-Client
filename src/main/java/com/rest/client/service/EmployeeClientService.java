package com.rest.client.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.rest.client.dto.AuthRequest;
import com.rest.client.dto.Employee;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings("unchecked")
public class EmployeeClientService {

	private final RestClient restClient;

	private String jwtToken;
	
	private static final String BASE_EMPLOYEE="/employee";
	
	private MediaType mediaType = MediaType.APPLICATION_JSON;

	public Map<Object, Object> login(AuthRequest authRequest) {
		log.info("Logged in..");

		@SuppressWarnings("rawtypes")
		HashMap map = restClient.post()
		.uri(BASE_EMPLOYEE +"/login")
		.contentType(mediaType)
		.body(authRequest)
		.retrieve()
		.body(HashMap.class);
		jwtToken = Objects.nonNull(map.get("Token").toString()) ? map.get("Token").toString():null;
		return map;
	}
	
	public Map<Object, Object> signUp(Employee employee) {
		return restClient.post().uri(BASE_EMPLOYEE+"/save")
				.contentType(mediaType)
				.body(employee)
				.retrieve()
				.body(HashMap.class);
	}
	
	public Map<Object, Object> getAllEmployees(){
		return restClient.get()
				.uri(BASE_EMPLOYEE)
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken)
				.retrieve()
				.body(HashMap.class);
	}
	
	public Map<Object, Object> getEmployeeById(Integer empId){
		return restClient.get()
				.uri(BASE_EMPLOYEE +"/{empId}",empId)
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken)
				.retrieve()
				.body(HashMap.class);
	}
	

}
