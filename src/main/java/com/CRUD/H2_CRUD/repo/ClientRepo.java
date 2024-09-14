package com.CRUD.H2_CRUD.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.H2_CRUD.model.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client,UUID> {

	Optional<Client> findByUserNameAndPassword (String un, String pw);

	Client findUserByEmail(String email);

	Client findByUserName(String username);

	
}
