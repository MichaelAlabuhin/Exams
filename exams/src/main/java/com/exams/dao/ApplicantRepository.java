package com.exams.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.exams.domain.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Applicant a SET a.average=:average WHERE a.id=:applicantId")
	int updateAverageMarkById(int applicantId, Double average);
	
	@Query("SELECT a FROM Applicant a WHERE a.faculty_id=:facultyId AND a.verified LIKE 'YES'")
	List<Applicant> findApplicantsByFacultyId(@Param("facultyId") int facultyId);
}
