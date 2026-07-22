package com.farhaan.projects.Ace.services.impl;

import com.farhaan.projects.Ace.Dto.member.InviteMemberRequest;
import com.farhaan.projects.Ace.Dto.member.MemberResponse;
import com.farhaan.projects.Ace.Dto.member.UpdateMemberRoleRequest;
import com.farhaan.projects.Ace.services.ProjectMemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        return List.of();
    }
}
