package com.springboot.ajax.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ajax.example.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
