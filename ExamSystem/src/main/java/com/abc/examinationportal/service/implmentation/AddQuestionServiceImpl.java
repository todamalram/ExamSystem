package com.abc.examinationportal.service.implmentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.examinationportal.entity.Questions;
import com.abc.examinationportal.entity.Topic;
import com.abc.examinationportal.repository.AddQuestionRepo;
import com.abc.examinationportal.repository.TopicRepo;
import com.abc.examinationportal.service.AddQuestionService;
@Service
public class AddQuestionServiceImpl implements AddQuestionService
{
	@Autowired
	AddQuestionRepo questionRepo;

	@Autowired
	TopicRepo topicRepo;
	@Override
	public Questions addQuestion(Questions questions) {
		return questionRepo.save(questions);
	}

	@Override
	public List<Questions> getAllQuestions() {
		 
		return questionRepo.findAll();
	}

	@Override
	public Questions updateQuestions(Questions questions) {
		Optional<Questions> optionalQuestions=questionRepo.findById(questions.getQid());
		if(optionalQuestions.isEmpty())
		{
			 return null;
		}
		return questionRepo.save(questions);
	}

	@Override
	public int deleteQuestionById(int qid) {
		Optional<Questions> optionalQuestions=questionRepo.findById(qid);
		if(optionalQuestions.isPresent())
		{
			questionRepo.deleteById(qid);;
			 return qid;
		}
		return 0;
	}
	@Override
	public Topic addTopic(Topic topic)
	{
		return topicRepo.save(topic);
	}
}
