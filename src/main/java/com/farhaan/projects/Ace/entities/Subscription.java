package com.farhaan.projects.Ace.entities;


import com.farhaan.projects.Ace.enums.SubscriptionStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription {

    Long id;
    User user; // hibernate ORM will take care of relationships (didn't define userId here)
    Plan plan;

    SubscriptionStatus status;

    String stripeCustomerId;
    String stripeSubscriptionId;

    Instant currentPeriodStart;
    Instant currentPeriodEnd; // will keep on updating as subscription continues

    Boolean cancelAtPeriodEnd = false; // if user wants to cancel the subscription when the period ends (bye default false)

    Instant createdAt;
    Instant updatedAt;

}
