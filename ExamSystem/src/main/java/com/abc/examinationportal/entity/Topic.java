package com.abc.examinationportal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
public class Topic
{
	@Id
	private int tid;
	private String tname;

	public Topic()
	{
		super();
	}

	public Topic(int tid, String tname, int tlevel)
	{
		super();
		this.tid = tid;
		this.tname = tname;
	}

	public int getTid()
	{
		return tid;
	}

	public void setTid(int tid)
	{
		this.tid = tid;
	}

	public String getTname()
	{
		return tname;
	}

	public void setTname(String tname)
	{
		this.tname = tname;
	} 
	@Override
	public String toString()
	{
		return "Topic [tid=" + tid + ", tname=" + tname + "]";
	}

}
