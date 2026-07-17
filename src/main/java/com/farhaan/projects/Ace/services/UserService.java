package com.farhaan.projects.Ace.services;

import com.farhaan.projects.Ace.Dto.auth.UserProfileResponse;

public interface UserService {

    UserProfileResponse getProfile(Long userId);
}
