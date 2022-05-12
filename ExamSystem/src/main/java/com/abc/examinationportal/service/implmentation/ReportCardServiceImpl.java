package com.abc.examinationportal.service.implmentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.examinationportal.entity.Reportcard;
import com.abc.examinationportal.repository.ReportCardRepo;
import com.abc.examinationportal.service.ReportCardService;
@Service
public class ReportCardServiceImpl implements ReportCardService  {

	@Autowired
	ReportCardRepo repo;
	@Override
	public Reportcard getReportcard(int rid) {
		Optional<Reportcard> obj= repo.findById(rid);
		return obj.get();
	}

	@Override
	public Reportcard addReportCard(Reportcard rep) {
		 return repo.save(rep);
		 
	}
	
	
	@Override
	public List<Reportcard> getReportByUserid(int userid) {
		
		return repo.findByUserid(userid);
		//return null;
	}

}
