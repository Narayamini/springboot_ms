package com.example.demo.rest;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentErrorResponse;
import com.example.demo.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    public List<Student> thestudents;

    //define @PostConstruct to load the student data only once !
    @PostConstruct
    public void loadData() {
        thestudents = new ArrayList<>();
        thestudents.add(new Student("Harry", "Potter"));
        thestudents.add(new Student("Hogwarts", "School"));
        thestudents.add(new Student("Dumble", "Dore"));

    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return thestudents;
    }

    //define endpoint for "/students/{studentId}" - return the student of studentId
    @GetMapping("/students/{studentId}")
    //by default the PathVariable passed as the parameter to below function and the PathVariable passed in the URL should match
    public Student getStudent(@PathVariable int studentId) {
        if (studentId > thestudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found -" + studentId);
        } else {
            //currently we are using studentId as index
            return thestudents.get(studentId);
        }

    }
//    //Added an exception handler using @ExceptionHandler
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
//    {
//        //create a studenterror response
//        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
//        studentErrorResponse.setMessage(exc.getMessage());
//        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
//        //return responseentity
//        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
//
//    }
//    // Added an ExceptionHandler to catch any exception
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleAllExceptions(Exception exc)
//    {
//        //BADREQUEST -400, 404-NOT FOUND
//        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
//        studentErrorResponse.setMessage(exc.getMessage());
//        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
//        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
//    }
}
