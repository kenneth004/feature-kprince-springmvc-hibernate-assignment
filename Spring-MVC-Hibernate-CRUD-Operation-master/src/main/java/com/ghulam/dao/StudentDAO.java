package com.ghulam.dao;

import com.ghulam.entity.Student;

import java.util.List;

public interface StudentDAO {
	List<Student> getStudents();

	void saveOrUpdate(Student student);

	Student getStudent(int id);

	void delete(int id);
}
