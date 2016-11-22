package com.style.bean;

public class TInform {

	private int id ;
	private int userId ; 
	private String time ;
	private String content ;
	private String title ;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "TInform [id=" + id + ", userId=" + userId + ", time=" + time
				+ ", content=" + content + ", title=" + title + "]";
	}
	
	
}
