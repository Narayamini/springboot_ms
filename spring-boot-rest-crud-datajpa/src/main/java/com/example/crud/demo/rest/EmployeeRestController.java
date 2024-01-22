package com.example.crud.demo.rest;

import com.example.crud.demo.entity.Employee;
import com.example.crud.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
/*
    Here instead of using the direct DAO object as given below we are using the service layer object
    public EmployeeDAO employeeDAO ;
    public EmployeeRestController (EmployeeDAO employeeDAO)
    {
        this.employeeDAO=employeeDAO;
    } */
    public EmployeeService employeeService;
    @Autowired
public EmployeeRestController (EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }

    //expose /employees and return the list of employees
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
       return employeeService.findAll();
    }
    //add mapping for GET /employees/(employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee employee = employeeService.findById(employeeId);
        if(employee == null)
        {
            throw new RuntimeException("Employee id is not found - "+ employeeId);
        }
        else{
        return employee; }
    }

    //adding mapping for POST /employees - adding new employees
    @PostMapping ("/employees")
    public Employee addEmployee(@RequestBody Employee theemployee)
    {

        theemployee.setId(0);
        return employeeService.save(theemployee);
    }
    //update mapping for updating employee
    @PutMapping ("/employees")
    public Employee updateEmployee(@RequestBody Employee theemployee)
    {
        return employeeService.save(theemployee);
    }
    //delete employee by employee id

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee employee = employeeService.findById(employeeId);
        if(employee == null)
        {
            throw new RuntimeException("Employee id is not found - "+ employeeId);
        }
        else{
             employeeService.deleteById(employeeId);
        return "Employee with employee id - "+employeeId+" is deleted";}
    }

}
