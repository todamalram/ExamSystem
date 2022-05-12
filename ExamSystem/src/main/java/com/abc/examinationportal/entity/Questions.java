package com.abc.examinationportal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "questions")
public class Questions
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qid;
	private String qname;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String Correct_Ans;
	@OneToOne
	@JoinColumn(name="tid")
	private Topic topic;
	 

	public Questions()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Questions(int qid, String qname, String option1, String option2, String option3, String option4,
			String correct_Ans, Topic topic) {
		super();
		this.qid = qid;
		this.qname = qname;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		Correct_Ans = correct_Ans;
		this.topic = topic;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}
	@JsonIgnore
	public String getCorrect_Ans() {
		return Correct_Ans;
	}

	public void setCorrect_Ans(String correct_Ans) {
		Correct_Ans = correct_Ans;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Questions [qid=" + qid + ", qname=" + qname + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", Correct_Ans=" + Correct_Ans + ", topic=" + topic
				+ "]";
	}


	 

}
