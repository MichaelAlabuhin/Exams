package com.exams.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exams.dao.SubjectRepository;
import com.exams.domain.Subject;

@Service
public class SubjectService {
	
	private Logger logger = LoggerFactory.getLogger(ApplicantService.class);
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public void saveSubject(Subject subject) {
		logger.info("Save subject {} : " + subject);
		subjectRepository.save(subject);
	}
	
	public Subject findSubjectById(Integer subjectId) {
		logger.info("Find subject by id {} : " + subjectId);
		return subjectRepository.findById(subjectId).get();
	}
	
	public List<Subject> findSubjectsByFacultyId(Integer facultyId) {
		logger.info("Find all subjects by faculty-id {} : " + facultyId);
		return subjectRepository.findSubjectsByFacultyId(facultyId);
	}
	
	public List<Subject> findSubjectsByApplicantId(Integer applicantId) {
		logger.info("Find all subjects by applicant-id {} : " + applicantId);
		return subjectRepository.findSubjectsByApplicantId(applicantId);
	}	
	
	public void deleteSubjectByApplicantId(Integer applicantId) {
		logger.info("Delete subject by applicant-id {} : " + applicantId);
		subjectRepository.deleteSubjectByApplicantId(applicantId);
	}
	
	public void deleteSubjectById(Integer subjectId) {
		logger.info("Delete subject by subject-id {} : " + subjectId);
		subjectRepository.deleteById(subjectId);
	}
}
