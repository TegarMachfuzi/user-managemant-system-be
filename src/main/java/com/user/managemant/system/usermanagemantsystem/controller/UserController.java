package com.user.managemant.system.usermanagemantsystem.controller;

import com.user.managemant.system.usermanagemantsystem.dto.BaseResponseDto;
import com.user.managemant.system.usermanagemantsystem.dto.UserReqDto;
import com.user.managemant.system.usermanagemantsystem.dto.UserResponseDto;
import com.user.managemant.system.usermanagemantsystem.exception.ExceptionUser;
import com.user.managemant.system.usermanagemantsystem.exception.RestFailedException;
import com.user.managemant.system.usermanagemantsystem.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    private static final Logger log = LogManager.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping
    public BaseResponseDto<Object> createUser(@RequestBody UserReqDto userRequest) {
        BaseResponseDto<Object> result = new BaseResponseDto<>();
        try {
           Object obj =  userService.createUser(userRequest);
           result.setStatus(HttpStatus.OK.value());
           result.setInfo(HttpStatus.OK.name());
           result.setContent(obj);
           log.info("info content new user api: {}", result);
        }catch (ExceptionUser e){
            result.setStatus(e.getStatusCode());
            result.setInfo(e.getMessage());
        }catch (RestFailedException e){
            result.setStatus(e.getStatusCode());
            result.setInfo(e.getMessage());
        }catch (Exception e){
            result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            result.setInfo("Internal System Error.");
            log.error(e);
        }
        return result;

   }

   @GetMapping
   public List<UserResponseDto> getAllUser(){
        return userService.getAllUser();
   }

   @PutMapping("{id}")
   public BaseResponseDto<Object> updateUser(@PathVariable long id, @RequestBody UserReqDto userUpdateDetails){
       BaseResponseDto<Object> result = new BaseResponseDto<>();
       try {
           Object userUpdate = userService.updateUser(id, userUpdateDetails);
           result.setStatus(HttpStatus.OK.value());
           result.setInfo(HttpStatus.OK.name());
           result.setContent(userUpdate);
           log.info("info update user: {}", result);
       }catch (ExceptionUser e){
           result.setStatus(e.getStatusCode());
           result.setInfo(e.getMessage());
       }catch (RestFailedException e) {
           result.setStatus(e.getStatusCode());
           result.setInfo(e.getMessage());
       }catch (Exception e){
           result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
           result.setInfo("UserId Not Found.");
           log.error(e);
       }
       return result;

   }

   @DeleteMapping("{id}")
   public BaseResponseDto<Object> deleteUser(@PathVariable long id){
       BaseResponseDto<Object> result = new BaseResponseDto<>();
       try {
           Object deleteUser = userService.deleteUser(id);
           result.setStatus(HttpStatus.OK.value());
           result.setInfo(HttpStatus.OK.name());
           result.setContent(deleteUser);
           log.info("deleteUser: {}", result);
       }catch (ExceptionUser e){
           result.setStatus(e.getStatusCode());
           result.setInfo(e.getMessage());
       }catch (RestFailedException e) {
           result.setStatus(e.getStatusCode());
           result.setInfo(e.getMessage());
       }catch (Exception e){
           result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
           result.setInfo("UserId Not Found.");
           log.error(e);
       }
       return result;
   }
}
