package com.online.sushibar.controllers;

import com.online.sushibar.entity.Basket;
import com.online.sushibar.entity.BasketFood;
import com.online.sushibar.entity.Food;
import com.online.sushibar.exception.ResourceNotFoundException;
import com.online.sushibar.form.AddingFoodToBasketForm;
import com.online.sushibar.form.RegisterForm;
import com.online.sushibar.service.BasketFoodService;
import com.online.sushibar.service.BasketService;
import com.online.sushibar.service.FoodService;
import com.online.sushibar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yaml.snakeyaml.scanner.Constant;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basket")
public class BasketController {
    private final BasketService basketService;
    private final BasketFoodService basketFoodService;
    private final UserService userService;
    private final FoodService foodService;


    @PostMapping("/add")
    public String addFood(@Valid AddingFoodToBasketForm form, BindingResult bindingResult, Principal principal, HttpSession session) throws BindException {

        if (bindingResult.hasFieldErrors()) {
            throw new BindException(bindingResult);
        }
        var user = userService.getByEmail(principal.getName());
        if (!foodService.existById(form.getFoodId())) {
            throw new ResourceNotFoundException("Not Found");
        }
        var food = foodService.getById(form.getFoodId());
        if (basketService.findBySession(session.getId()) == null) {
            List<BasketFood> list = new ArrayList<>();
            Basket basket = new Basket(session.getId(), user);
            BasketFood basketFood = new BasketFood(1, basket, food);
            list.add(basketFood);
            basketService.save(basket);
            basketFoodService.save(basketFood);
            basketService.save(basket);

        } else {
            Basket basket = basketService.findBySession(session.getId());
            BasketFood basketFood = new BasketFood(1, basket, food);
            basketFoodService.save(basketFood);
        }
        session.removeAttribute(Constants.CART_ID);
        session.setAttribute(Constants.CART_ID, basketService.findBySession(session.getId()));

        return "redirect:/";
    }

    @GetMapping()
    public String showBasket(Principal principal, HttpSession session, Model model) {
        var user = userService.getByEmail(principal.getName());
        Basket bySession = basketService.findBySession(session.getId());
        List<BasketFood> foods = bySession.getFoods();

        model.addAttribute("foods", foods);
        model.addAttribute("user, user");
        return "basket";
    }


    @PostMapping("/delete")
    public String deletefromBasket(@Valid AddingFoodToBasketForm form, BindingResult bindingResult, Principal principal, HttpSession session) throws BindException {
        if (bindingResult.hasFieldErrors()) {
            throw new BindException(bindingResult);
        }
        var user = userService.getByEmail(principal.getName());
        if (!foodService.existById(form.getFoodId())) {
            throw new ResourceNotFoundException("Not Found");
        }
        var food = foodService.getById(form.getFoodId());
        Basket bySession = basketService.findBySession(session.getId());

        List<BasketFood> foods = bySession.getFoods();

        for (BasketFood b :
                foods) {
            if (b.getFood().getId() == food.getId()) {
                foods.remove(b);
                basketFoodService.delete(b);
            }
        }

        bySession.setFoods(foods);
        basketFoodService.saveAll(foods);
        basketService.save(bySession);
        session.removeAttribute(Constants.CART_ID);
        session.setAttribute(Constants.CART_ID, basketService.findBySession(session.getId()));

        return "redirect:/basket";
    }
}
