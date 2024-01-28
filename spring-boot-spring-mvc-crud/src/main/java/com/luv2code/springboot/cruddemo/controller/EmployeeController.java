package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

 //Employee Controller calls Employee Service and then Employee Service calls Employee Repository
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController (EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }
    @GetMapping("/list")
    public String listEmployees(Model model)
    {
        //get the employees from db
        List<Employee> theEmployees=employeeService.findAll();
        //add to the spring model
        model.addAttribute("employees",theEmployees);

        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String addEmployee(Model model)
    {
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee)
    {
        //save the employee
        employeeService.save(employee);
        //use a redirect to prevent duplicate submissions and here we are using "Post/Redirect/Get" pattern
        return "redirect:/employees/list";
    }
    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId")int theId,Model model)
    {
        //get the employee from the service
        Employee theEmployee = employeeService.findById(theId);
        //set employee in the model to prepopulate the form
        model.addAttribute("employee",theEmployee);
        //send over to our form
        return "employee-form"; }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId")int theId)
        {
            //delete the employee
            employeeService.deleteById(theId);
            //redirect to the /employees/list
            return "redirect:/employees/list";
        }
    }

