package com.exams.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import com.exams.domain.Applicant;

public class ApplicantDTO {
	
	public static Applicant createEntityApplicant(
			MultipartFile image,
			String firstName,
			String lastName,
			String email,
			String dateOfBirth,
			String phone,
			String address,
			Integer faculty_id,
			String verified) throws IOException {		
		
		Applicant applicant = new Applicant();
		applicant.setFirstName(firstName);
		applicant.setLastName(lastName);
		applicant.setEmail(email);
		applicant.setDateOfBirth(dateOfBirth);
		applicant.setPhone(phone);
		applicant.setAddress(address);
		applicant.setFaculty_id(faculty_id);
		applicant.setVerified(verified);
		applicant.setAverage((double) 0);
		applicant.setEncodedImage(Base64.getEncoder().encodeToString(image.getBytes()));
		
		return applicant;
	}
}
