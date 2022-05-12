package com.abc.examinationportal.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

import com.abc.examinationportal.entity.Questions;
import com.abc.examinationportal.entity.Topic;
import com.abc.examinationportal.service.AddQuestionService;


@RestController
@RequestMapping("/rest/api")
public class AddQuestionsController
{
	
	@Autowired
	AddQuestionService aService;
	
	@PostMapping("/addsinglequestion")
	public Questions addQuestion(@RequestBody Questions question)
	{
        Questions que=aService.addQuestion(question);
		return que;
	}
	
	@DeleteMapping("/deletequestion/{qid}")
	public int deleteQuestion(@PathVariable(name="qid") int qid)
	{     // Questions question=aService.searchProductbyId(qid);
	  return aService.deleteQuestionById(qid);
	}
	
	@GetMapping("/getallquestions")
	public List<Questions> getallquestions()
	{
		return aService.getAllQuestions();
	
	}
	@PostMapping("/addtopic")
	public Topic addTopic(@RequestBody Topic topic)
	{
        Topic obj=aService.addTopic(topic);
		return obj;
	}
}
