package com.style.bean;

public class InfoBean {
	private int userId ;
	private String name ;
	private int sex;
	private int age;
	private String phoneNumber;
	private String post;
	private String section;
	private String pay ;
	private String hiredate;
	private String share ;
	private int group_leaderId ;
	
	public int getGroup_leaderId() {
		return group_leaderId;
	}

	public void setGroup_leaderId(int group_leaderId) {
		this.group_leaderId = group_leaderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getShare() {
		return share;
	}

	public void setShare(String share) {
		this.share = share;
	}

	@Override
	public String toString() {
		return "InfoBean [userId=" + userId + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", phoneNumber=" + phoneNumber + ", post="
				+ post + ", section=" + section + ", pay=" + pay
				+ ", hiredate=" + hiredate + ", share=" + share + "]";
	}


}
