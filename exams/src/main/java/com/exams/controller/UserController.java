package com.exams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exams.domain.Applicant;
import com.exams.domain.User;
import com.exams.service.ApplicantService;
import com.exams.service.FacultyService;
import com.exams.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	FacultyService facultyService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.saveUser(userForm);
        return "redirect:/home";
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Invalid username or password!");
        if (logout != null)
            model.addAttribute("message", "Logout successfully");
        return "login";
    }

    @RequestMapping(value ="/home", method = RequestMethod.GET)
    public ModelAndView home() {
    	ModelAndView map = new ModelAndView("home");
    	List<Applicant> applicants = applicantService.getAllApplicants();
    	for (Applicant applicant : applicants) {
			applicant.setFacultyName(facultyService.findFacultyById(applicant.getFaculty_id()).getName());
		}
    	map.addObject("applicants", applicants);
		return map;
    }
}
