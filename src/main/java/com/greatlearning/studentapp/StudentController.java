package com.greatlearning.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("/list")
	public String listStudents(Model model) {
		
		List<Student> students = studentService.findAllStudents();
		
		model.addAttribute("students", students);
		
		return "list-students";
		
		
		
	}
	
	
	@RequestMapping("/new")
	public String showFormForAdd( Model model ) {
		Student student = new Student();
		
		model.addAttribute( "newStudent", true );
		model.addAttribute( "student", student );
		
		return "edit-student";
	}
	
	@RequestMapping("/edit")
	public String showFormForEdit(
		@RequestParam("id") int id,
		Model model
	) {
		Student student = studentService.findById( id );
		
		model.addAttribute( "newStudent", false );
		model.addAttribute( "student", student );
		
		return "edit-student";
	}
	
	@PostMapping("/save")
	public String saveBook(
		@RequestParam("id") int id,
		@RequestParam("name") String name,
		@RequestParam("country") String country,
		@RequestParam("department") String department
	) {
		Student student = null;
		
		if( id == 0 ) {
			student = new Student( name, department, country );
		} else {
			student = studentService.findById( id );
			student.setName( name );
			student.setCountry( country );
			student.setDepartment( department ); 
		}
		
		studentService.saveStudent( student );
				
		return "redirect:/students/list";
	}
	
	@RequestMapping("/delete")
	public String showFormForAdd( @RequestParam("id") int id ) {
		studentService.deleteStudentById( id );
		
		return "redirect:/students/list";
	}
	
	
	
	

}
