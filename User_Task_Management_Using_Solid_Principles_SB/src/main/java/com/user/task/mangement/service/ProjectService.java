package com.user.task.mangement.service;

import java.util.List;

import com.user.task.mangement.entity.Project;

public interface ProjectService {
	
	public Project createProject(Project project);
	
	public Project updateProject(Long projectId, Project project);
	
	public Project getProjectId(Long projectId);
	
	public List<Project> getAllProjects();
	
	public void deleteProject(Long projectId);

}
