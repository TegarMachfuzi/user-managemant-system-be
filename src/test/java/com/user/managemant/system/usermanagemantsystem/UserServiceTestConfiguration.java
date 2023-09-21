package com.user.managemant.system.usermanagemantsystem;

import com.user.managemant.system.usermanagemantsystem.service.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class UserServiceTestConfiguration {
    @Bean
    @Primary
    public UserService userService(){
        return Mockito.mock(UserService.class);
    }
}
