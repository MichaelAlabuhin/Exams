package com.exams.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private int mark;
	
	@Column
	private int faculty_id;
	
	@Column
	private int applicant_id;
	
	public Subject() {
		super();
	}	
	
	public Subject(int id, String name, int mark, int faculty_id, int applicant_id) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
		this.faculty_id = faculty_id;
		this.applicant_id = applicant_id;
	}

	public Subject(String name, int mark, int faculty_id, int applicant_id) {
		super();
		this.name = name;
		this.mark = mark;
		this.faculty_id = faculty_id;
		this.applicant_id = applicant_id;
	}

	public Subject(String name, int faculty_id) {
		super();
		this.name = name;
		this.faculty_id = faculty_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}

	public int getApplicant_id() {
		return applicant_id;
	}

	public void setApplicant_id(int applicant_id) {
		this.applicant_id = applicant_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(applicant_id, faculty_id, id, mark, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return applicant_id == other.applicant_id && faculty_id == other.faculty_id && id == other.id
				&& mark == other.mark && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", mark=" + mark + "]";
	}	
}
