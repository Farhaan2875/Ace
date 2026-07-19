package com.farhaan.projects.Ace.Dto.project;

import java.time.Instant;


public record FileNode(
        String path,
        Instant modifiedAT,
        Long size,
        String type

) {
}
