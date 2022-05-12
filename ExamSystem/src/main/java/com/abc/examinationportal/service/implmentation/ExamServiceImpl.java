package com.abc.examinationportal.service.implmentation;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.examinationportal.entity.Questions;
import com.abc.examinationportal.entity.Topic;
import com.abc.examinationportal.repository.AddQuestionRepo;
import com.abc.examinationportal.repository.TopicRepo;
import com.abc.examinationportal.service.ExamService;
@Service
public class ExamServiceImpl implements ExamService
{
	@Autowired
	AddQuestionRepo questionRepo;
	@Autowired
	TopicRepo topicRepo;
	@Override
	public List<Questions> getQuestions(int tid)
	{
		List <Questions> questions=questionRepo.findQuestionsByTid(tid);
		Collections.shuffle(questions);
		return questions;
	}

	@Override
	public List<Topic> getTopic()
	{
		return topicRepo.findAll();
	}
}
