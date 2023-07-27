package com.user.task.mangement.service;

import java.util.List;

import com.user.task.mangement.entity.Task;
import com.user.task.mangement.response.enums.PriorityLevel;

public interface TaskService {
	
	public Task createTask(Task task);
	
	public Task updateTask(Long id, Task task);
	
	public Task getTaskId(Long id);
	
	public List<Task> getPriorityTask(PriorityLevel priorityLevel);
	
	public List<Task> getAllTask();
	
	public void markTaskAsCompleted(Long id);
	
	public void deleteTask(Long id);

}
