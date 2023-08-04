package com.exams.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@Column
	private String address;
	
	@Column
	private String phone;	
	
	@Column
	private int faculty_id;
	
	@Column
	private String verified;
	
	@Column
	private String status;
	
	@Column
	private Double average;	
	
	private String facultyName;
	
	@Lob
	@Column(columnDefinition="LONGBLOB")
	private String encodedImage;
	
	public Applicant() {
		super();
	}	

	public Applicant(String firstName, String lastName, String email, String dateOfBirth, String address, String phone,
			int faculty_id, String verified, Double average) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phone = phone;
		this.faculty_id = faculty_id;
		this.verified = verified;
		this.average = average;
	}	

	public Applicant(int id, String firstName, String lastName, String email, String dateOfBirth, String address,
			String phone, int faculty_id, String verified, Double average) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phone = phone;
		this.faculty_id = faculty_id;
		this.verified = verified;
		this.average = average;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}		
	
	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}	
	
	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEncodedImage() {
		return encodedImage;
	}

	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}	

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, average, dateOfBirth, email, encodedImage, facultyName, faculty_id, firstName, id,
				lastName, phone, status, verified);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Applicant other = (Applicant) obj;
		return Objects.equals(address, other.address) && Objects.equals(average, other.average)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(email, other.email)
				&& Objects.equals(encodedImage, other.encodedImage) && Objects.equals(facultyName, other.facultyName)
				&& faculty_id == other.faculty_id && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phone, other.phone)
				&& Objects.equals(status, other.status) && Objects.equals(verified, other.verified);
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", phone=" + phone + ", faculty_id="
				+ faculty_id + ", average=" + average + ", encodedImage=" + encodedImage + "]";
	}	
}