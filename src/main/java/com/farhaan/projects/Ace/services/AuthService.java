package com.farhaan.projects.Ace.services;

import com.farhaan.projects.Ace.Dto.auth.AuthResponse;
import com.farhaan.projects.Ace.Dto.auth.LoginRequest;
import com.farhaan.projects.Ace.Dto.auth.SignUpRequest;



public interface AuthService {
    AuthResponse signup(SignUpRequest request);

    AuthResponse login(LoginRequest request);
}
