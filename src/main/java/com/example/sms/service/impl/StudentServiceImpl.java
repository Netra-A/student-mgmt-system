package com.example.sms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.exception.ResourceNotFound;
import com.example.sms.repository.StudentRepository;
import com.example.sms.servicei.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	// As Spring bean has only one constructor so no need to use Autowired
	// annotation
	// Constructor based Dependency Injection

	private StudentRepository studentrepository;

	public StudentServiceImpl(StudentRepository studentrepository) {
		super();
		this.studentrepository = studentrepository;
	}

	@Override
	public List<Student> getListofStudent() {

		return studentrepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {

		return studentrepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		
		return studentrepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentrepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentrepository.deleteById(id);
		
	}


	

}
