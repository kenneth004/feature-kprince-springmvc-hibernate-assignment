package com.ghulam.service;

import java.util.List;

import com.ghulam.entity.Teacher;

public interface TeacherService {

	List<Teacher> getTeachers();

	void saveOrUpdate(Teacher teacher);

	Teacher getTeacher(int id);

	void delete(int id);

}
