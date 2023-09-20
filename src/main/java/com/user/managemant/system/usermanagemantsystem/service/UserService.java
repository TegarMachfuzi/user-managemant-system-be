package com.user.managemant.system.usermanagemantsystem.service;

import com.user.managemant.system.usermanagemantsystem.dto.BaseResponseDto;
import com.user.managemant.system.usermanagemantsystem.dto.UserReqDto;
import com.user.managemant.system.usermanagemantsystem.dto.UserResponseDto;
import com.user.managemant.system.usermanagemantsystem.exception.ResourceNotFoundException;
import com.user.managemant.system.usermanagemantsystem.model.User;
import com.user.managemant.system.usermanagemantsystem.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public String createUser(UserReqDto userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);
        log.info("users {} is saved", user.getUser_id());
        return "sucsess post";
    }

    public List<UserResponseDto> getAllUser() {
        List<User> users = userRepository.findAll();
        
        return users.stream().map(this::mapToUserResponse).collect(Collectors.toList());
    }

    private UserResponseDto mapToUserResponse(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUser_id(user.getUser_id());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setPassword(user.getPassword());
        log.info("check {} mapping users", userResponseDto);
        return userResponseDto;
    }

    public User updateUser(long id, UserReqDto userReqDto) {
        User updateUserDetail = userRepository.findById(id).get();


        updateUserDetail.setUsername(userReqDto.getUsername());
        updateUserDetail.setPassword(userReqDto.getPassword());
        userRepository.save(updateUserDetail);

        log.info("check {} update users", updateUserDetail);
        return updateUserDetail;
    }

    public String deleteUser(long id) {
        User deleteUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Eploye not exist with id: " + id));
        userRepository.delete(deleteUser);
        return "Success Delete";
    }
}
