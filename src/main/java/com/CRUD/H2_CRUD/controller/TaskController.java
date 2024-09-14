package com.CRUD.H2_CRUD.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.H2_CRUD.DTO.TaskRequest;
import com.CRUD.H2_CRUD.model.Client;
import com.CRUD.H2_CRUD.model.Task;
import com.CRUD.H2_CRUD.repo.TasksRepo;
import com.CRUD.H2_CRUD.service.TaskService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v2/task")

public class TaskController {

	@Autowired
	private TaskService taskServo;
	
	
	@GetMapping("/getAllTasks")
	public ResponseEntity<List<Task>> getAllTasks(UUID id) {
		List<Task> returnList = taskServo.getalltasks(id);
		if(returnList==null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(returnList,HttpStatus.OK);

		}
	
	
	@GetMapping("/getTaskByTitle/{id}")
	public ResponseEntity<Task> getTaskById(@Valid @PathVariable String ti) {
		
		Optional<Task> taskOp= taskServo.gettaskbytitle(ti);
		return taskOp.map(task-> new ResponseEntity<>(task, HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NO_CONTENT));
			   
	}
	
	@PostMapping("/createTask")
	@PreAuthorize("hasAuthority('ROLES_ADMIN')") 
	  public ResponseEntity<Task> createTask( @RequestBody @Valid TaskRequest myTask) {
		Task newTask=taskServo.createtask(myTask);
		return new ResponseEntity<>(newTask,HttpStatus.OK);
	}
	
	
	@PutMapping("/updateTaskByTitle/{id}")
	public ResponseEntity<Task> updateTask(@Valid @PathVariable String ti,@Valid @RequestBody TaskRequest newTask) {
		Task up_to_date=taskServo.updatetask(ti, newTask);
		if(up_to_date!=null)
		  return new ResponseEntity<>(up_to_date,HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
    
	@DeleteMapping("/deleteTaskByTitle/{id}")
	public ResponseEntity<HttpStatus> deleteTask(@Valid @PathVariable String ti) {
		Task deleted=taskServo.deletetask(ti);
		if(deleted!=null)
		    return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
