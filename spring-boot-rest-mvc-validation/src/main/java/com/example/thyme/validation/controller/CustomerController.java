package com.example.thyme.validation.controller;

import com.example.thyme.validation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String getForm(Model model)
    {
        Customer customer=new Customer();
        model.addAttribute("customer",customer);
        return "customer-form";
    }
    /*Here Valid annotation below tells Spring MVC to perform validations in the given form data and the Modelattribute says
    read the  form data from model attribute customer which was submitted by html form and perform the validation rules mentioned in customer class
    and also we add BindingResult which holds the validation results
     */
    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute Customer theCustomer, BindingResult thebinding)

    {
        if(thebinding.hasErrors())
        {
            return "customer-form";
        }
        else {
            return "customer-confirmation";
        }
    }
    //adding initbinder to remove leading and trailing whitespaces and resolve issues for validation

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
       /*So here we are passing true to StringTrimmerEditor so that it will treat string as null if it all whitespace
       and we are using webdatabinder to do this operation if this is a string class
        */
    }

}

