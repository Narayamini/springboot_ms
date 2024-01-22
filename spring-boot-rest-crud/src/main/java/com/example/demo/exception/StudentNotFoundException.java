package com.example.demo.exception;

//RunTimeException is from java.lang package and the Custom Exception class have to extend the RunTimeException Class
public class StudentNotFoundException extends  RuntimeException{

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
