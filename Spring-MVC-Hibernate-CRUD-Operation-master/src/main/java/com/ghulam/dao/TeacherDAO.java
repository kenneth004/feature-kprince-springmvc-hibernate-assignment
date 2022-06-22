package com.ghulam.dao;

import com.ghulam.entity.Teacher;

import java.util.List;

public interface TeacherDAO {
	List<Teacher> getTeachers();

	Teacher getTeacher(int id);

	void delete(int id);

	void saveOrUpdate(Teacher teacher);
}
