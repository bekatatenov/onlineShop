package com.online.sushibar.controllers;


import com.online.sushibar.entity.Food;
import com.online.sushibar.service.FoodService;
import com.online.sushibar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class MainController {
    private final UserService userService;
    private final FoodService foodService;

    @GetMapping
    public String index(@RequestParam(defaultValue = "1") Integer page, Model model, Principal principal, HttpServletRequest uriBuilder) {

        Page<Food> allFood = foodService.getAllFood(PageRequest.of(page - 1, 4));
        model.addAttribute("foods", allFood.getContent());
        model.addAttribute("pages", allFood.getTotalPages());
        var uri = uriBuilder.getRequestURI();
        try {
            var user = userService.getByEmail(principal.getName());
            model.addAttribute("user", user);
        } catch (NullPointerException ex) {
            model.addAttribute("noauth", true);
        }
        return "index";
    }

}
