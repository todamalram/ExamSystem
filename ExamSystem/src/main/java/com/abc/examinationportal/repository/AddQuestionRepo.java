package com.abc.examinationportal.repository;
 
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abc.examinationportal.entity.Questions;

@Repository
public interface AddQuestionRepo extends JpaRepository<Questions,Integer>
{
	@Query("select q from Questions q where q.topic.tid = :tid")
	public List<Questions> findQuestionsByTid(@Param("tid")int tid);
}
