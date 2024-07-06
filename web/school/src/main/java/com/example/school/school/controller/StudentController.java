package com.example.school.school.controller;

import com.example.school.school.DTO.StudentEnrolmentDTO;
import com.example.school.school.model.Enrolment;
import com.example.school.school.model.Student;
import com.example.school.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentEnrolmentDTO studentEnrolmentDTO) {
        Student savedStudent = studentService.saveStudent(studentEnrolmentDTO.getStudent(), studentEnrolmentDTO.getEnrolment());
        return ResponseEntity.ok(savedStudent);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
    //     Optional<Student> existingStudent = studentService.getStudentById(id);
    //     if (existingStudent.isPresent()) {
    //         student.setId(id);
    //         Student updatedStudent = studentService.up;
    //         return ResponseEntity.ok(updatedStudent);
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
