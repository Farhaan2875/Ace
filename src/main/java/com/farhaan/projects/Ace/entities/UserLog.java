package com.farhaan.projects.Ace.entities;

import java.time.Instant;

public class UserLog {
    Long id;
    User user;
    Project project;

    String action;

    Integer tokensUsed;

    Integer durationMs;

    String metaData;

    Instant createdAt;
}
