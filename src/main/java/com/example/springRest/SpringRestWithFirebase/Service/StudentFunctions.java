package com.example.springRest.SpringRestWithFirebase.Service;

import com.example.springRest.SpringRestWithFirebase.Model.StudentModel;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;


@Service
public class StudentFunctions {
    public StudentModel saveStudent(StudentModel student){
        FirestoreClient.getFirestore().collection("student").add(student);
        return student;
    }

    public StudentModel getStudent(int sID) throws ExecutionException, InterruptedException {
        StudentModel studentModel = null;

        QueryDocumentSnapshot s = FirestoreClient.getFirestore().collection("student").whereEqualTo("sID", sID).get().get().getDocuments().get(0);
        studentModel = s.toObject(StudentModel.class);

        return studentModel;

    }
}
