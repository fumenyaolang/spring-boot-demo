package com.fmyl.demo.controller;

import com.fmyl.demo.base.BaseController;
import com.fmyl.demo.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * user controller
 * Created by fuzq on 17/6/30.
 */
//@EnableAutoConfiguration
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping("/{id}")
    public User view(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("zhang");
        return user;
    }

    public static void main(String[] args) {
        // SpringApplication.run(UserController.class);
    }

}
