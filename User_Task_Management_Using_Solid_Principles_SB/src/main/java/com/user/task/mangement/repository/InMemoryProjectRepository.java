package com.user.task.mangement.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.user.task.mangement.entity.Project;

@Repository
public class InMemoryProjectRepository implements ProjectRepository {
	
	/**
	*A HashMap that stores projects with their respective IDs as keys.
	*/
    private Map<Long, Project> projects = new HashMap<>();
    
    /**
    * A counter to keep track of the next available project ID.
    */
    private Long idCounter = 1L;

    @Override
    public Project save(Project project) {
        if (project.getProjectId() == null) {
            project.setProjectId(idCounter);
        }
        projects.put(project.getProjectId(), project);
        return project;
    }

    @Override
    public Project findById(Long id) {
        return projects.get(id);
    }

    @Override
    public List<Project> findAll() {
        return new ArrayList<>(projects.values());
    }

    @Override
    public void deleteById(Long id) {
        projects.remove(id);
    }
}
