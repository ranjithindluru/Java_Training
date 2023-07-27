package com.user.task.mangement.entity;

public class Project {

	private Long projectId;
	private String name;
	

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project(Long projectId, String name) {
		super();
		this.projectId = projectId;
		this.name = name;
		//this.task = task;
	}

	public Project() {
		super();
	}

	

}
