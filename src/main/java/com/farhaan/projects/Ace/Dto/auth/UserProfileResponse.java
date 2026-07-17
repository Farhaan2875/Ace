package com.farhaan.projects.Ace.Dto.auth;

public record UserProfileResponse(
        Long id,
        String email,
        String name,
        String avatarUrl

) {
}
