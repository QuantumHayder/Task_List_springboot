package com.CRUD.H2_CRUD.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CRUD.H2_CRUD.DTO.ClientRequest;
import com.CRUD.H2_CRUD.model.Client;
import com.CRUD.H2_CRUD.repo.ClientRepo;

@Service
public class ClientService {

	@Autowired
	private ClientRepo roro;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Optional<Client> getclientbyusername(String un, String pw){
		return roro.findByUserNameAndPassword(un,pw);
	}
	
	public List<Client> getallemployees(){
		List<Client> ClientList = new ArrayList<>();
	    roro.findAll().forEach(ClientList::add);
	    
	    if(ClientList.isEmpty())
	    	return null;
	    return ClientList;
	}
	
	
	public Client createclient(Client cr) {
		Client newGuy = new Client(UUID.randomUUID(),cr.getUserName(),
				passwordEncoder.encode(cr.getPassword()),cr.getEmail(),cr.getFirstName(), cr.getLastName(), cr.getRoles());
		roro.save(newGuy);
		return newGuy;
	}
	
	public Client updateclient(ClientRequest cl, String un, String pw) {
		Optional<Client> toUpdate=roro.findByUserNameAndPassword(un,pw);
		if(toUpdate.isPresent())
		{
			Client updated=toUpdate.get();
			updated.setUserName(cl.getUserName());
			updated.setPassword(cl.getPassword());
			//updated.setTaskCount(cl.getTaskCount());
			return updated;
		}
		return null;
	}
	
	public Client deleteemployee(String un, String pw) {
		Optional<Client> byeBye=roro.findByUserNameAndPassword(un, pw);
		Client tozfy=null;
		if(byeBye.isPresent())
		{
			tozfy=byeBye.get();
			roro.deleteById(byeBye.get().getId());;
			return tozfy;
		}
		return null;
	}
}
