package com.farhaan.projects.Ace.Dto.auth;

import jakarta.validation.constraints.*;

public record LoginRequest(
        @Email @NotBlank String username,
        @Size(min = 4, max = 50) String password
) {
}
