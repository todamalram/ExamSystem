package com.abc.examinationportal.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.abc.examinationportal.entity.Reportcard;

@Repository
public interface ReportCardRepo extends JpaRepository<Reportcard,Integer>
{
	@Query("select r from Reportcard r where r.users.uid = :userid")
	public List<Reportcard> findByUserid(@Param("userid")int userid);
}
