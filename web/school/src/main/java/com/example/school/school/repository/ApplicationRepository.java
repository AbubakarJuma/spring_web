package com.example.school.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.school.school.model.Application;
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
