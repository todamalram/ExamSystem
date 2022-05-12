package com.abc.examinationportal.entity;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reportcard")
public class Reportcard
{
	@Id
	private int rid;
	@OneToOne
	@JoinColumn(name="tid")
	private Topic topic;
	private int marks;
	private String remarks;
	@OneToOne
	@JoinColumn(name="uid")
	private UserEntity users;

	public Reportcard()
	{
		super();
	}

	public Reportcard(int rid, UserEntity userid, Topic topic, int marks, String remarks) {
		super();
		this.rid = rid;
		this.topic = topic;
		this.marks = marks;
		this.remarks = remarks;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Reportcard [rid=" + rid + ", topic=" + topic + ", marks=" + marks + ", remarks="
				+ remarks + "]";
	}  
}
