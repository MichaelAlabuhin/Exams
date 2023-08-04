package com.exams.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.exams.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{

	@Query("SELECT s FROM Subject s WHERE s.applicant_id=:applicantId")
	List<Subject> findSubjectsByApplicantId(@Param("applicantId") int applicantId);	
	
	@Query("SELECT s FROM Subject s WHERE s.faculty_id=:facultyId AND s.applicant_id=0")
	List<Subject> findSubjectsByFacultyId(@Param("facultyId") int facultyId);	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Subject s WHERE s.applicant_id=:applicantId")
	int deleteSubjectByApplicantId(int applicantId);
}
