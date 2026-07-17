package com.farhaan.projects.Ace.Dto.project;

import com.farhaan.projects.Ace.Dto.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {

}
