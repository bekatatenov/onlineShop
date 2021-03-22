package com.online.sushibar.controllers;


import com.online.sushibar.form.RegisterForm;
import com.online.sushibar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @GetMapping("/register")
    public String addUser() {
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid RegisterForm form, BindingResult bindingResult) throws BindException {

        if (bindingResult.hasFieldErrors()) {
            throw new BindException(bindingResult);
        }

        // There will be business logic

        return "index";
    }
}
