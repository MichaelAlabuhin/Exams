package com.exams.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exams.domain.Applicant;
import com.exams.domain.Subject;
import com.exams.service.ApplicantService;
import com.exams.service.SubjectService;

@Controller
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;	
	
	@Autowired
	ApplicantService applicantService;	
	
	@RequestMapping(value = "/addSubject", method = RequestMethod.POST)
	public ModelAndView addApplicant(@Valid @ModelAttribute("subject") Subject subject, BindingResult bindingResult) {
		List<Subject> subjectsOfApplicant = subjectService.findSubjectsByApplicantId(subject.getApplicant_id());
		for (Subject currentSubjectOfApplicant : subjectsOfApplicant) {
			if (currentSubjectOfApplicant.getName().equals(subject.getName())) {
				subjectService.deleteSubjectById(currentSubjectOfApplicant.getId());
				break;
			}				
		}
		subjectService.saveSubject(subject);		
		ModelAndView map = new ModelAndView("addApplicant");
		List<Subject> subjectsOfApplicantAfterSave = subjectService.findSubjectsByApplicantId(subject.getApplicant_id());
		List<Subject> emptySubjects = subjectService.findSubjectsByFacultyId(subject.getFaculty_id());
		Double summMark = (double) 0;
		int quantity = 0;
		Double averageMark = (double) 0;
		for (Subject currentEmptySubject : emptySubjects) {
			boolean findSubject = false;
			for (Subject currentSubjectOfApplicant : subjectsOfApplicantAfterSave) {
				if (currentSubjectOfApplicant.getName().equals(currentEmptySubject.getName())) {
					summMark += currentSubjectOfApplicant.getMark();
					quantity += 1;
					findSubject = true;
					break;
				}				
			}
			if (!findSubject) {
				subjectsOfApplicantAfterSave.add(currentEmptySubject);
			}					
		}
		if (quantity !=0) {
			averageMark = summMark / quantity;
		}		
		applicantService.updateAverageMarkById(subject.getApplicant_id(), averageMark);		 
		map.addObject("subjects", subjectsOfApplicantAfterSave);
		map.addObject("averageMark", averageMark);
		map.addObject("mode", "ADD_SUBJECTS");		
		return map;		
	}
	
	@RequestMapping(value = "/goToHome", method = RequestMethod.POST)
	public ModelAndView goToHome() {		
		return new ModelAndView("redirect:/home");	
	}
	
	@RequestMapping(value = "/updateSubject", method = RequestMethod.POST)
	public ModelAndView updateApplicant(@Valid @ModelAttribute("subject") Subject subject, BindingResult bindingResult) {	
		subjectService.saveSubject(subject);		
		ModelAndView map = new ModelAndView("applicant");		
		List<Subject> subjects = subjectService.findSubjectsByApplicantId(subject.getApplicant_id());		
		Double summMark = (double) 0;
		int quantity = 0;
		Double averageMark = (double) 0;
		for (Subject currentSubject : subjects) {			
			summMark += currentSubject.getMark();
			quantity += 1;			
		}
		if (quantity !=0) {
			averageMark = summMark / quantity;
		}	
		applicantService.updateAverageMarkById(subject.getApplicant_id(), averageMark);
		Applicant applicant = applicantService.findApplicantById(subject.getApplicant_id());	
		map.addObject("subjects", subjects);
		map.addObject("applicant", applicant);
		map.addObject("mode", "UPDATE_SUBJECTS");
		return map;		
	}
}
