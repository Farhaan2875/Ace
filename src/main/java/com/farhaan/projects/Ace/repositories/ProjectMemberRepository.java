package com.farhaan.projects.Ace.repositories;

import com.farhaan.projects.Ace.entities.ProjectMember;
import com.farhaan.projects.Ace.entities.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

}
