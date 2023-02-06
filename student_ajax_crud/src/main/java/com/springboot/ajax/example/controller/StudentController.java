package com.springboot.ajax.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ajax.example.entity.Student;
import com.springboot.ajax.example.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/studentList")
	public ResponseEntity<List<Student>> getStudentList(){
		return new ResponseEntity<List<Student>>(service.getAllStudent(),HttpStatus.OK);
	}
	
	@PostMapping("/student/save")
	public ResponseEntity<Void> saveOrUpdateStudent(@RequestBody Student student) {
		service.saveOrUpdateStudent(student);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable ("id") Integer id){
		return new ResponseEntity<Student>(service.getStudentById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/student/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable ("id") Integer id){
		service.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted successfully!", HttpStatus.OK);
	}
}
