// package com.example.school.school.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.school.school.model.User;
// import com.example.school.school.service.UserService;

// import java.util.Optional;

// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
//         Optional<User> userOptional = userService.findByEmail(loginRequest.getEmail());

//         if (userOptional.isPresent()) {
//             User user = userOptional.get();
//             if (user.getPassword().equals(loginRequest.getPassword())) {
//                 return ResponseEntity.ok("Login successful");
//             } else {
//                 return ResponseEntity.status(401).body("Invalid credentials");
//             }
//         } else {
//             return ResponseEntity.status(401).body("Invalid credentials");
//         }
//     }
// }

// class LoginRequest {
//     private String email;
//     private String password;
//     public String getEmail() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
//     }
//     public Object getPassword() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
//     }

//     // Getters and setters
// }
