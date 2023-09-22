package com.user.managemant.system.usermanagemantsystem.service.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.user.managemant.system.usermanagemantsystem.dto.UserReqDto;
import com.user.managemant.system.usermanagemantsystem.dto.UserResponseDto;

import java.util.List;

public interface UserServiceImpl {
    String createUser(UserReqDto userReqDto) throws JsonProcessingException;

    List<UserResponseDto> getAllUser();

    Object updateUser(long id, UserReqDto userReqDto) throws JsonProcessingException;

    Object getById(long id) throws JsonProcessingException;

    String deleteUser(long id);





}