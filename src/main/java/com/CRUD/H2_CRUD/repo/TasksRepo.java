package com.CRUD.H2_CRUD.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.H2_CRUD.model.Task;

@Repository
public interface TasksRepo extends JpaRepository<Task,UUID> {

	Optional<Task> findByTitle(String ti);

}
