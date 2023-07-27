package com.user.task.mangement.repository;

import java.util.List;

import com.user.task.mangement.entity.Task;
import com.user.task.mangement.response.enums.PriorityLevel;

public interface TaskRepository {

	public Task save(Task task);

	public Task findById(Long id);

	public List<Task> findByProjectId(Long projectId);

	public List<Task> findByPriority(PriorityLevel priority);

	public List<Task> findAll();

	public void deleteById(Long id);
}
