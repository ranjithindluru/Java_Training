package com.user.task.mangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.task.mangement.entity.Task;
import com.user.task.mangement.repository.TaskRepository;
import com.user.task.mangement.response.enums.PriorityLevel;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Long id, Task task) {
		Task existingTask= taskRepository.findById(id);
		if(existingTask != null) {
			existingTask.setTitle(task.getTitle());
			existingTask.setDescription(task.getDescription());
			existingTask.setDueDate(task.getDueDate());
			existingTask.setProjectId(task.getProjectId());
			existingTask.setPriority(task.getPriority());
			existingTask.setCompleted(task.isCompleted());
			return taskRepository.save(existingTask);
		}
		return null; // return task Id is not found or null
	}

	@Override
	public Task getTaskId(Long id) {
		return taskRepository.findById(id);
	}

	@Override
	public List<Task> getPriorityTask(PriorityLevel priorityLevel) {
		return taskRepository.findByPriority(priorityLevel);
	}

	@Override
	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}
	@Override
    public void markTaskAsCompleted(Long id) {
        Task task = taskRepository.findById(id);
        if (task != null) {
            task.setCompleted(true);
            taskRepository.save(task);
        }
    }

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

}
