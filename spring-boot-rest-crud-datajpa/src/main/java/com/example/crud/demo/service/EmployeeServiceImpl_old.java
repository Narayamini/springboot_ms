package com.example.crud.demo.service;

import com.example.crud.demo.dao.EmployeeDAO;
import com.example.crud.demo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//The following code is using Standard JPA , we have the refractored latest class EmployeeServiceImpl
//using Spring Data JPA
//@Service
public class EmployeeServiceImpl_old implements EmployeeService{

    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl_old(EmployeeDAO employeeDAO)
    {
        this.employeeDAO=employeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }
    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDAO.deleteById(id);

    }

}
