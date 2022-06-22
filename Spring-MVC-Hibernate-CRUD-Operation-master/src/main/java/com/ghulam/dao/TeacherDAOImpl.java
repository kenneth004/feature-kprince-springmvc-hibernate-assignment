package com.ghulam.dao;

import com.ghulam.entity.Teacher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class TeacherDAOImpl implements TeacherDAO {

	private SessionFactory sessionFactory = null;

	@Autowired
	public TeacherDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Teacher> getTeachers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Teacher> query;
		query = session.createQuery("from Teacher", Teacher.class);
		return query.getResultList();
	}

	@Override
	public void saveOrUpdate(Teacher teacher) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(teacher);
	}

	@Override
	public Teacher getTeacher(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Teacher.class, id);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Teacher c where c.Id =:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
