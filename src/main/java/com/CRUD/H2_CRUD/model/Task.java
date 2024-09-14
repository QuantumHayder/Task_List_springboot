package com.CRUD.H2_CRUD.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Tasks")

//@NoArgsConstructor
//@AllArgsConstructor(staticName="build")
@Setter
@Getter
@ToString

public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="task_ID")
	private UUID id;
	
	private String title;
	
	private String description;
	
	private Boolean completed;
	
	@ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
	//Constructors
	public Task(UUID iD, String tit, String descp, Boolean comp, Client cl) {
		id=iD; title=tit; description=descp; completed=comp; client=cl;
		
		 client.setUserName(cl.getUserName());
		 client.setPassword(cl.getPassword());
		 client.setID(cl.getId());
		 client.setEmail(cl.getEmail());
		 client.setFirstName(cl.getFirstName());
		 client.setLastName(cl.getLastName());
		 client.setRoles(cl.getRoles());
		 
	}
	
	public Task() {}
	
	// Getters
	
	public Client getClient() {
		return client;
	}
		public UUID getId() {
			return id;
		}
		public String getTitle() {
			return title;
		}
		public String getDescription() {
			return description;
		}
		public Boolean getCompleted() {
			return completed;
		}
		
		//Setters
		public void setID(UUID iD) {
			this.id=iD;
		}
		public void setTitle(String ti) {
			this.title=ti;
		}
		public void setDescription(String des) {
			this.description=des;
		}
		public void setCompleted(Boolean b) {
			this.completed=b;
		}
}
