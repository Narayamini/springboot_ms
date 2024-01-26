package com.example.thyme.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    //new controller method to show initial form

//    @RequestMapping("/getForm")
//    public String getForm()
//    {
//        return "helloworld-form";
//    }
@GetMapping("/getForm")
public String getForm()
{
    return "helloworld-form";
}
    //new controller method to process  form
    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }
    //controller method to read form data
    //add data to model
    @RequestMapping("/processFormv2")
    public String excited(HttpServletRequest request, Model model)
    {
        //read request param from html form
        String theName= request.getParameter("studentName");
        //convert that data to caps
        theName=theName.toUpperCase();
        //create the message
        String result="Heeyyyyy "+ theName;
        //add data to the model
        model.addAttribute("message",result);
        return "helloworld";
    }

    @RequestMapping("/processFormv3")
    public String processFormv3(@RequestParam("studentName") String theName, Model model)
    {
        //convert that data to caps
        theName=theName.toUpperCase();
        //create the message
        String result="All the best!!! "+ theName;
        //add data to the model
        model.addAttribute("message",result);
        return "helloworld";
    }
}
