package com.exams;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.exams.domain.Applicant;
import com.exams.domain.Faculty;
import com.exams.domain.Subject;
import com.exams.domain.User;
import com.exams.domain.UserRole;
import com.exams.domain.YesNo;
import com.exams.service.ApplicantService;
import com.exams.service.FacultyService;
import com.exams.service.SubjectService;
import com.exams.service.UserService;
import com.exams.dao.ApplicantRepository;
import com.exams.dao.FacultyRepository;
import com.exams.dao.SubjectRepository;
import com.exams.dao.UserRepository;

@SpringBootTest
class ExamsApplicationTests {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ApplicantRepository applicantRepository;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ApplicantService applicantService;
	
	@Autowired
	FacultyService facultyService;
	
	@Autowired
	SubjectService subjectService;
	
	@Test
	void testSaveApplicant() {
		
		List<Applicant> listOfApplicants = applicantRepository.findAll();	
		int countOfApplicants = listOfApplicants.size();
		assertThat(listOfApplicants, hasSize(countOfApplicants)); 
		
		Applicant testApplicant1 = new Applicant("Anna", "Domiv", "anna@gmail.com", "10.07.2007", "Lviv, Main str., 19", "+385605670945", 0, YesNo.YES.name(), (double) 0);
		applicantService.saveApplicant(testApplicant1);
		countOfApplicants = countOfApplicants + 1;
		listOfApplicants = applicantRepository.findAll();
		assertThat(listOfApplicants, hasSize(countOfApplicants));
		
		Applicant lastApplicant = listOfApplicants.get(countOfApplicants-1);
		assertTrue(lastApplicant.getEmail().equals(testApplicant1.getEmail()));
		assertTrue(lastApplicant.getFirstName().equals(testApplicant1.getFirstName()));
		assertTrue(lastApplicant.getLastName().equals(testApplicant1.getLastName()));
		assertTrue(lastApplicant.getDateOfBirth().equals(testApplicant1.getDateOfBirth()));
		assertTrue(lastApplicant.getAddress().equals(testApplicant1.getAddress()));	
		assertTrue(lastApplicant.getPhone().equals(testApplicant1.getPhone()));	
		
		applicantRepository.delete(testApplicant1);
	}
	
	@Test
	void testUpdateAverageMarkByApplicantId() {
		
		List<Applicant> listOfApplicants = applicantRepository.findAll();	
		int countOfApplicants = listOfApplicants.size();
		assertThat(listOfApplicants, hasSize(countOfApplicants)); 
		
		Applicant testApplicant2 = new Applicant("Petr", "Fomin", "petr@gmail.com", "02.05.2003", "Lviv, Svobody str., 1", "+385605967945", 0, YesNo.YES.name(), (double) 0);
		applicantService.saveApplicant(testApplicant2);
		applicantService.updateAverageMarkById(testApplicant2.getId(), 11.3);
		testApplicant2.setAverage(11.3);
		countOfApplicants = countOfApplicants + 1;
		listOfApplicants = applicantRepository.findAll();
		assertThat(listOfApplicants, hasSize(countOfApplicants));
		
		Applicant lastApplicant = listOfApplicants.get(countOfApplicants-1);		
		assertTrue(lastApplicant.getAverage().equals(testApplicant2.getAverage()));
		
		applicantRepository.delete(testApplicant2);
	}
	
	@Test
	void testGetAllApplicants() {
		
		List<Applicant> listOfApplicants = applicantService.getAllApplicants();	
		int countOfApplicants = listOfApplicants.size();
		assertThat(listOfApplicants, hasSize(countOfApplicants));
	}
	
	@Test
	void testDeleteApplicantById() {
		
		Applicant testApplicant3 = new Applicant("Andrey", "Monin", "mon@gmail.com", "12.04.2002", "Lviv, Sosnova str., 3", "+38560556945", 0, YesNo.YES.name(), (double) 0);
		applicantService.saveApplicant(testApplicant3);
		int applicantId = testApplicant3.getId();
		applicantService.deleteApplicantById(applicantId);
		
		List<Applicant> listOfApplicants = applicantRepository.findAll();
		assertFalse(listOfApplicants.contains(testApplicant3));		
	}
	
	@Test
	void testFindApplicantById() {
		
		Applicant testApplicant4 = new Applicant("Evgeniy", "Olenev", "evg@gmail.com", "11.01.2003", "Lviv, Persha str., 34", "+380670556945", 0, YesNo.YES.name(), (double) 0);
		applicantService.saveApplicant(testApplicant4);
		int applicantId = testApplicant4.getId();
		Applicant applicantById = applicantService.findApplicantById(applicantId);
		
		assertTrue(applicantById.getEmail().equals(testApplicant4.getEmail()));
		assertTrue(applicantById.getFirstName().equals(testApplicant4.getFirstName()));
		assertTrue(applicantById.getLastName().equals(testApplicant4.getLastName()));
		assertTrue(applicantById.getDateOfBirth().equals(testApplicant4.getDateOfBirth()));
		assertTrue(applicantById.getAddress().equals(testApplicant4.getAddress()));	
		assertTrue(applicantById.getPhone().equals(testApplicant4.getPhone()));	
		
		applicantRepository.delete(testApplicant4);
	}
	
	@Test
	void testFindApplicantsByFacultyId() {
		
		int facultyId = 999;
		Applicant testApplicant5 = new Applicant("Sergey", "Grad", "sg@gmail.com", "01.01.2001", "Lviv, Nebesna str., 4", "+3806709235", facultyId, YesNo.YES.name(), (double) 0);
		applicantService.saveApplicant(testApplicant5);
		
		List<Applicant> listOfApplicants = applicantService.findApplicantsByFacultyId(facultyId);
		
		Applicant lastApplicant = listOfApplicants.get(listOfApplicants.size()-1);
		assertTrue(lastApplicant.getEmail().equals(testApplicant5.getEmail()));
		assertTrue(lastApplicant.getFirstName().equals(testApplicant5.getFirstName()));
		assertTrue(lastApplicant.getLastName().equals(testApplicant5.getLastName()));
		assertTrue(lastApplicant.getDateOfBirth().equals(testApplicant5.getDateOfBirth()));
		assertTrue(lastApplicant.getAddress().equals(testApplicant5.getAddress()));	
		assertTrue(lastApplicant.getPhone().equals(testApplicant5.getPhone()));	
		
		applicantRepository.delete(testApplicant5);
	}	
	
	@Test
	void testSaveFaculty() {
		
		List<Faculty> listOfFaculties = facultyRepository.findAll();	
		int countOfFaculties = listOfFaculties.size();
		assertThat(listOfFaculties, hasSize(countOfFaculties)); 
		
		Faculty testFaculty1 = new Faculty("Test Faculty1", 99);
		facultyService.saveFaculty(testFaculty1);
		countOfFaculties = countOfFaculties + 1;
		listOfFaculties = facultyRepository.findAll();
		assertThat(listOfFaculties, hasSize(countOfFaculties));
		
		Faculty lastFaculty = listOfFaculties.get(countOfFaculties-1);
		assertEquals(lastFaculty, testFaculty1);
		
		facultyRepository.delete(testFaculty1);
	}
	
	@Test
	void testFindFacultyById() {
		
		Faculty testFaculty2 = new Faculty("Test Faculty2", 99);
		facultyService.saveFaculty(testFaculty2);
		int facultyId = testFaculty2.getId();
		Faculty facultyById = facultyService.findFacultyById(facultyId);
		
		assertEquals(facultyById, testFaculty2);
		
		facultyRepository.delete(testFaculty2);		
	}
	
	@Test
	void testGetAllFaculties() {
		
		List<Faculty> listOfFaculties = facultyService.getAllFaculties();	
		int countOfFaculties = listOfFaculties.size();
		
		assertThat(listOfFaculties, hasSize(countOfFaculties)); 
	}
	
	@Test
	void testSaveSubject() {
		
		Subject testSubject1 = new Subject("Test Subject1", 999);
		subjectService.saveSubject(testSubject1);
		
		List<Subject> listOfSubjects = subjectRepository.findAll();
		Subject lastSubject = listOfSubjects.get(listOfSubjects.size()-1);
		
		assertEquals(lastSubject, testSubject1);
		
		subjectRepository.delete(testSubject1);
	}
	
	@Test
	void testFindSubjectById() {
		
		Subject testSubject2 = new Subject("Test Subject2", 999);
		subjectService.saveSubject(testSubject2);
		int subjectId = testSubject2.getId();
		Subject subjectById = subjectService.findSubjectById(subjectId);
		
		assertEquals(subjectById, testSubject2);
		
		subjectRepository.delete(testSubject2);		
	}
	
	@Test
	void testFindSubjectByFacultyId() {
		
		int facultyId = 999;
		Subject testSubject3 = new Subject("Test Subject3", facultyId);
		subjectService.saveSubject(testSubject3);
		
		List<Subject> listOfSubjects = subjectService.findSubjectsByFacultyId(facultyId);		
		Subject lastSubject = listOfSubjects.get(listOfSubjects.size()-1);
		
		assertEquals(lastSubject, testSubject3);
		
		subjectRepository.delete(testSubject3);	
	}	
	
	@Test
	void testFindSubjectByApplicantId() {
		
		int applicantId = 999;
		Subject testSubject4 = new Subject("Test Subject4", 0, 0, applicantId);
		subjectService.saveSubject(testSubject4);
		
		List<Subject> listOfSubjects = subjectService.findSubjectsByApplicantId(applicantId);		
		Subject lastSubject = listOfSubjects.get(listOfSubjects.size()-1);
		
		assertEquals(lastSubject, testSubject4);
		
		subjectRepository.delete(testSubject4);	
	}
	
	@Test
	void testDeleteSubjectById() {
		
		Subject testSubject5 = new Subject("Test Subject5", 99);
		subjectService.saveSubject(testSubject5);
		int subjectId = testSubject5.getId();
		subjectService.deleteSubjectById(subjectId);
		
		List<Subject> listOfSubjects = subjectRepository.findAll();
		assertFalse(listOfSubjects.contains(testSubject5));		
	}
	
	@Test
	void testDeleteSubjectByApplicantId() {
		
		int applicantId = 999;
		Subject testSubject6 = new Subject("Test Subject6", 0, 0, applicantId);
		subjectService.saveSubject(testSubject6);
		
		subjectService.deleteSubjectByApplicantId(applicantId);		
		
		List<Subject> listOfSubjects = subjectRepository.findAll();
		assertFalse(listOfSubjects.contains(testSubject6));
	}	
	
	@Test
	void testSaveUser() {
		
		List<User> listOfUsers = userRepository.findAll();	
		int countOfUsers = listOfUsers.size();
		assertThat(listOfUsers, hasSize(countOfUsers)); 
		
		User testUser1 = new User("Test1","Test1","test1@mail.com","1","1",UserRole.ROLE_USER.getRoleName());
		userService.saveUser(testUser1);
		countOfUsers = countOfUsers + 1;
		listOfUsers = userRepository.findAll();
		assertThat(listOfUsers, hasSize(countOfUsers));
		
		User lastUser = listOfUsers.get(countOfUsers-1);
		assertTrue(lastUser.getEmail().equals(testUser1.getEmail()));
		assertTrue(lastUser.getFirstName().equals(testUser1.getFirstName()));
		assertTrue(lastUser.getLastName().equals(testUser1.getLastName()));
		assertTrue(lastUser.getRole().equals(testUser1.getRole()));	
		
		userRepository.delete(testUser1);
	}
	
	@Test
	void testFindUserByEmail() {
		
		List<User> listOfUsers = userRepository.findAll();	
		int countOfUsers = listOfUsers.size();
		assertThat(listOfUsers, hasSize(countOfUsers)); 		
		
		User testUser2 = new User("Test2","Test2","test2@mail.com","2","2",UserRole.ROLE_USER.getRoleName());
		userService.saveUser(testUser2);
		countOfUsers = countOfUsers + 1;
		listOfUsers = userRepository.findAll();
		assertThat(listOfUsers, hasSize(countOfUsers));	
		User userByEmail = userService.findUserByEmail(testUser2.getEmail());
		
		assertTrue(userByEmail.getEmail().equals(testUser2.getEmail()));
		assertTrue(userByEmail.getFirstName().equals(testUser2.getFirstName()));
		assertTrue(userByEmail.getLastName().equals(testUser2.getLastName()));
		assertTrue(userByEmail.getRole().equals(testUser2.getRole()));	
		
		userRepository.delete(testUser2);
	}
	
	
	
}