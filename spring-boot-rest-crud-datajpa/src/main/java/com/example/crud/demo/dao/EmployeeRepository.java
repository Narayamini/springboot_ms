package com.example.crud.demo.dao;

import com.example.crud.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//here we pass the entity class as first parameter and then primary key type as the second parameter
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}
