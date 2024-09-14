package com.CRUD.H2_CRUD.DTO;
import jakarta.validation.constraints.*;



public class TaskRequest {

	
	@NotBlank(message = "Name is mandatory field") 
	    public String Title;

	
	@NotBlank(message="Description must not be empty")
	public String Description;
	
	
     @NotNull(message="Completed must not be empty")
	public Boolean Completed;
     
     @NotBlank(message="Description must not be empty")
 	public String userName;
 	
 	
     // Default constructor
     public TaskRequest() {
     }

     // Full constructor
     public TaskRequest(String Title, String Description, Boolean Completed) {
         this.Title = Title;
         this.Description = Description;
         this.Completed = Completed;
     }
    
     
     public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public Boolean getCompleted() {
		return Completed;
	}


	public void setCompleted(Boolean completed) {
		Completed = completed;
	}

	public String getUsername() {
		return userName;
	}


	public void setUsername(String un) {
		userName = un;
	}
}
