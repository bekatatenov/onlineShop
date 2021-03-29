package com.online.sushibar.controllers;


import com.online.sushibar.exception.ResourceNotFoundException;
import com.online.sushibar.form.RegisterForm;
import com.online.sushibar.form.ResetForm;
import com.online.sushibar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @GetMapping("/register")
    public String addUser(Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new RegisterForm());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid RegisterForm form, BindingResult bindingResult) throws BindException {

        if (bindingResult.hasFieldErrors()) {
            throw new BindException(bindingResult);
        }
        userService.register(form);
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/profile")
    public String pageCustomerProfile(Model model, Principal principal) {
        var user = userService.getByEmail(principal.getName());
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/forgotpass")
    public String pageForgoTPass(Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new ResetForm());
        }
        return "forgot";
    }

    @PostMapping("/forgot")
    public String SendEmailWithPass(@Valid ResetForm form, BindingResult bindingResult) throws BindException {
        if (bindingResult.hasFieldErrors()) {
            throw new BindException(bindingResult);
        }
        if (!userService.existByEmail(form.getEmail())) {
            throw new ResourceNotFoundException("There is no user with such email" + form.getEmail());
        }

        return "check-forgot-pass";

    }

    private void sendEmail(String email) {

    }
}
