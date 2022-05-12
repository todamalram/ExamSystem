package com.abc.examinationportal.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.examinationportal.entity.Reportcard;
import com.abc.examinationportal.service.ReportCardService;
 
@RestController
@RequestMapping("/rest/api")
public class ReportCardController {
	@Autowired
	ReportCardService rService;

	@GetMapping("/reportcard/{rid}")
	public Reportcard getReportcard(@PathVariable(name = "rid") int rid)
	{
		return rService.getReportcard(rid);
	}

	@PostMapping("/reportcard")
	public Reportcard addProduct(@RequestBody Reportcard rep)
	{
		return rService.addReportCard(rep);
	}
	
	@GetMapping("/singlereportcard/{userid}")
	public List<Reportcard> getReportByUserid(@PathVariable(name = "userid") int userid)
	{
		return rService.getReportByUserid(userid);
	}
}
