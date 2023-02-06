package com.springboot.ajax.example.service;

import java.util.List;

import com.springboot.ajax.example.entity.Student;

public interface StudentService {

	List<Student> getAllStudent();
	
	void saveOrUpdateStudent(Student student);
	
	Student getStudentById(Integer id);
	
	void deleteStudent(Integer id);
}
