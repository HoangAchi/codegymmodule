package com.achihoang.controller;

import com.achihoang.model.User;
import com.achihoang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class AccountController {

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public ModelAndView viewLogin() {
        ModelAndView modelAndView = new ModelAndView("/user/login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView checkLogin(@RequestParam("email") String email,@RequestParam("password") String password) {
        Iterable<User> userIterable = userService.findFirstByEmailContainingAndAndPassword(email,password);
        if (userIterable != null) {
            ModelAndView modelAndView = new ModelAndView("/user/login");
            modelAndView.addObject("user",userIterable);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/user/index");
            modelAndView.addObject("message", "login fail");
            return modelAndView;
        }
    }
}
