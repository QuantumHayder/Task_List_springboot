package com.CRUD.H2_CRUD.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.CRUD.H2_CRUD.DTO.TaskRequest;
import com.CRUD.H2_CRUD.model.Client;
import com.CRUD.H2_CRUD.model.Task;
import com.CRUD.H2_CRUD.repo.ClientRepo;
import com.CRUD.H2_CRUD.repo.TasksRepo;

@Service
public class TaskService {

	@Autowired
	private TasksRepo taskRepo;
	@Autowired
	private ClientRepo clientRepo;
	/*
	 * @Autowired private SecurityContextHolder securityContext;
	 */
	
	/*public Task saveTask(TaskRequest req) {
		
		Task task= new Task(UUID.randomUUID(), req.getTitle(), req.getDescp(), req.getComp());
		return repo.save(task);
				
	}
	
	public List<Task> getAllTasks(){
		return repo.findAll();
	}
	
	public Task getTask(UUID id) {
	
		return repo.findByID (id);
		//return repo.findById(id).get();
		
	}*/
	
	public TaskService (TasksRepo taskrepo,ClientRepo clientrepo) {
		this.clientRepo=clientrepo;
		this.taskRepo=taskrepo;
	}
	
	/*
	 * private Client getAuthenticatedClient() { // Handle case where user is not
	 * authenticated }
	 */
	public List<Task> getalltasks(UUID id){
		List<Task> TaskList = new ArrayList<>();
	    //taskRepo.findAll().forEach(TaskList::add);
		
		List<Task> tasksWithForeignKey = taskRepo.findAll().stream()
		        .filter(task -> task.getClient().getId()== id) // Replace desiredForeignKey with your specific ID
		        .collect(Collectors.toList());
		TaskList.addAll(tasksWithForeignKey);
		
	    if(TaskList.isEmpty())
	    	return null;
	    return TaskList;
		
}
	public Optional<Task> gettaskbytitle(String ti) {
		return taskRepo.findByTitle(ti);
		
	}

	public Task createtask(TaskRequest newTask) {
		/*
		 * Authentication authentication =
		 * SecurityContextHolder.getContext().getAuthentication(); if (authentication ==
		 * null || !(authentication.getPrincipal() instanceof Client)) { throw new
		 * IllegalStateException("No authenticated client found."); } Client
		 * authenticatedClient = (Client) authentication.getPrincipal();
		 * 
		 * Task create = new Task( UUID.randomUUID(), newTask.getTitle(),
		 * newTask.getDescription(), newTask.getCompleted(), authenticatedClient );
		 * 
		 * taskRepo.save(create); return create;
		 */
		Optional<Client> requiredClient = Optional.ofNullable(clientRepo.findByUserName(newTask.getUsername()));
		if(requiredClient.isPresent()) {
			Task newlyCreated = new Task(UUID.randomUUID(),newTask.getTitle(),
					newTask.getDescription(),newTask.getCompleted(),requiredClient.get());
			taskRepo.save(newlyCreated); 
			return newlyCreated;
		}
		return null;
	}
	
	public Task updatetask(String ti,TaskRequest newTask) {
		Task updated=taskRepo.findByTitle(ti).get();
		if(updated!=null)
		{
			updated.setTitle(newTask.getTitle());
			updated.setCompleted(newTask.getCompleted());
			updated.setDescription(newTask.getDescription());
			taskRepo.save(updated);
			return updated;
		}
		return null;
	}
	
	public Task deletetask(String ti) {
		Optional<Task> bala7a=taskRepo.findByTitle(ti);
		Task m3l4 = null;
		if(bala7a.isPresent())
		{
			m3l4=bala7a.get();
			taskRepo.deleteById(bala7a.get().getId());
			return m3l4;
		}
		return null;
	}
		
}
