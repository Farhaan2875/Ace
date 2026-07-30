package com.farhaan.projects.Ace.entities;


import com.farhaan.projects.Ace.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "project_members")
public class ProjectMember { // Acts as a join table
    @EmbeddedId //cant use @Id as we are having composite if
    ProjectMemberId projectMemberId; // composite primary key

    @ManyToOne
    @MapsId("projectId")
    Project project;

    @ManyToOne
    @MapsId("userId") // We mapped userId of composite key to user so that we dont create duplicate keys -> prevent ambiguity
    // DID ALL THIS TO PREVENT US FROM MAKING A JOIN TABLE AND USING EXTRA MEMORY -> also in join table we cant add additional fields
    User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ProjectRole  projectRole;

    Instant invitedAt;

    Instant acceptedAt;


}
