package com.example.datajpa.dao;

import com.example.datajpa.entity.Student;

import java.util.List;

public interface StudentDAO {

     void save(Student thestudent);

     Student findById(int a);

     List<Student> findAll();

     List<Student> listbylastname(String lastName);

     void updateStudent(Student student);

     int bulkUpdate();

     void delete(int id);

     int deleteAll();
}
