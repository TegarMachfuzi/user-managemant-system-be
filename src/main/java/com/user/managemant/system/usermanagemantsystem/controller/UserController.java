package com.user.managemant.system.usermanagemantsystem.controller;

import com.user.managemant.system.usermanagemantsystem.dto.UserReqDto;
import com.user.managemant.system.usermanagemantsystem.dto.UserResponseDto;
import com.user.managemant.system.usermanagemantsystem.model.User;
import com.user.managemant.system.usermanagemantsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestBody UserReqDto userRequest) {
        userService.createUser(userRequest);
   }

   @GetMapping
   public List<UserResponseDto> getAllUser(){
        return userService.getAllUser();
   }

   @PutMapping("{id}")
   public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userUpdateDetails){
        return userService.updateUser(id, userUpdateDetails);
   }

   @DeleteMapping("{id}")
   public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
   }
}
