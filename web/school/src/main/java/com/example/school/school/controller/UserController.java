// package com.example.school.school.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.school.school.model.Student;
// import com.example.school.school.service.UserService;

// @RestController
// @RequestMapping("/api/signup")
// public class UserController {
//     @Autowired
//     private UserService service;

//     @PostMapping
//     public ResponseEntity<Student> signup(@RequestBody Student user) {
//         Student savedUser = service.saveUser(user);
//         return ResponseEntity.ok(savedUser);
//     }
// }
