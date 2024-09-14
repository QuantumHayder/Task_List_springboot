package com.CRUD.H2_CRUD.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AuthRequest {
	
	private String userName;
	private String password;
	//private String roles;
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	/*
	 * public String getRoles() { return roles; }
	 */


}
