package com.farhaan.projects.Ace.Dto.member;

import com.farhaan.projects.Ace.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
