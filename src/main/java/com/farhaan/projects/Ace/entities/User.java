package com.farhaan.projects.Ace.entities;

import java.time.Instant;

public class User {
    private Long id;
    private String email;
    private String passwordHash;
    private String name;
    private String avatarUrl;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

}
