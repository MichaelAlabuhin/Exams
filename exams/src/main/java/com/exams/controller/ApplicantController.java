package com.exams.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.exams.domain.Applicant;
import com.exams.domain.ApplicantStatus;
import com.exams.domain.Faculty;
import com.exams.domain.Subject;
import com.exams.domain.YesNo;
import com.exams.service.ApplicantDTO;
import com.exams.service.ApplicantService;
import com.exams.service.FacultyService;
import com.exams.service.SubjectService;

@Controller
public class ApplicantController {
	
	@Autowired
	ApplicantService applicantService;
	
	@Autowired
	FacultyService facultyService;
	
	@Autowired
	SubjectService subjectService;
	
	@RequestMapping(value = "/addApplicant", method = RequestMethod.POST)
	public ModelAndView addApplicant(
			@RequestParam MultipartFile image,
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam String email,
			@RequestParam String dateOfBirth,
			@RequestParam String phone,
			@RequestParam String address,
			@RequestParam Integer faculty_id) throws IOException {
		ModelAndView map = new ModelAndView("addApplicant");
		Applicant applicant = ApplicantDTO.createEntityApplicant(image, firstName, lastName, email, dateOfBirth, phone, address, faculty_id, YesNo.NO.name());
		applicantService.saveApplicant(applicant);
		List<Subject> subjects = subjectService.findSubjectsByFacultyId(applicant.getFaculty_id());
		map.addObject("subjects", subjects);
		map.addObject("applicant", applicant);
		map.addObject("subject", new Subject());
		map.addObject("mode", "ADD_SUBJECTS");		
		return map;
	}	
	
	@RequestMapping(value ="/fillApplicant", method = RequestMethod.GET)
    public ModelAndView fillApplicant(@ModelAttribute("id") Integer facultyId) {
		ModelAndView map = new ModelAndView("addApplicant"); 
		Faculty currentFaculty = facultyService.findFacultyById(facultyId); 
		map.addObject("faculty", currentFaculty); 
		map.addObject("mode", "FILL_APPLICANT"); 
		return map;
    }
	
	@RequestMapping(value ="/addApplicant", method = RequestMethod.GET)
    public ModelAndView choiseOfFaculty() {		
		ModelAndView map = new ModelAndView("addApplicant");
		map.addObject("faculties", facultyService.getAllFaculties());
		map.addObject("mode", "CHOOSE_FACULTY");		
		return map;
    }  
	
	@RequestMapping(value ="/delete", method = RequestMethod.GET)
    public ModelAndView deleteApplicant(@ModelAttribute("id") Integer applicantId) {
		subjectService.deleteSubjectByApplicantId(applicantId);
		applicantService.deleteApplicantById(applicantId);
		ModelAndView map = new ModelAndView("home");
		List<Applicant> applicants = applicantService.getAllApplicants();
		for (Applicant applicant : applicants) {
			applicant.setFacultyName(facultyService.findFacultyById(applicant.getFaculty_id()).getName());
		}
		map.addObject("applicants", applicants);
		return map;
    }
	
	@RequestMapping(value ="/update", method = RequestMethod.GET)
    public ModelAndView updateApplicant(@ModelAttribute("id") Integer applicantId) {
		ModelAndView map = new ModelAndView("applicant");
		Applicant applicant = applicantService.findApplicantById(applicantId);
		Faculty faculty = facultyService.findFacultyById(applicant.getFaculty_id());		
		map.addObject("listOfYesNo", new ArrayList<YesNo>(Arrays.asList(YesNo.values())));
		map.addObject("applicant", applicant);
		map.addObject("faculty", faculty);
		map.addObject("mode", "UPDATE_APPLICANT");
		return map;
    }
	
	@RequestMapping(value = "/updateApplicant", method = RequestMethod.POST)
	public ModelAndView updateApplicant(@Valid @ModelAttribute("applicant") Applicant applicant, BindingResult bindingResult) {
		applicantService.saveApplicant(applicant);
		ModelAndView map = new ModelAndView("applicant");
		List<Subject> subjects = subjectService.findSubjectsByApplicantId(applicant.getId());		
		map.addObject("subjects", subjects);
		map.addObject("applicant", applicant);
		map.addObject("subject", new Subject());
		map.addObject("mode", "UPDATE_SUBJECTS");
		return map;
	}
	
	@RequestMapping(value ="/finalStatement", method = RequestMethod.GET)
    public ModelAndView choiseFacultyForReport() {		
		ModelAndView map = new ModelAndView("finalStatement");
		map.addObject("faculties", facultyService.getAllFaculties());
		map.addObject("mode", "CHOOSE_FACULTY");		
		return map;
    }
	
	@RequestMapping(value ="/generateStatement", method = RequestMethod.GET)
    public ModelAndView generateStatement(@ModelAttribute("id") Integer facultyId) {
		ModelAndView map = new ModelAndView("finalStatement"); 
		Faculty faculty = facultyService.findFacultyById(facultyId);
		List<Applicant> applicants = applicantService.findApplicantsByFacultyId(facultyId);		
		for (int i = 0; i < applicants.size(); i++) {
	        int pos = i;
	        Applicant maxAverage = applicants.get(i);
	        for (int j = i + 1; j < applicants.size(); j++) {
	            if (applicants.get(j).getAverage() > maxAverage.getAverage()) {
	                pos = j;
	                maxAverage = applicants.get(j);
	            }
	        }
	        applicants.set(pos, applicants.get(i));
	        applicants.set(i, maxAverage);
	    }
		int seatCapacity = 1;
		for (Applicant applicant : applicants) {
			if (seatCapacity > faculty.getSeatCapacity()) {
				applicant.setStatus(ApplicantStatus.Rejected.name());
			} else {
				applicant.setStatus(ApplicantStatus.Enrolled.name());
			}			
			seatCapacity += 1;
		}
		map.addObject("applicants", applicants);
		map.addObject("faculty", faculty); 
		map.addObject("mode", "GENERATE_STATEMENT"); 
		return map;
    }	
}


