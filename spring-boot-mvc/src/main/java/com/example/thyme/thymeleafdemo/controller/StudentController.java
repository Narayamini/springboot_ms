package com.example.thyme.thymeleafdemo.controller;

import com.example.thyme.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")

    private List<String> countries;

    @Value("${favlang}")

    private List<String> favlang;
    @Value("${systems}")

    private List<String> systems;

    @GetMapping("/student")
    public String enrollStudent(Model model)
    {
        //create new student obj
        Student thestd = new Student();
        //add the created obj to model
       model.addAttribute("student",thestd);
       //add list of countries to model
        model.addAttribute("countries",countries);
        model.addAttribute("favlang",favlang);
        model.addAttribute("systems",systems);
       return "student-form";
    }

    @PostMapping("/studentconfimed")
    public String processStudent(@ModelAttribute("student") Student thestd)
    {
        //log input data
        System.out.println(thestd.getFirstName() + "   "+thestd.getFirstName() +" "+thestd.getCountry());
        return "student-confirmation";
    }



}
