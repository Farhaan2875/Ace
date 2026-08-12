package com.farhaan.projects.Ace.mapper;

import com.farhaan.projects.Ace.Dto.member.MemberResponse;
import com.farhaan.projects.Ace.entities.ProjectMember;
import com.farhaan.projects.Ace.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {
    @Mapping(target = "userId", source = "id")
    @Mapping(target = "projectRole", constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId", source = "user.id") //nested mapping using . for nests
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "name", source = "user.name")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
