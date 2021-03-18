package com.online.sushibar.controllers;

import com.online.sushibar.entity.Food;
import com.online.sushibar.exception.ResourceNotFoundException;
import com.online.sushibar.service.FoodService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class FoodController {
    private final FoodService foodService;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/search")
    public String searchPage() {
        return "search";
    }

    @GetMapping("/found")
    public String getFoodBySearch(@RequestParam String text, @RequestParam String param) {
        if (text.equals("") || text.isBlank() || text.isEmpty()) {
            throw new RuntimeException("Input is empty");
        }
        Page<Food> foods;
        switch (param) {
            case "name":
                foods = foodService.getByName(text);
                break;
            case "type":
                foods = foodService. (text);
                break;
            case "desc":
                //logic
                break;
            default:
                throw new ResourceNotFoundException("Method Error");


        return "product";
    }
}
