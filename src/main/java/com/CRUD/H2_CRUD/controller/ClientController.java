package com.CRUD.H2_CRUD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.H2_CRUD.DTO.AuthRequest;
import com.CRUD.H2_CRUD.DTO.ClientRequest;
import com.CRUD.H2_CRUD.DTO.TaskRequest;
import com.CRUD.H2_CRUD.model.Client;
import com.CRUD.H2_CRUD.model.Task;
import com.CRUD.H2_CRUD.service.ClientService;
import com.CRUD.H2_CRUD.service.JwtService;
import com.CRUD.H2_CRUD.service.TaskService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
//getEmployeeByUserNameAndPassword/{Boody}/{boody2004}
@RestController
@CrossOrigin
@RequestMapping("api/v1/client")
public class ClientController {

	@Autowired
	private ClientService soso;
	@Autowired
	private JwtService jwtService;
	@Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
	private TaskService taskServo;
	@GetMapping("/welcome") 
    //@PreAuthorize("hasAuthority('USER')") 
    public String userProfile() { 
        return "Welcome to User Profile"; 
    } 
	
	@GetMapping("/{userName}/{password}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Client> getEmployeeByuserName(@Valid @PathVariable("userName") String userName,@PathVariable("password") String password){
		Optional<Client> coco=soso.getclientbyusername(userName,password);
		return coco.map(client->new ResponseEntity<>(client, HttpStatus.OK))
				.orElseGet(()->new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}
	
	@GetMapping("/getAllEmployees")
	@PreAuthorize("hasAuthority('ROLES_ADMIN')") 
	//@RolesAllowed("ROLE_ADMIN")
	
	public ResponseEntity<List<Client>> getAllEmployees(){
		List<Client> clientList=soso.getallemployees();
		if(clientList.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(clientList,HttpStatus.OK);
	}

	//this is the sign up
	@PostMapping("/CreateEmployee")
	public ResponseEntity<Client> createEmployee(@Valid @RequestBody Client cl){
		Client hamada=soso.createclient(cl);
		return new ResponseEntity<>(hamada,HttpStatus.OK);
	}
	
	//this is the login
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
				
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
		if(authentication.isAuthenticated())
			return jwtService.generateToken(authRequest.getUserName());
		else
		{ 
			throw new UsernameNotFoundException("invalid request ya 2bn 2l3abeeta!");
		}
	}
	
	@PutMapping("/updateEmployee")
	@PreAuthorize("hasAuthority('ROLE_USER')") 
	public ResponseEntity<Client> updateEmployee(@Valid @RequestBody ClientRequest cl, String un, String pw){
		Optional<Client> updated=Optional.ofNullable(soso.updateclient(cl, un, pw));
		if(updated.isPresent())
			return new ResponseEntity<>(updated.get(),HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/deleteEmployeeByUserNameAndPassword")
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')") 
    
	public ResponseEntity<Client> deleteEmployee(String un, String pw){
		Optional<Client> is_Found=Optional.ofNullable(soso.deleteemployee(un, pw));
		if(is_Found.isPresent())
			return new ResponseEntity<>(is_Found.get(),HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
