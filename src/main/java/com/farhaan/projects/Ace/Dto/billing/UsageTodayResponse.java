package com.farhaan.projects.Ace.Dto.billing;

public record UsageTodayResponse(
        int tokenUsed,
        int tokenLimit,
        int previewRunning,
        int previewLimit
) {
}
