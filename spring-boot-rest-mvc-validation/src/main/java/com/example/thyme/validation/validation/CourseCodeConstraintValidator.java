package com.example.thyme.validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

//have to implement ConstraintValidator interface
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {
    private String coursePrefix;

    //here we are assigning the value that we pass to the annotation to courseprefix inorder to use it for comparision later
    //if the value is not passed in the annotation it takes the default value
    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix=theCourseCode.value();
    }
//actual business logic method to return true or false if the given string validates
    //constraintValidatorContext- parameter to provide additional error messages
    //s- the code we pass via the HTML page
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if(theCode!=null)
        {
            System.out.println(theCode);
             result = theCode.startsWith(coursePrefix);
        }
        else{
            return false;
        }

        return result;
    }
}
