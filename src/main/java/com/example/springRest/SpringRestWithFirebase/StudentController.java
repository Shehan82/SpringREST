package com.example.springRest.SpringRestWithFirebase;

import com.example.springRest.SpringRestWithFirebase.Model.StudentModel;
import com.example.springRest.SpringRestWithFirebase.Service.StudentFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentFunctions studentFunctions;

    @PostMapping("/addStudent")
    public StudentModel addStudent(@RequestBody StudentModel student){
        return studentFunctions.saveStudent(student);
    }

}
