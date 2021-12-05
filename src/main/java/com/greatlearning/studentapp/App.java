package com.greatlearning.studentapp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
	
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		 StudentService service = new StudentServiceDao(sessionFactory);
		
		Student student = new Student();
		
		student.setCountry("India");
		student.setName("Rahul");
		student.setDepartment("Mathematics");
		
		
		service.saveStudent(student);
		
		
		

	}

}
