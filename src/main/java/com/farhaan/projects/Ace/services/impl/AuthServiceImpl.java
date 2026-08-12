package com.farhaan.projects.Ace.services.impl;

import com.farhaan.projects.Ace.Dto.auth.AuthResponse;
import com.farhaan.projects.Ace.Dto.auth.LoginRequest;
import com.farhaan.projects.Ace.Dto.auth.SignUpRequest;
import com.farhaan.projects.Ace.entities.User;
import com.farhaan.projects.Ace.error.BadRequestException;
import com.farhaan.projects.Ace.mapper.UserMapper;
import com.farhaan.projects.Ace.repositories.UserRepository;
import com.farhaan.projects.Ace.services.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;


    @Override
    public AuthResponse signup(SignUpRequest request) {
        userRepository.findByUsername(request.username()).ifPresent(user -> {
            throw new BadRequestException("User already exists with username " + request.username());
        });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);

        return new AuthResponse("dummy", userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
