package com.example.studentdetailsjparelationship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private Instant createDate;

    private Instant updateDate;
    @OneToOne(cascade = CascadeType.ALL)
    private StudentPermit permit;
    @OneToMany(mappedBy = "student")
    private List<Review> reviews = new ArrayList<>();

    public Student(String name, Integer age, Instant createDate, Instant updateDate, StudentPermit permit, List<Review> reviews) {
        this.name = name;
        this.age = age;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.permit = permit;
        this.reviews = reviews;
    }
}
