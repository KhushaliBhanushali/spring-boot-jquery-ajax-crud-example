package com.springboot.ajax.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ajax.example.entity.Student;
import com.springboot.ajax.example.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository repository;

	@Override
	public List<Student> getAllStudent() {
		
		return repository.findAll();
	}

	@Override
	public void saveOrUpdateStudent(Student student) {
	
		repository.save(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> optional = repository.findById(id);
		Student Student = null;
		if(optional.isPresent()) {
			Student = optional.get();
		}else {
			throw new RuntimeException("Student not found for id: "+id);
		}
		return Student;
	}

	@Override
	public void deleteStudent(Integer id) {
		repository.findById(id);
		repository.deleteById(id);
		
	}

}
