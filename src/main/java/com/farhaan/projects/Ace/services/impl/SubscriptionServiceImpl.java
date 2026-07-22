package com.farhaan.projects.Ace.services.impl;

import com.farhaan.projects.Ace.Dto.billing.CheckoutRequest;
import com.farhaan.projects.Ace.Dto.billing.CheckoutResponse;
import com.farhaan.projects.Ace.Dto.billing.PortalResponse;
import com.farhaan.projects.Ace.Dto.billing.SubscriptionResponse;
import com.farhaan.projects.Ace.services.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }
}
