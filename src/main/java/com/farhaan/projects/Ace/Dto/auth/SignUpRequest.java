package com.farhaan.projects.Ace.Dto.auth;

public record SignUpRequest(
        String email,
        String name,
        String password
) {
}
