package com.ghulam.service;

import java.util.List;

import com.ghulam.entity.Student;

public interface StudentService {
	List<Student> getStudents();

	void saveOrUpdate(Student student);

	Student getStudent(int id);

	void delete(int id);
}
