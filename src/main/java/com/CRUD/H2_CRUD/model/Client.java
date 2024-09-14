package com.CRUD.H2_CRUD.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.ToString;

@Entity
@Transactional
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Table(name="Clients")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="clientId")
	private UUID clientID;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="roles")
	private String roles;
	
	/*@Column(name="Roles")
	@ManyToMany 
    @JoinTable( 
        name = "users_roles", 
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id")) 
    private Collection<Role> roles;*/
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	/*
	 * @Column(name="Task_Count") private int taskCount=0;
	 */
	
	///////////////////////////////////////////
	@OneToMany(mappedBy = "client")
    private List<Task> tasks = new ArrayList<>();
	///////////////////////////////////////////
	public Client() {};
	public Client(UUID id,String un, String pw, String email, String fn, String ln, String roles) {
		this.userName=un;
		this.password=pw;
		this.clientID=id;
		this.email=email;
		this.firstName=fn;
		this.lastName=ln;
		this.roles=roles;
	}
	
	public UUID getId() {
		return clientID;
	}
	
	public void setID(UUID id) {
		clientID=id;
	}
	
	
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
	 * 
	 */	
	
}
