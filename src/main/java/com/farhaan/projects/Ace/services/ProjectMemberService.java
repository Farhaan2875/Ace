package com.farhaan.projects.Ace.services;

import com.farhaan.projects.Ace.Dto.member.InviteMemberRequest;
import com.farhaan.projects.Ace.Dto.member.MemberResponse;
import com.farhaan.projects.Ace.Dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId);

    MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
