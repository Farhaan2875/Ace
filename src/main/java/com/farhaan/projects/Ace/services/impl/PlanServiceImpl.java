package com.farhaan.projects.Ace.services.impl;


import com.farhaan.projects.Ace.Dto.billing.PlanResponse;
import com.farhaan.projects.Ace.services.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
