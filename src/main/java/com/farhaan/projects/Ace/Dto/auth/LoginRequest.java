package com.farhaan.projects.Ace.Dto.auth;

import jakarta.validation.constraints.*;

public record LoginRequest(
        @Email @NotBlank String email,
        @Size(min = 4, max = 50) String password
) {
}
