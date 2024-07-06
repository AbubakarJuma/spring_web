package com.example.school.school.service;

import com.example.school.school.model.Application;
import com.example.school.school.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    // Create or Update an Application
    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    // Get all Applications
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Get an Application by ID
    public Optional<Application> getApplicationById(Long id) {
        return applicationRepository.findById(id);
    }

    // Delete an Application by ID
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}
