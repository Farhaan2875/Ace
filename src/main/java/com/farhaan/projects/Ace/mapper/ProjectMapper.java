package com.farhaan.projects.Ace.mapper;

import com.farhaan.projects.Ace.Dto.project.ProjectResponse;
import com.farhaan.projects.Ace.entities.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper { // BETTER ALTERNATIVE TO MODEL MAPPER (FASTER AND MORE PRODUCTION READY)

    ProjectResponse toProjectResponse(Project project); // JUST THIS -> DEFINES THE CODE FOR US
}
