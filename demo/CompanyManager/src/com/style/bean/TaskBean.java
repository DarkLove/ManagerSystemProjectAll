package com.style.bean;

public class TaskBean {
	private String id ;
	private String userId ;
	private String taskTitle ;
	private String state ;
	private String startTime ;
	private String endTime ;
	private String issueMan ;
	private String taskContent ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getIssueMan() {
		return issueMan;
	}
	public void setIssueMan(String issueMan) {
		this.issueMan = issueMan;
	}
	public String getTaskContent() {
		return taskContent;
	}
	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}
	@Override
	public String toString() {
		return "TaskBean [id=" + id + ", userId=" + userId + ", taskTitle="
				+ taskTitle + ", state=" + state + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", issueMan=" + issueMan
				+ ", taskContent=" + taskContent + "]";
	}
	
	
}
