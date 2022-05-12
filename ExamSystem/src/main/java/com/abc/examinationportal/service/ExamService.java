package com.abc.examinationportal.service;

import java.util.List;

import com.abc.examinationportal.entity.Questions;
import com.abc.examinationportal.entity.Topic;

public interface ExamService  
{
	public List<Questions> getQuestions(int tid);
	public List<Topic> getTopic();
}
