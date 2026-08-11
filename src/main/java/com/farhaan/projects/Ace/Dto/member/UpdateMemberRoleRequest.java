package com.farhaan.projects.Ace.Dto.member;

import com.farhaan.projects.Ace.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role
) {
}
