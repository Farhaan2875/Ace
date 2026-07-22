package com.farhaan.projects.Ace.services.impl;

import com.farhaan.projects.Ace.Dto.auth.UserProfileResponse;
import com.farhaan.projects.Ace.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
