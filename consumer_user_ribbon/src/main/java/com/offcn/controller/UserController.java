package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser(Long id){
        return userService.getUser(id);
    }

    @RequestMapping("/buyMovie")
    public Map buyMovie(Long userId){
        return userService.buyMovie(userId);
    }
}
