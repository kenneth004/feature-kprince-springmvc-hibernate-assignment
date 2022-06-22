package com.ghulam.service;

import com.ghulam.dao.StudentDAO;
import com.ghulam.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	private final StudentDAO studentDAO;

	@Autowired
	public StudentServiceImpl(StudentDAO StudentDAO) {
		this.studentDAO = StudentDAO;
	}

	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public void saveOrUpdate(Student student) {
		studentDAO.saveOrUpdate(student);
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		return studentDAO.getStudent(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		studentDAO.delete(id);
	}
}

