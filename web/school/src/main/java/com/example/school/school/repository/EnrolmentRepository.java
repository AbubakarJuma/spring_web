package com.example.school.school.repository;

import com.example.school.school.model.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {
}
