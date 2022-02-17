package com.example.sms.servicei;
//It works on Dependency Injection principle where loosely coupled High and low level module
//but they dependent on abstraction

import java.util.List;

import com.example.sms.entity.Student;

public interface StudentService {
	
  List<Student> getListofStudent();
	
   Student saveStudent(Student student);
  
   Student getStudentById(Long id);
  
  Student updateStudent(Student student);
  
  void deleteStudentById(Long id);

}
