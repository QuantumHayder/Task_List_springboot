package com.CRUD.H2_CRUD.DTO;

import org.modelmapper.Converters.Collection;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ClientRequest {

	@NotBlank(message = "UserName is mandatory field") 
	private String userName;
	
	@NotBlank(message = "Passsword is mandatory field") 
	private String password;
	
	@NotBlank(message = "Email is mandatory field") 
	private String email;
	
	/*@NotBlank(message = "Roles is mandatory field") 
	private Collection<GrantedAuthority> authorities;
*/
	private String roles;
	
	@NotBlank(message = "firstname is mandatory field") 
	private String firstName;
	
	@NotBlank(message = "Lastname is mandatory field") 
	private String lastName;
	
	
	/*
	 * @NotBlank(message = "Name is mandatory field") private int taskCount=0;
	 */
	
	
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String username) {
		userName = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String pw) {
		password = pw;
	}
	
	public String getRoles() {
		return roles;
	}


	public void setRoles(String ro) {
		roles=ro;
	}
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String fn) {
		firstName=fn;
	}
	
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String ln) {
		lastName=ln;
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String em) {
		email=em;
	}

	/*
	 * public int getTaskCount() { return taskCount; }
	 * 
	 * 
	 * public void setTaskCount(int taskcount) { taskCount = taskcount; }
	 */
	
}
