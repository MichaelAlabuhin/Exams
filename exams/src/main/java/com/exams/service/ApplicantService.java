package com.exams.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exams.dao.ApplicantRepository;
import com.exams.domain.Applicant;

@Service
public class ApplicantService {
	
	private Logger logger = LoggerFactory.getLogger(ApplicantService.class);
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	public Applicant saveApplicant(Applicant applicant) {
		logger.info("Save applicant {} : " + applicant);
		return applicantRepository.save(applicant);
	}
	
	public List<Applicant> getAllApplicants() {
		logger.info("Get all applicants");
		return applicantRepository.findAll();
	}
	
	public void deleteApplicantById(Integer applicantId) {
		logger.info("Delete applicant by id {} : " + applicantId);
		applicantRepository.deleteById(applicantId);
	}
	
	public Applicant findApplicantById(Integer applicantId) {
		logger.info("Find applicant by id {} : " + applicantId);
		return applicantRepository.findById(applicantId).get();
	}	
	
	public void updateAverageMarkById(Integer applicantId, Double average) {
		logger.info("Update average mark for applicant by id {} : " + applicantId);
		applicantRepository.updateAverageMarkById(applicantId, average); 
	}
	
	public List<Applicant> findApplicantsByFacultyId(Integer facultyId) {
		logger.info("Find all applicants for faculty by id {} : " + facultyId);
		return applicantRepository.findApplicantsByFacultyId(facultyId);
	}
}
