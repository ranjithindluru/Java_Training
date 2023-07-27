package com.user.task.mangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.task.mangement.entity.Task;
import com.user.task.mangement.service.TaskService;

@RestController
@RequestMapping(value = "/api/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

	/**
	 * Creates a new Task
	 * 
	 * @param task The Task object to be created.
	 * @return ResponseEntity containing the created project's information and HTTP
	 *         status code.
	 */
	@PostMapping
	public ResponseEntity<Task> saveTask(@RequestBody Task task) {
		Task tasks = taskService.createTask(task);
		return new ResponseEntity<>(tasks, HttpStatus.CREATED);
	}

	/**
	 * Update the existing Task
	 * 
	 * @param Id, task The Id, task object to be created.
	 * @return ResponseEntity containing the update task's information and HTTP
	 *         status code.
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable(value = "id") Long id, @RequestBody Task task) {
		Task existingTask = taskService.updateTask(id, task);
		if (existingTask != null) {
			return new ResponseEntity<Task>(existingTask, HttpStatus.OK);
		} else {
			return new ResponseEntity<Task>(existingTask, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Retrieves a task by ID.
	 * 
	 * @param id The id of the Task to be retrieved.
	 * @return ResponseEntity containing the task's information if found, or HTTP
	 *         status code 404 if not found.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Task> getTask(@PathVariable(value = "id") Long id) {
		Task taskId = taskService.getTaskId(id);
		if (taskId != null) {
			return new ResponseEntity<Task>(taskId, HttpStatus.OK);
		} else {
			return new ResponseEntity<Task>(taskId, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/taskDetails/{id}")
	public ResponseEntity<Void> markTaskAsCompleted(@PathVariable(value = "id") Long id) {
		taskService.markTaskAsCompleted(id);
		return ResponseEntity.ok().build();

	}

	/**
	 *  Deletes a task with id.
	 *  
	 * @param id The id of the task to be deleted.
     * @return ResponseEntity with HTTP status code indicating the success or failure of the deletion.
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable(value = "id") Long id) {
		taskService.deleteTask(id);
		return ResponseEntity.ok().build();
	}

	/**
	 * Retrieves the all tasks from the list
	 * 
	 * @return  ResponseEntity containing the all task's information
	 */
	@GetMapping()
	public ResponseEntity<List<Task>> getAllTask() {
		List<Task> tasks = taskService.getAllTask();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}

}
