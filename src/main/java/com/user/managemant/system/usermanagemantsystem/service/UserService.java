package com.user.managemant.system.usermanagemantsystem.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.user.managemant.system.usermanagemantsystem.controller.UserController;
import com.user.managemant.system.usermanagemantsystem.dto.UserReqDto;
import com.user.managemant.system.usermanagemantsystem.dto.UserResponseDto;
import com.user.managemant.system.usermanagemantsystem.exception.ResourceNotFoundException;
import com.user.managemant.system.usermanagemantsystem.model.User;
import com.user.managemant.system.usermanagemantsystem.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final Logger log = LogManager.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public String createUser(UserReqDto userRequest) throws JsonProcessingException {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);
        log.info("users {} is saved", objectMapper.writeValueAsString(user));
        return "sucsess post";
    }

    public List<UserResponseDto> getAllUser() {
        List<User> users = userRepository.findAll();
        
        return users.stream().map(this::mapToUserResponse).collect(Collectors.toList());
    }

    private UserResponseDto mapToUserResponse(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUserId(user.getUserId());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setPassword(user.getPassword());
        try {
            log.info("{}", objectMapper.writeValueAsString(userResponseDto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return userResponseDto;
    }

    public Object updateUser(long id, UserReqDto userReqDto) throws JsonProcessingException {
        User updateUserDetail = userRepository.findById(id).get();
        updateUserDetail.setUsername(userReqDto.getUsername());
        updateUserDetail.setPassword(userReqDto.getPassword());
        userRepository.save(updateUserDetail);

        log.info("check {} update users", objectMapper.writeValueAsString(updateUserDetail));
        return updateUserDetail;
    }

    public Object getById(long id) throws JsonProcessingException {
        User updateUserDetail = userRepository.findById(id).get();
        userRepository.save(updateUserDetail);

        log.info("check {} getById users", objectMapper.writeValueAsString(updateUserDetail));
        return updateUserDetail;
    }

    public String deleteUser(long id) {
        User deleteUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Eploye not exist with id: " + id));
        userRepository.delete(deleteUser);
        return "Success Delete";
    }
}
