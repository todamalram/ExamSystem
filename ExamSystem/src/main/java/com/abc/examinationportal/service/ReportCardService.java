package com.abc.examinationportal.service;

import java.util.List;

import com.abc.examinationportal.entity.Reportcard;

public interface ReportCardService 
{
	 public Reportcard getReportcard(int rid);
	
	 public Reportcard addReportCard(Reportcard rep);
	 
	 public List<Reportcard> getReportByUserid(int userid);
	 
	

}
