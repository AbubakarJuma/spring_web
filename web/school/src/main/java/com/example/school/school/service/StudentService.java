package com.example.school.school.service;

import com.example.school.school.model.Application;
import com.example.school.school.model.Enrolment;
import com.example.school.school.model.Student;
import com.example.school.school.repository.ApplicationRepository;
import com.example.school.school.repository.EnrolmentRepository;
import com.example.school.school.repository.StudentRepository;

import org.bouncycastle.est.EnrollmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
@Autowired
    private EnrolmentRepository enrolmentRepository;
    @Autowired
    private ApplicationRepository applicationRepository;
    // Create or Update a Student
    public Student saveStudent(Student student,Enrolment enrolment) {
        Student student2 = new Student();
        student2.setFirstName(student.getFirstName());
        student2.setLastName(student.getLastName());
        student2.setDob(student.getDob());
        student2.setEmail(student.getEmail());
        student2.setCourse(student.getCourse());

        Student savedStudent = studentRepository.save(student2);

        Enrolment enrolment2 = new Enrolment();
        Optional<Application> applicationOptional = applicationRepository.findById(enrolment.getApplication().getId());
        if (applicationOptional.isPresent()) {
            enrolment2.setApplication(applicationOptional.get());
        } else {
            // Handle the case where the application is not found
            throw new RuntimeException("Application not found");
        }
        enrolment2.setStudent(savedStudent);
        enrolment2.setEnrolmentStatus(enrolment.getEnrolmentStatus());
        enrolment2.setDate(enrolment.getDate());

       Enrolment savedEnrolment = enrolmentRepository.save(enrolment2);
       return savedStudent;

     
    }

    // Get all Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get a Student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Delete a Student by ID
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public static Student getUserByUserName(String userName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserByUserName'");
    }
}
