package com.farhaan.projects.Ace.mapper;


import com.farhaan.projects.Ace.Dto.auth.SignUpRequest;
import com.farhaan.projects.Ace.Dto.auth.UserProfileResponse;
import com.farhaan.projects.Ace.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
     User toEntity(SignUpRequest signUpRequest);

     UserProfileResponse toUserProfileResponse(User user);
}
