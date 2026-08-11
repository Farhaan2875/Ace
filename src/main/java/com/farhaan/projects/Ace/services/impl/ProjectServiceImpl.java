package com.farhaan.projects.Ace.services.impl;

import com.farhaan.projects.Ace.Dto.project.ProjectRequest;
import com.farhaan.projects.Ace.Dto.project.ProjectResponse;
import com.farhaan.projects.Ace.Dto.project.ProjectSummaryResponse;
import com.farhaan.projects.Ace.entities.Project;
import com.farhaan.projects.Ace.entities.User;
import com.farhaan.projects.Ace.error.ResourceNotFoundException;
import com.farhaan.projects.Ace.mapper.ProjectMapper;
import com.farhaan.projects.Ace.repositories.ProjectRepository;
import com.farhaan.projects.Ace.repositories.UserRepository;
import com.farhaan.projects.Ace.services.ProjectService;
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
@Transactional // if error occurs the row is not created and it is roll backed
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper; // alternative to model mapper - automatically maps -> see generated classes in target
    // also maps nested fields by generating relevant methods -> like user to userProfileResponse

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {

        return projectMapper.toProjectSummaryResponse(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow();
        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .isPublic(false)
                .build();
        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("You are not allowed to update this project");
        }
        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project = projectRepository.findAccessibleProjectById(id,userId).orElseThrow();
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("You are not allowed to delete this project");
        }else {
            project.setDeletedAt(Instant.now());
            projectRepository.save(project);
        }

    }

    // INTERNAL FUNCTIONS FOR REDUNDANT CODE -> making code DRY
    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId,userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
    }
}
