package com.CRUD.H2_CRUD.model;

import org.hibernate.mapping.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
/*
@Entity
public class Role {

	/* @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String name;
	    @ManyToMany(mappedBy = "roles")
	    private Collection<Client> users;

	    @ManyToMany
	    @JoinTable(
	        name = "roles_privileges", 
	        joinColumns = @JoinColumn(
	          name = "role_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "privilege_id", referencedColumnName = "id"))
	    private Collection<Privilege> privileges;

}*/
