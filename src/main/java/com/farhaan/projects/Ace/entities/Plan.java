package com.farhaan.projects.Ace.entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {
     Long id;
     String name;

     String stripePriceId;
     Integer maxProjects;
     Integer maxTokensPerDay;
     Integer maxPreviews;
     Boolean unlimitedAi; //unlimited access to LLM, ignores token limit

     //if plan is inactive user not allowed to use that plan
     Boolean active;
}
