package com.example.school.school.DTO;

import com.example.school.school.model.Enrolment;
import com.example.school.school.model.Student;

public class StudentEnrolmentDTO {
    private Student student;
    private Enrolment enrolment;

    // Getters and setters
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Enrolment getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(Enrolment enrolment) {
        this.enrolment = enrolment;
    }
}
