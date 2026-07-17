package com.farhaan.projects.Ace.Dto.auth;


public record AuthResponse(String token, UserProfileResponse user){ // Record makes private, final, defines constructors, getter, hash code and equals by itself
    // used with dto very much -> as its made immutable


}
