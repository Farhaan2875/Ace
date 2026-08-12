package com.farhaan.projects.Ace.services.impl;

import com.farhaan.projects.Ace.Dto.member.InviteMemberRequest;
import com.farhaan.projects.Ace.Dto.member.MemberResponse;
import com.farhaan.projects.Ace.Dto.member.UpdateMemberRoleRequest;
import com.farhaan.projects.Ace.entities.Project;
import com.farhaan.projects.Ace.entities.ProjectMember;
import com.farhaan.projects.Ace.entities.ProjectMemberId;
import com.farhaan.projects.Ace.entities.User;
import com.farhaan.projects.Ace.mapper.ProjectMemberMapper;
import com.farhaan.projects.Ace.repositories.ProjectMemberRepository;
import com.farhaan.projects.Ace.repositories.ProjectRepository;
import com.farhaan.projects.Ace.repositories.UserRepository;
import com.farhaan.projects.Ace.services.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;

    @Override
    public Void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Member not found in project");
        }
        projectMemberRepository.deleteById(projectMemberId);
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);


        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElse(null);

        projectMember.setProjectRole(request.role());
        projectMemberRepository.save(projectMember);
        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        User invitee = userRepository.findByUsername(request.username()).orElseThrow();

        if(invitee.getId().equals(userId)){
            throw new RuntimeException("cannot invite yourself");
        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, userId);

        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("cannot invite again");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();
        projectMemberRepository.save(member);
        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        return projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();
    }

    // INTERNAL FUNCTIONS FOR REDUNDANT CODE -> making code DRY
    public Project getAccessibleProjectById(Long id, Long userId) {
        return projectRepository.findAccessibleProjectById(id, userId).orElseThrow();
    }


}
