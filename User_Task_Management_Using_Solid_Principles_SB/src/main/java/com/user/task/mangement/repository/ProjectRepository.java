package com.user.task.mangement.repository;

import java.util.List;

import com.user.task.mangement.entity.Project;

public interface ProjectRepository {

	public Project save(Project project);

	public Project findById(Long id);

	public List<Project> findAll();

	public void deleteById(Long id);
}
