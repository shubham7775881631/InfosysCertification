package com.infy.etms.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.infy.etms.entity.Mentor;


public interface MentorRepository extends JpaRepository<Mentor,Integer> {
	
	@Query("select m from Mentor m where m.mentorId=?1")
	List<Mentor> getMentorByMentorIdAndCourseId(Integer mentorId, Pageable pageable);
	

}
