package com.greatlearning.studentapp;

import java.util.*;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class StudentServiceDao implements StudentService {
	
	
	private SessionFactory sessionFactory;
	private Session session;
	
	
	@Autowired
	public StudentServiceDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
		try {
		this.session = sessionFactory.getCurrentSession();
		}
		catch(Exception e) {
		 this.session = this.sessionFactory.openSession();
		}
	}

	
	@Transactional
	public List<Student> findAllStudents() {
	
	    List<Student> students = session.createQuery("from Student", Student.class).list();
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
	session.saveOrUpdate(student);
	}

    @Transactional
	public void deleteStudentById(int id) {
		Student student = session.get(Student.class, id);
		session.delete(student);
		
	}

}
