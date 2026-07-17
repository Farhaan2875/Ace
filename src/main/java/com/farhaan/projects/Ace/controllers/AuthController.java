package com.farhaan.projects.Ace.controllers;

import com.farhaan.projects.Ace.Dto.auth.AuthResponse;
import com.farhaan.projects.Ace.Dto.auth.LoginRequest;
import com.farhaan.projects.Ace.Dto.auth.SignUpRequest;
import com.farhaan.projects.Ace.Dto.auth.UserProfileResponse;
import com.farhaan.projects.Ace.services.AuthService;
import com.farhaan.projects.Ace.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/soignup")
    public ResponseEntity<AuthResponse> singup(SignUpRequest request) {
        return ResponseEntity.ok(authService.signup(request));

    }

    @PostMapping
    public ResponseEntity<AuthResponse> login(LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }

}
