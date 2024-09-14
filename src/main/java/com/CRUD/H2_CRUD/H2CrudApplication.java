package com.CRUD.H2_CRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Stream;

import com.CRUD.H2_CRUD.model.Client;
import com.CRUD.H2_CRUD.repo.ClientRepo;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class H2CrudApplication {

	//public Client(UUID id,String un, String pw, String email, String fn, String ln, String roles) {
	@Autowired
	private ClientRepo clRepo;
	
	/*
	 * @PostConstruct public void initClients() { List<Client> clients = new
	 * ArrayList<>(); clients.add(new Client(UUID.randomUUID(), "elKabeer",
	 * "kobo1999", "kabeer@gmail.com", "El Kabeer ", "2wy ", "USER"));
	 * clients.add(new Client(UUID.randomUUID(), "hamada", "hamada2000",
	 * "hamada@gmail.com", "Ahmed ", "Mohamed ", "USER")); clients.add(new
	 * Client(UUID.randomUUID(), "lolo", "lolo2001", "lolo@gmail.com", "Leila ",
	 * "Khaled ", "User")); clients.add(new Client(UUID.randomUUID(), "leila",
	 * "lolo2006", "loloo@gmail.com", "Leila ", "Ahmed ", "User")); clients.add(new
	 * Client(UUID.randomUUID(), "Boody", "boody2004", "boody@gmail.com",
	 * "Abd El-Rahman ", "Hayder ", "ROLE_ADMIN")); clRepo.saveAll(clients); }
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(H2CrudApplication.class, args);
	}

}
