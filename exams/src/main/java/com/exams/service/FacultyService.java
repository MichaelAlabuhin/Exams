package com.exams.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exams.dao.ApplicantRepository;
import com.exams.dao.FacultyRepository;
import com.exams.dao.SubjectRepository;
import com.exams.domain.Applicant;
import com.exams.domain.Faculty;
import com.exams.domain.Subject;
import com.exams.domain.YesNo;

@Service
public class FacultyService {
	
	private Logger logger = LoggerFactory.getLogger(FacultyService.class);
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	public void saveFaculty(Faculty faculty) {
		logger.info("Save faculty {} : " + faculty);
		facultyRepository.save(faculty);
    }
	
	public Faculty findFacultyById(Integer facultyId) {	
		logger.info("Find faculty by id {} : " + facultyId);
		Faculty faculty = facultyRepository.findById(facultyId).get();
		return faculty;
	}
	
	public List<Faculty> getAllFaculties() {
		logger.info("Get all faculties");
		return facultyRepository.findAll();
	}
	
	public void firstInitialization() {
		logger.info("First initialization. Adding faculties and applicants");
		Faculty faculty1 = new Faculty("Faculty of Biology", 5);
		facultyRepository.save(faculty1);
		Subject subject1 = new Subject("Biology", faculty1.getId());
		subjectRepository.save(subject1);
		Subject subject2 = new Subject("Chemistry", faculty1.getId());
		subjectRepository.save(subject2);
		Subject subject3 = new Subject("English", faculty1.getId());
		subjectRepository.save(subject3);
		Subject subject4 = new Subject("Mathematics", faculty1.getId());
		subjectRepository.save(subject4);		

		Faculty faculty2 = new Faculty("Faculty of Architecture", 5);
		facultyRepository.save(faculty2);
		Subject subject5 = new Subject("Art", faculty2.getId());
		subjectRepository.save(subject5); 
		Subject subject6 = new Subject("Drawing", faculty2.getId()); 
		subjectRepository.save(subject6);
		Subject subject7 = new Subject("English", faculty2.getId());
		subjectRepository.save(subject7); 
		Subject subject8 = new Subject("Mathematics", faculty2.getId()); 
		subjectRepository.save(subject8);		
		
		Faculty faculty3 = new Faculty("Faculty of Education", 3); 
		facultyRepository.save(faculty3);
		Subject subject9 = new Subject("Literature", faculty3.getId());
		subjectRepository.save(subject9); 
		Subject subject10 = new Subject("English", faculty3.getId()); 
		subjectRepository.save(subject10);
		Subject subject11 = new Subject("Mathematics", faculty3.getId());
		subjectRepository.save(subject11);		
		
		Applicant applicant1 = new Applicant("Petr", "Simonov", "petr@gmail.com", "12.05.2002", "Odesa, Main str., 19", "+380505670945", faculty3.getId(), YesNo.YES.name(), (double) 0);
		applicant1.setAverage(8.0);
		applicantRepository.save(applicant1);
		Subject subject91 = new Subject("Literature", 8, faculty3.getId(), applicant1.getId());
		subjectRepository.save(subject91);
		Subject subject101 = new Subject("English", 9, faculty3.getId(), applicant1.getId()); 
		subjectRepository.save(subject101);
		Subject subject111 = new Subject("Mathematics", 7, faculty3.getId(), applicant1.getId());
		subjectRepository.save(subject111);		
		
		Applicant applicant2 = new Applicant("Olga", "Dub", "dub@mail.com", "06.03.2003", "Lutzk, First square, 11", "0505670945, +390678934", faculty3.getId(), YesNo.YES.name(), (double) 0);
		applicant2.setAverage(8.0);
		applicantRepository.save(applicant2);
		Subject subject92 = new Subject("Literature", 6, faculty3.getId(), applicant2.getId());
		subjectRepository.save(subject92);
		Subject subject102 = new Subject("English", 10, faculty3.getId(), applicant2.getId()); 
		subjectRepository.save(subject102);
		Subject subject112 = new Subject("Mathematics", 8, faculty3.getId(), applicant2.getId());
		subjectRepository.save(subject112);
		
		Applicant applicant3 = new Applicant("Ivan", "Belyi", "bel@gmail.com", "02.03.2001", "Lviv, Kaliny prsp., 25", "0675670945", faculty3.getId(), YesNo.YES.name(), (double) 0);
		applicant3.setAverage(10.0);
		applicantRepository.save(applicant3);
		Subject subject93 = new Subject("Literature", 11, faculty3.getId(), applicant3.getId());
		subjectRepository.save(subject93);
		Subject subject103 = new Subject("English", 9, faculty3.getId(), applicant3.getId()); 
		subjectRepository.save(subject103);
		Subject subject113 = new Subject("Mathematics", 10, faculty3.getId(), applicant3.getId());
		subjectRepository.save(subject113);
		
		Applicant applicant4 = new Applicant("Andrey", "Kulik", "andre_kul@gmail.com", "10.10.2003", "Lviv, Svobody str., 1", "0955670945", faculty3.getId(), YesNo.YES.name(), (double) 0);
		applicant4.setAverage(9.0);
		applicantRepository.save(applicant4);
		Subject subject94 = new Subject("Literature", 9, faculty3.getId(), applicant4.getId());
		subjectRepository.save(subject94);
		Subject subject104 = new Subject("English", 1, faculty3.getId(), applicant4.getId()); 
		subjectRepository.save(subject104);
		Subject subject114 = new Subject("Mathematics", 7, faculty3.getId(), applicant4.getId());
		subjectRepository.save(subject114);		
		
		Faculty faculty4 = new Faculty("Faculty of Mathematics", 5);
		facultyRepository.save(faculty4);
		Subject subject12 = new Subject("Physics", faculty4.getId());
		subjectRepository.save(subject12); 
		Subject subject13 = new Subject("Geometry", faculty4.getId()); 
		subjectRepository.save(subject13);		
		Subject subject14 = new Subject("English", faculty4.getId());
		subjectRepository.save(subject14);
		Subject subject15 = new Subject("Mathematics", faculty4.getId());
		subjectRepository.save(subject15); 		
		 
		Faculty faculty5 = new Faculty("Faculty of Psychology", 4);
		facultyRepository.save(faculty5);
		Subject subject16 = new Subject("Psychology", faculty5.getId());
		subjectRepository.save(subject16); 
		Subject subject17 = new Subject("English", faculty5.getId()); 
		subjectRepository.save(subject17);
		Subject subject18 = new Subject("Mathematics", faculty5.getId());
		subjectRepository.save(subject18);		
		
		Faculty faculty6 = new Faculty("Faculty of Physics", 4);
		facultyRepository.save(faculty6);
		Subject subject19 = new Subject("Physics", faculty6.getId());
		subjectRepository.save(subject19); 			
		Subject subject20 = new Subject("English", faculty6.getId());
		subjectRepository.save(subject20);
		Subject subject21 = new Subject("Mathematics", faculty6.getId());
		subjectRepository.save(subject21);		
	}
}
