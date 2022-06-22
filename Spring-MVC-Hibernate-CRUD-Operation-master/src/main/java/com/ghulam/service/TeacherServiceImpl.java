package com.ghulam.service;

import com.ghulam.dao.TeacherDAO;
import com.ghulam.entity.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
	private final TeacherDAO teacherDAO;

	@Autowired
	public TeacherServiceImpl(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	@Transactional
	public List<Teacher> getTeachers() {
		return teacherDAO.getTeachers();
	}

	@Override
	@Transactional
	public void saveOrUpdate(Teacher teacher) {
		teacherDAO.saveOrUpdate(teacher);
	}

	@Override
	@Transactional
	public Teacher getTeacher(int id) {
		return teacherDAO.getTeacher(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		teacherDAO.delete(id);
	}
}
