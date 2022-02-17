package com.example.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired
private StudentRepository studentrepository;
	@Override
	public void run(String... args) throws Exception {
		/*
		 * Student student1 = new Student("Netra", "Jadhav", "net@gmail.com");
		 * studentrepository.save(student1);
		 * 
		 * Student student2 = new Student("Ajit", "Jadhav", "aj@gmail.com");
		 * studentrepository.save(student2);
		 * 
		 * Student student3 = new Student("John", "Cena", "john@gmail.com");
		 * studentrepository.save(student3);
		 * 
		 * Student student4 = new Student("Tony", "Stark", "net@gmail.com");
		 * studentrepository.save(student4);
		 */
	}

}
