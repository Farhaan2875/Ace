package com.farhaan.projects.Ace.mapper;

import com.farhaan.projects.Ace.Dto.project.ProjectResponse;
import com.farhaan.projects.Ace.Dto.project.ProjectSummaryResponse;
import com.farhaan.projects.Ace.entities.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper { // BETTER ALTERNATIVE TO MODEL MAPPER (FASTER AND MORE PRODUCTION READY)
    // ONE THING TO KEEP IN MIND IS THAT IT ONLY MAPS Fileds with the same name other fields are ignored, or you have to use @Mapping with target in that case

    ProjectResponse toProjectResponse(Project project); // JUST THIS -> DEFINES THE CODE FOR US

    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse> toProjectSummaryResponse(List<Project> projects); // CREATES THE FUNCTIONS FOR US (SPRING MAGIC_
}
