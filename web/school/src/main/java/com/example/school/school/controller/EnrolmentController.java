package com.example.school.school.controller;

import com.example.school.school.model.Enrolment;
import com.example.school.school.service.EnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrolments")
public class EnrolmentController {

    @Autowired
    private EnrolmentService enrolmentService;

    @PostMapping
    public ResponseEntity<Enrolment> createEnrolment(@RequestBody Enrolment enrolment) {
        Enrolment savedEnrolment = enrolmentService.saveEnrolment(enrolment);
        return ResponseEntity.ok(savedEnrolment);
    }

    @GetMapping
    public ResponseEntity<List<Enrolment>> getAllEnrolments() {
        List<Enrolment> enrolments = enrolmentService.getAllEnrolments();
        return ResponseEntity.ok(enrolments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrolment> getEnrolmentById(@PathVariable Long id) {
        Optional<Enrolment> enrolment = enrolmentService.getEnrolmentById(id);
        return enrolment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrolment> updateEnrolment(@PathVariable Long id, @RequestBody Enrolment enrolment) {
        Optional<Enrolment> existingEnrolment = enrolmentService.getEnrolmentById(id);
        if (existingEnrolment.isPresent()) {
            enrolment.setEnrolmentId(id);
            Enrolment updatedEnrolment = enrolmentService.saveEnrolment(enrolment);
            return ResponseEntity.ok(updatedEnrolment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrolment(@PathVariable Long id) {
        enrolmentService.deleteEnrolment(id);
        return ResponseEntity.noContent().build();
    }
}
