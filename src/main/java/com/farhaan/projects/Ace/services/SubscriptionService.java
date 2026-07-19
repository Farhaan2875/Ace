package com.farhaan.projects.Ace.services;

import com.farhaan.projects.Ace.Dto.billing.CheckoutRequest;
import com.farhaan.projects.Ace.Dto.billing.CheckoutResponse;
import com.farhaan.projects.Ace.Dto.billing.PortalResponse;
import com.farhaan.projects.Ace.Dto.billing.SubscriptionResponse;


public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
