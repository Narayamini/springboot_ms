package com.example.crud.demo.service;

import com.example.crud.demo.dao.EmployeeRepository;
import com.example.crud.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository=employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //Optional is the feature introduced to Java 8 to get rid of null check and follow the optional introduced process
    @Override
    public Employee findById(int id) {
         Optional<Employee> result = employeeRepository.findById(id);
         Employee emp=null;
         if(result.isPresent())
         {
             emp=result.get();
         }
         else {
             throw new RuntimeException("Employee id is not found- "+id);
         }
         return emp;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);

    }

}
