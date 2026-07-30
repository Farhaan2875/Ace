package com.farhaan.projects.Ace.Dto.member;

import com.farhaan.projects.Ace.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String email,
        String name,
        ProjectRole projectRole,
        Instant invitedAt
) {
}
