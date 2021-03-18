package com.online.sushibar.controllers;

import com.online.sushibar.entity.Food;
import com.online.sushibar.exception.ResourceNotFoundException;
import com.online.sushibar.service.FoodService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.dom4j.rule.Mode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class FoodController {
    private final FoodService foodService;
    private final Integer size = 2;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "1") Integer page, Model model) {

        Page<Food> allFood = foodService.getAllFood(PageRequest.of(page - 1, 6));
        model.addAttribute("foods", allFood.getContent());
        model.addAttribute("pages",allFood.getTotalPages());
        return "index";
    }

    @GetMapping("/search")
    public String searchPage() {
        return "search";
    }

    @GetMapping("/found")
    public String getFoodBySearch(@RequestParam(defaultValue = "1") Integer page, @RequestParam String text, @RequestParam String param, Model model) {
        if (text.equals("") || text.isBlank() || text.isEmpty()) {
            throw new RuntimeException("Input is empty");
        }
        Page<Food> foods;
        switch (param) {
            case "name":
                text = text.toUpperCase();
                foods = foodService.getByName(PageRequest.of(page - 1, size), text);
                break;
            case "type":
                foods = foodService.getByType(PageRequest.of(page - 1, size), text);
                break;
            case "desc":
                foods = foodService.getByDesc(PageRequest.of(page - 1, size), text);
                break;
            default:
                throw new ResourceNotFoundException("Method Error");
        }

        if(foods.getContent().size()<1)
        {
            throw new RuntimeException("Not Found");
        }
        model.addAttribute("pages", foods.getTotalPages());
        model.addAttribute("elems", foods.getTotalElements());
        model.addAttribute("foods", foods.getContent());
        model.addAttribute("type", param);
        model.addAttribute("text", text);
        return "product";
    }
}
