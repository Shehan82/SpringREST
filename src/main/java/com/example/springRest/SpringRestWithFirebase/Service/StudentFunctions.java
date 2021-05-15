package com.example.springRest.SpringRestWithFirebase.Service;

import com.example.springRest.SpringRestWithFirebase.Model.StudentModel;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
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

    public List<StudentModel> getAllStudents() throws ExecutionException, InterruptedException {
        List<StudentModel> studentModelList = new ArrayList<StudentModel>();

        List<QueryDocumentSnapshot> studentList = FirestoreClient.getFirestore().collection("student").get().get().getDocuments();

        for(QueryDocumentSnapshot studentModel : studentList){
            studentModelList.add(studentModel.toObject(StudentModel.class));
        }

        return studentModelList;
    }


    public StudentModel updateStudent(StudentModel student) throws ExecutionException, InterruptedException {

        String documentID = FirestoreClient.getFirestore().collection("student").whereEqualTo("sID", student.getsID()).get().get().getDocuments().get(0).getId();

        FirestoreClient.getFirestore().collection("student").document(documentID).set(student);

        return student;
    }
}
