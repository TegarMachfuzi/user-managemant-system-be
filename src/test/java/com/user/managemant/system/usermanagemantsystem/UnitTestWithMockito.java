package com.user.managemant.system.usermanagemantsystem;
import com.user.managemant.system.usermanagemantsystem.model.User;
import com.user.managemant.system.usermanagemantsystem.repository.UserRepository;
import com.user.managemant.system.usermanagemantsystem.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = {UnitTestWithMockito.class})
public class UnitTestWithMockito {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    public List<User> myUsers;

    @Test
    @Order(1)
    public void test_getAllUsers()
    {

        List<User> myUsers = new ArrayList<User>();
        myUsers.add(new User(1L, "tegar", "123"));
        myUsers.add(new User(2L, "adam", "123"));
        Mockito.when(userRepository.findAll()).thenReturn(myUsers);
        Assert.assertEquals(2, userService.getAllUser().size());
    }

    @Test
    @Order(2)
    public void test_postUser()
    {
        User user = new User(3L, "raget", "123");
        Mockito.when(userRepository.save(user)).thenReturn(user);
    }

    @Test
    @Order(3)
    public void test_updateUser()
    {
        User user = new User(3l, "nazwa", "54321");
        Mockito.when(userRepository.save(user)).thenReturn(user);
    }
}