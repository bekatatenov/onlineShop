package com.online.sushibar.controllers;

import com.online.sushibar.entity.BasketFood;
import com.online.sushibar.entity.Food;
import com.online.sushibar.entity.Order;
import com.online.sushibar.entity.ReviewForFood;
import com.online.sushibar.exception.ResourceNotFoundException;
import com.online.sushibar.repository.OrderRepository;
import com.online.sushibar.repository.ReviewRepository;
import com.online.sushibar.service.FoodService;
import com.online.sushibar.service.UserService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.dom4j.rule.Mode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class FoodController {
    private final FoodService foodService;
    private final UserService userService;
    private final ReviewRepository reviewRepository;
    private final OrderRepository orderRepository;
    private final Integer size = 4;


    @GetMapping("/food/{id}")
    public String foodInfo(@PathVariable Long id, Principal principal, Model model) {
        if (!foodService.existById(id)) {
            throw new ResourceNotFoundException("There is no such food with " + id + " id");
        }

        Food byId = foodService.getById(id);

        try {
            var user = userService.getByEmail(principal.getName());
            model.addAttribute("user", user);
            List<Order> allByBasket_user = orderRepository.findAllByBasket_User(user);
            for (Order r :
                    allByBasket_user) {
                for (BasketFood f :
                        r.getBasket().getFoods()) {
                    if (f.getFood().getId() == id) {
                        model.addAttribute("addReview", true);
                    }
                }
            }

        } catch (NullPointerException ex) {
            model.addAttribute("noauth", true);
        }

        List<ReviewForFood> allByFood = reviewRepository.findAllByFood(byId);
        model.addAttribute("reviews", allByFood);
        model.addAttribute("food",byId);

        return "food";
    }

    @GetMapping("/found")
    public String getFoodBySearch(Principal principal, @RequestParam(defaultValue = "1") Integer page, @RequestParam String text, @RequestParam String param, Model model) {
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

        if (foods.getContent().size() < 1) {
            throw new RuntimeException("Not Found");
        }
        model.addAttribute("pages", foods.getTotalPages());
        model.addAttribute("elems", foods.getTotalElements());
        model.addAttribute("foods", foods.getContent());
        model.addAttribute("type", param);
        model.addAttribute("text", text);
        try {
            var user = userService.getByEmail(principal.getName());
            model.addAttribute("user", user);
        } catch (NullPointerException ex) {
            model.addAttribute("noauth", true);
        }
        return "index";
    }
}
