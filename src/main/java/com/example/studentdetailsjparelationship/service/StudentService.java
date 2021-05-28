package com.example.studentdetailsjparelationship.service;

import com.example.studentdetailsjparelationship.entity.Student;
import com.example.studentdetailsjparelationship.repo.ReviewRepo;
import com.example.studentdetailsjparelationship.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;
    @Autowired
    private ReviewRepo reviewRepo;

    public void createStudent(Student student){
        student.getReviews().stream().forEach(reviewRepo::save);
        repo.save(student);
    }

    public void getStudentById(Integer id){
        System.out.println(repo.findById(id));
    }
}
