package com.example.demo.entity;

//The getters and setters have to match the field names in order for the jackson to generate the binding correctly
public class Student {

    public String firstName;
    public String lastName;

    public Student()
    {

    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
