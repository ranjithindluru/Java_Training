package com.user.task.mangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.task.mangement.entity.Project;
import com.user.task.mangement.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project updateProject(Long projectId, Project project) {
		Project existingProject = projectRepository.findById(projectId);
		if(existingProject != null) {
			existingProject.setName(project.getName());
			return projectRepository.save(existingProject);
		}
		return null; // return project Id is null or Not found.
	}

	@Override
	public Project getProjectId(Long projectId) {
		return projectRepository.findById(projectId);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public void deleteProject(Long projectId) {
		projectRepository.deleteById(projectId);
	}

}
