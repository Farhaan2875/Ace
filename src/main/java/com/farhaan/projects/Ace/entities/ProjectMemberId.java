package com.farhaan.projects.Ace.entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectMemberId { // acts as a composite Key for project Member
    Long projectId;
    Long userId;
}
