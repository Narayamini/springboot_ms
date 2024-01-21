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

	/* The following Command Line Runner is a hook that allows us to execute code after springbeans are loaded in app context

	 */
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->
		{
          createStudent(studentDAO);
			getStudent(studentDAO);
			studentslist(studentDAO);
			studentslistbyLastName(studentDAO);
			updateStudent(studentDAO);
			bulkUpdate(studentDAO);
			deleteStudent(studentDAO);
			deleteAll(studentDAO);

		};
	}

	public void createStudent(StudentDAO studentDAO) {
		//create the student object
		Student student1=new Student("Harry","Potter","Harry@gmail.com");
		//save the student object
		studentDAO.save(student1);
		//display the id of the student
		System.out.println("Here's the student id" + student1.getId());

	}

	public void getStudent(StudentDAO studentDAO) {
		//create a student
		Student student1=new Student("Harry","Potter","Harry@gmail.com");
		//save student
		studentDAO.save(student1);
		//get id of student
		int id = student1.getId();
		System.out.println("Here's the student id  " + id);
		//get the student based on id
		Student student=studentDAO.findById(id);
		//display student
		System.out.println("Here's the student  "+student);

	}

	private void studentslist(StudentDAO studentDAO) {

		//get list of students
		List<Student> students=studentDAO.findAll();
		//print list of students
		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void studentslistbyLastName(StudentDAO studentDAO) {
		//get list of students
		List<Student> studentList=studentDAO.listbylastname("Potter");
		//display list of students
		for(Student student : studentList) {
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		//get the student object
		Student student=studentDAO.findById(2);
		//set the params using setter methods by updating the required info
		student.setLastName("Hogwarts");
		//update the student
		studentDAO.updateStudent(student);
		//display the updated student
		System.out.println("updated student"+student);

	}

	private void bulkUpdate(StudentDAO studentDAO) {
		int n= studentDAO.bulkUpdate();
		System.out.println(n);

	}
	private void deleteStudent(StudentDAO studentDAO) {

		//deleting the student by passing the id
		studentDAO.delete(1);

	}
	private void deleteAll(StudentDAO studentDAO) {

		int n= studentDAO.deleteAll();
		System.out.println("deleted  " + n);
	}


}


}
