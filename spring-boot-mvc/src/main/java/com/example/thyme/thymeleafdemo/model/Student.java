package com.example.thyme.thymeleafdemo.model;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;

    private String country;
    private String favlang;

    public List<String> getSystems() {
        return systems;
    }

    public void setSystems(List<String> systems) {
        this.systems = systems;
    }

    private List<String> systems;

    public String getFavlang() {
        return favlang;
    }

    public void setFavlang(String favlang) {
        this.favlang = favlang;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
