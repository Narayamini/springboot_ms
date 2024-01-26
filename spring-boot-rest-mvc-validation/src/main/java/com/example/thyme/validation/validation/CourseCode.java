package com.example.thyme.validation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD}) //-> where can we apply this annotation either method/field
@Retention(RetentionPolicy.RUNTIME) //- how long to retain, here runtime means Retain this annotation in Java class file i.e put it in byte code and we will process it at runtime
public @interface CourseCode {
    //this is how we define custom annotation in Java and CourseCode is name of annotation

    //define the annotation fields in terms of methods which we can pass
    //if no value is passed we consider the default value
    //default value
    public String value() default "YAM";

    //default error message
    public String message() default "must start with YAM";
    //define default groups
    public Class<?>[] groups() default {};
    //define default payloads
    public Class<? extends Payload>[] payload() default{};
    //payload provided custom details about validation failure - severity level, error code etc

    //groups-group validation constraints together, payloads: give additional info about validation error
}