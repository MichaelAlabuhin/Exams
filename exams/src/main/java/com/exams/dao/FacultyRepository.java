package com.exams.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exams.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer>{

}
