package com.example.school.school.service;

import com.example.school.school.model.Enrolment;
import com.example.school.school.repository.EnrolmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrolmentService {

    @Autowired
    private EnrolmentRepository enrolmentRepository;

    // Create or Update an Enrolment
    public Enrolment saveEnrolment(Enrolment enrolment) {
        return enrolmentRepository.save(enrolment);
    }

    // Get all Enrolments
    public List<Enrolment> getAllEnrolments() {
        return enrolmentRepository.findAll();
    }

    // Get an Enrolment by ID
    public Optional<Enrolment> getEnrolmentById(Long id) {
        return enrolmentRepository.findById(id);
    }

    // Delete an Enrolment by ID
    public void deleteEnrolment(Long id) {
        enrolmentRepository.deleteById(id);
    }
}
