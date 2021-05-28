package com.example.studentdetailsjparelationship;

import com.example.studentdetailsjparelationship.entity.Review;
import com.example.studentdetailsjparelationship.entity.Student;
import com.example.studentdetailsjparelationship.entity.StudentPermit;
import com.example.studentdetailsjparelationship.repo.StudentPermitRepo;
import com.example.studentdetailsjparelationship.repo.StudentRepo;
import com.example.studentdetailsjparelationship.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Arrays;

@SpringBootApplication
public class StudentDetailsJparelationshipApplication {

    @Autowired
    private StudentRepo repo;

    @Autowired
    private StudentPermitRepo permitRepo;
    @Autowired
    private StudentService service;

    public static void main(String[] args) {
        SpringApplication.run(StudentDetailsJparelationshipApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            StudentPermit permit = StudentPermit.builder().permitName("study").createDate(Instant.now()).build();
            StudentPermit permit1 = StudentPermit.builder().permitName("PR").createDate(Instant.now()).build();
            StudentPermit permit2 = StudentPermit.builder().permitName("work").createDate(Instant.now()).build();
            // StudentPermit permit = new StudentPermit("Study",Instant.now());
            Review review = Review.builder().reviewName("Java fullstack").reviewText("Happy with the course").build();

            Student student = new Student("Subash",26, Instant.now(),Instant.now(),permit,
                    Arrays.asList(Review.builder().reviewName("Java fullstack").reviewText("very good").build(),
                            Review.builder().reviewName("Devops").reviewText("Excellent").build(),
                            Review.builder().reviewName("QA Automation").reviewText("Could have been better").build())) ;
            Student student1 = new Student("Dhatch",27, Instant.now(),Instant.now(),permit1,Arrays.asList(Review.builder()
                            .reviewName("Java fullstack").reviewText("very good").student(student).build(),
                    Review.builder().reviewName("Devops").reviewText("Excellent").build(),
                    Review.builder().reviewName("QA Automation").reviewText("Could have been better").build())) ;
            Student student2 = new Student("Aravindh",26, Instant.now(),Instant.now(),permit2,Arrays.asList(Review.builder().reviewName("Java fullstack").reviewText("very good").student(student1).build(),
                    Review.builder().reviewName("Devops").reviewText("Excellent").build(),
                    Review.builder().reviewName("QA Automation").reviewText("Could have been better").build())) ;
            //permitRepo.save(permit);
            service.createStudent(student);
            service.createStudent(student1);
            service.createStudent(student2);
            //service.getStudentById(1);
        };
    }




}
