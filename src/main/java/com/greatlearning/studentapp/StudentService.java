package com.greatlearning.studentapp;

import java.util.*;

import org.springframework.stereotype.Service;


@Service
public interface StudentService {
	
    public List<Student> findAllStudents();
    
    public Student findById(int id);
    
    public void saveStudent(Student student);
    
    public void deleteStudentById(int id);
    
    

}
