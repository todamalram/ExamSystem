package com.abc.examinationportal.service;

import java.util.List;

import com.abc.examinationportal.entity.Questions;
import com.abc.examinationportal.entity.Topic;

public interface AddQuestionService {
	public  Questions addQuestion(Questions questions);
		public List< Questions> getAllQuestions();
		public  Questions updateQuestions(Questions questions);
		public int deleteQuestionById(int qid);
		public Topic addTopic(Topic topic);
}

