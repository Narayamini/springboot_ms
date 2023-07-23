package com.example.datajpa;

import com.example.datajpa.dao.StudentDAO;
import com.example.datajpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatajpaApplication.class, args);


	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->
		{
          createStudent(studentDAO);
		  getStudent(studentDAO);
		  studentslist(studentDAO);
		  updateStudent(studentDAO);
		  bulkUpdate(studentDAO);
		  studentslistbyLastName(studentDAO);
		  deleteStudent(studentDAO);
		  deleteAll(studentDAO);

		};
	}

	private void deleteAll(StudentDAO studentDAO) {

		int n= studentDAO.deleteAll();
		System.out.println("deleted  " + n);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		studentDAO.delete(1);

	}

	private void bulkUpdate(StudentDAO studentDAO) {
		int n= studentDAO.bulkUpdate();
		System.out.println(n);

	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student=studentDAO.findById(2);
		student.setLastName("Hogwarts");
		studentDAO.updateStudent(student);


	}

	private void studentslistbyLastName(StudentDAO studentDAO) {
		List<Student> studentList=studentDAO.listbylastname("Potter");
		for(Student student : studentList) {
			System.out.println(student);
		}
	}

	private void studentslist(StudentDAO studentDAO) {

		List<Student> students=studentDAO.findAll();
		for(Student student : students) {
			System.out.println(student);
		}

	}

	public void createStudent(StudentDAO studentDAO) {
		Student student1=new Student("Harry","Potter","Harry@gmail.com");
		studentDAO.save(student1);
		System.out.println("Here's the student id" + student1.getId());

	}

	public void getStudent(StudentDAO studentDAO) {
		Student student1=new Student("Harry","Potter","Harry@gmail.com");
		studentDAO.save(student1);
		int id = student1.getId();
		System.out.println("Here's the student id  " + id);
		Student student=studentDAO.findById(id);

		System.out.println("Here's the student  "+student);

	}

}
