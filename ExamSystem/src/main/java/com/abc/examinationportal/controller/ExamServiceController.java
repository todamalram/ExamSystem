package com.abc.examinationportal.controller;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.examinationportal.entity.Questions;
import com.abc.examinationportal.entity.Topic;
import com.abc.examinationportal.service.ExamService;
@RestController
@RequestMapping("/rest/api")
public class ExamServiceController {
	@Autowired
	ExamService eService;

	@GetMapping("/getQuestions/{tid}")
	public List<Questions> getQuestions(@PathVariable("tid") int tid)
	{
		return eService.getQuestions(tid);
	}

	@GetMapping("/getTopic")
	public List<Topic> getTopics()
	{
		return eService.getTopic();
	}
}
