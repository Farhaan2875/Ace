package com.farhaan.projects.Ace.services.impl;

import com.farhaan.projects.Ace.Dto.billing.PlanLimitsResponse;
import com.farhaan.projects.Ace.Dto.billing.UsageTodayResponse;
import com.farhaan.projects.Ace.services.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
