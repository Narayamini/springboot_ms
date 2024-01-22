package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//This Hdlr is created in order to perform Exceptional Handling Globally
@ControllerAdvice
public class StudentRestExceptionHdlr {

    //Added exception handling code
    //Added an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
    {
        //create a studenterror response
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setMessage(exc.getMessage());
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        //return responseentity
        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);

    }
    // Added an ExceptionHandler to catch any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAllExceptions(Exception exc)
    {
        //BADREQUEST -400, 404-NOT FOUND
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setMessage(exc.getMessage());
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
    }
}
