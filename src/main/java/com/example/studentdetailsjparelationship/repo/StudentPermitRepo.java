package com.example.studentdetailsjparelationship.repo;

import com.example.studentdetailsjparelationship.entity.StudentPermit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPermitRepo extends JpaRepository<StudentPermit,Integer> {
}
