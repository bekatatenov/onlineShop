package com.online.sushibar.controllers;

import com.online.sushibar.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class FoodController {
    private final FoodService foodService;


    @GetMapping("/")
    public String index() {
        return "index";
    }
}
