package com.example.thyme.validation.model;

import com.example.thyme.validation.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    @CourseCode()
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    private String firstName;
    @NotNull(message="is required")
    @Size(min=1,message="min size is 1 character")
    private String lastName;

    /*here we need the customer provide a min number of 0 and max of 10 for productsList*/
    @Min(value=0,message="must be >=0")
    @Max(value=10,message="must be <=0")
    @NotNull(message="is required")
    private int productsList;

    //here we have provided regular expression which accepts only 5 chars and numeric values
    @Pattern(regexp="^[a-zA-Z0-9]{5}",message = "only 5 chars/digits")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getProductsList() {
        return productsList;
    }

    public void setProductsList(int productsList) {
        this.productsList = productsList;
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
