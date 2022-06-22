package com.ghulam.dao;

import com.ghulam.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class StudentDAOImpl implements StudentDAO {

	private final SessionFactory sessionFactory;

	@Autowired
	public StudentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Student> getStudents() {
		Session session = sessionFactory.getCurrentSession();
		Query<Student> query;
		query = session.createQuery("from Student", Student.class);
		return query.getResultList();
	}

	@Override
	public void saveOrUpdate(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);
	}

	@Override
	public Student getStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Student.class, id);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Student c where c.Id =:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
