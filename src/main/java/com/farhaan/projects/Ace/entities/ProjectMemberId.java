package com.farhaan.projects.Ace.entities;


import jakarta.persistence.Embeddable;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable // allows to use this composite id across multiple tables
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMemberId { // acts as a composite Key for project Member
    Long projectId;
    Long userId;
}
