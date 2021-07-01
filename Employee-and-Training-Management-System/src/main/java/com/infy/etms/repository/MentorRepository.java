package com.infy.etms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.etms.entity.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor,Integer> {
	
	@Query("select m from Mentor m where m.mentorId=?1")
	List<Mentor> getMentorAndEmployeeByCourseId(Integer mentorId, Integer pageNo);
	

}
