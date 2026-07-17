package com.farhaan.projects.Ace.services;

import com.farhaan.projects.Ace.Dto.project.ProjectRequest;
import com.farhaan.projects.Ace.Dto.project.ProjectResponse;
import com.farhaan.projects.Ace.Dto.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProjectById(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

    void softDelete(Long id, Long userId);
}
