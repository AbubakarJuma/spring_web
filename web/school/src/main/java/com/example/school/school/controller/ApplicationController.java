package com.example.school.school.controller;

import com.example.school.school.model.Application;
import com.example.school.school.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        Application savedApplication = applicationService.saveApplication(application);
        return ResponseEntity.ok(savedApplication);
    }

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.getAllApplications();
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        Optional<Application> application = applicationService.getApplicationById(id);
        return application.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable Long id, @RequestBody Application application) {
        Optional<Application> existingApplication = applicationService.getApplicationById(id);
        if (existingApplication.isPresent()) {
            application.setId(id);
            Application updatedApplication = applicationService.saveApplication(application);
            return ResponseEntity.ok(updatedApplication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}
