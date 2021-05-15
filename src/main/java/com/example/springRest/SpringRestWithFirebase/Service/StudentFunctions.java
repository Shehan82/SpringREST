package com.example.springRest.SpringRestWithFirebase.Service;

import com.example.springRest.SpringRestWithFirebase.Model.StudentModel;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

@Service
public class StudentFunctions {
    public StudentModel saveStudent(StudentModel student){
        FirestoreClient.getFirestore().collection("student").add(student);
        return student;
    }
}
