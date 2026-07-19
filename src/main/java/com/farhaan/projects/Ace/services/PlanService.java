package com.farhaan.projects.Ace.services;

import com.farhaan.projects.Ace.Dto.billing.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();

}
