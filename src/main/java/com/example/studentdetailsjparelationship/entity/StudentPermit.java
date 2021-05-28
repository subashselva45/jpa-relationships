package com.example.studentdetailsjparelationship.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder(toBuilder = true)
public class StudentPermit {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
private String permitName;

private Instant createDate;





    public StudentPermit(String permitName, Instant createDate) {
        this.permitName = permitName;
        this.createDate = createDate;

    }
}
