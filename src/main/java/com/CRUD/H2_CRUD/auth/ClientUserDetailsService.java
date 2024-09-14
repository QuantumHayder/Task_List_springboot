package com.CRUD.H2_CRUD.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.CRUD.H2_CRUD.model.Client;
import com.CRUD.H2_CRUD.repo.ClientRepo;

@Component
public class ClientUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepo repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> client = Optional.ofNullable(repository.findByUserName(username));
        return client.map(ClientUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}