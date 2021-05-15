package com.example.springRest.SpringRestWithFirebase;

import com.example.springRest.SpringRestWithFirebase.Model.StudentModel;
import com.example.springRest.SpringRestWithFirebase.Service.StudentFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentFunctions studentFunctions;

    @PostMapping("/addStudent")
    public StudentModel addStudent(@RequestBody StudentModel student){
        return studentFunctions.saveStudent(student);
    }

    @GetMapping("/getStudent/{id}")
    public StudentModel getStudent(@PathVariable int id) throws ExecutionException, InterruptedException {
        return studentFunctions.getStudent(id);
    }

    @GetMapping("/getAllStudents")
    public List<StudentModel> getAllStudents() throws ExecutionException, InterruptedException {
        return studentFunctions.getAllStudents();
    }


    @PutMapping("/updateStudent")
    public StudentModel updateStudent(@RequestBody StudentModel student) throws ExecutionException, InterruptedException {
       return studentFunctions.updateStudent(student);
    }

}
