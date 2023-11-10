package com.rest.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Prasad Pansare
 * @date 8 Aug 2023
 * @apiNote This file is for getting username and password from client or you
 *          can take seprately as well
 * 
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

	private String name;
	
	private String password;

}
