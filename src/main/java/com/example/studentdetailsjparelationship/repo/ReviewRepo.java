package com.example.studentdetailsjparelationship.repo;

import com.example.studentdetailsjparelationship.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Integer> {
}
