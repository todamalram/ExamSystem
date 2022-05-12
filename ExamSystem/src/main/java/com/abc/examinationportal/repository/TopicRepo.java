package com.abc.examinationportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.examinationportal.entity.Topic;

public interface TopicRepo extends JpaRepository<Topic,Integer> 
{
	
}
