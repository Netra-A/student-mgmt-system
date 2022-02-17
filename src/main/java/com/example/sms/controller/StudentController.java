package com.example.sms.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.entity.Student;
import com.example.sms.servicei.StudentService;

@Controller
public class StudentController {

	private StudentService studentservice;

	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}

	// handler method that handle request from getListofStudents() and return mode
	// and view.
	@GetMapping("/students")
	public String listOfStudents(Model model) {
		model.addAttribute("students", studentservice.getListofStudent());// attribute_name =students & value =method
																			// which will get list of student from Db
		return "students";// means we are returning students list as view ;so create view students using
							// thymleaf in template folder
	}
	
	//handler method for add student button
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		//to hold data from create student form create empty student object
		Student student =new Student();
		model.addAttribute("student", student);//to save data
		return "create_student";
	}
	
	//handler method for create Student page(/to handle form)
	@PostMapping("/students")
	public String saveStudentForm(@ModelAttribute("student") Student student) {
		studentservice.saveStudent(student);
		return "redirect:/students";
	}
	
	//handler method for update button
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("student", studentservice.getStudentById(id));
		return "edit_student";
	}
	
	
	//handler method to update in DB and on list view model
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, 
			@ModelAttribute("student") Student student,
			Model model) {
		
		//get student from Database
	Student existingStudent	= studentservice.getStudentById(id);
	    
	//updating student based on ID ;By getting(firstName/lastName/Email) from student object and then set it via updating
	existingStudent.setId(id);
	existingStudent.setFirstName(student.getFirstName());
	existingStudent.setLastName(student.getLastName());
	existingStudent.setEmail(student.getEmail());
	
	//update into DB
	studentservice.updateStudent(existingStudent);
	
	return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable Long id) {
		
		studentservice.deleteStudentById(id);
		return "redirect:/students";
	}

}
