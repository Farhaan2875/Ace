package com.farhaan.projects.Ace.services;

import com.farhaan.projects.Ace.Dto.billing.PlanLimitsResponse;
import com.farhaan.projects.Ace.Dto.billing.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
