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

import com.user.task.mangement.entity.Project;
import com.user.task.mangement.service.ProjectService;

@RestController
@RequestMapping(value = "/api/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	/**
	 * Creates a new project
	 * 
	 * @param project The project object to be created.
	 * @return ResponseEntity containing the created project's information and HTTP
	 *         status code.
	 */
	@PostMapping()
	public ResponseEntity<Project> saveProject(@RequestBody Project project) {
		Project addProject = projectService.createProject(project);
		return new ResponseEntity<Project>(addProject, HttpStatus.CREATED);
	}

	/**
	 * Update the existing project
	 * 
	 * @param projectId, project The projectId, project object to be created.
	 * @return ResponseEntity containing the update project's information and HTTP
	 *         status code.
	 */
	@PutMapping(value = "/{projectId}")
	public ResponseEntity<Project> updateProject(@PathVariable(value = "projectId") Long projectId,
			@RequestBody Project project) {
		Project existingProject = projectService.updateProject(projectId, project);
		return new ResponseEntity<Project>(existingProject, HttpStatus.OK);
	}

	/**
	 * Retrieves a project by ID.
	 * 
	 * @param projectId The projectId of the project to be retrieved.
	 * @return ResponseEntity containing the project's information if found, or HTTP
	 *         status code 404 if not found.
	 */
	@GetMapping(value = "/{projectId}")
	public ResponseEntity<Project> getProject(@PathVariable(value = "projectId") Long projectId) {
		Project getExistingProject = projectService.getProjectId(projectId);
		if (getExistingProject != null) {
			return new ResponseEntity<Project>(getExistingProject, HttpStatus.OK);
		} else {
			return new ResponseEntity<Project>(getExistingProject, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 *  Deletes a project with projectId.
	 *  
	 * @param projectId The projectId of the project to be deleted.
     * @return ResponseEntity with HTTP status code indicating the success or failure of the deletion.
	 */
	@DeleteMapping(value = "/{projectId}")
	public ResponseEntity<Void> deleteProject(@PathVariable(value = "projectId") Long projectId) {
		projectService.deleteProject(projectId);
		return ResponseEntity.ok().build();
	}
    
	/**
	 * Retrieves the all projects from the list
	 * 
	 * @return  ResponseEntity containing the all project's information
	 */
	@GetMapping()
	public ResponseEntity<List<Project>> getAllProjects() {
		List<Project> projects = projectService.getAllProjects();
		return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
	}

}
