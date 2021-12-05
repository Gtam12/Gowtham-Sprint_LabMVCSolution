package com.greatlearning.studentapp;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class StudentServiceDao implements StudentService {
	
	
	private SessionFactory sessionFactory;
	private Session session;
	
	
	
	public StudentServiceDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.session = sessionFactory.getCurrentSession();
	}

	
	@Transactional
	public List<Student> findAllStudents() {
	
		Transaction tx = session.beginTransaction();
	    List<Student> students = session.createQuery("from students", Student.class).list();
	    tx.commit();
	    return students;

	}
	
	
    @Transactional
	public Student findById(int id) {
		// TODO Auto-generated method stub
    	Student student = session.get(Student.class, id);
		return student;
	}

    @Transactional
	public void saveStudent(Student student) {
    Transaction tx = session.beginTransaction(); 	
	session.saveOrUpdate(student);
    tx.commit();
	}

    @Transactional
	public void deleteStudentById(int id) {
		Transaction tx = session.getTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		tx.commit();
		
	}

}
