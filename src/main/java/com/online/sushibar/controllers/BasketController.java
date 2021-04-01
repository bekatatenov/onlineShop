package com.online.sushibar.controllers;

import com.online.sushibar.entity.*;
import com.online.sushibar.exception.ResourceNotFoundException;
import com.online.sushibar.form.AddingFoodToBasketForm;
import com.online.sushibar.form.OrderForm;
import com.online.sushibar.form.RegisterForm;
import com.online.sushibar.form.ReviewForm;
import com.online.sushibar.repository.OrderRepository;
import com.online.sushibar.repository.ReviewRepository;
import com.online.sushibar.service.BasketFoodService;
import com.online.sushibar.service.BasketService;
import com.online.sushibar.service.FoodService;
import com.online.sushibar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.scanner.Constant;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
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
    private final OrderRepository orderRepository;
    private final ReviewRepository reviewRepository;

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
        int a = 0;
        if (form.getQty() == null) {
            a = 1;
        } else {
            a = form.getQty();
        }

        if (basketService.findBySession(session.getId()) == null) {
            List<BasketFood> list = new ArrayList<>();
            Basket basket = new Basket(session.getId(), user);
            BasketFood basketFood = new BasketFood(a, basket, food);
            list.add(basketFood);
            basketService.save(basket);
            basketFoodService.save(basketFood);
            basketService.save(basket);

        } else {
            Basket basket = basketService.findBySession(session.getId());
            BasketFood basketFood = new BasketFood(a, basket, food);
            basketFoodService.save(basketFood);
        }
        session.removeAttribute(Constants.CART_ID);
        session.setAttribute(Constants.CART_ID, basketService.findBySession(session.getId()));

        return "redirect:/";
    }

    @GetMapping()
    public String showBasket(Principal principal, HttpSession session, Model model) {
        var user = userService.getByEmail(principal.getName());

        if (basketService.findBySession(session.getId()) == null) {
            throw new ResourceNotFoundException("Basket is Empty");
        }
        Basket bySession = basketService.findBySession(session.getId());


        List<BasketFood> foods = bySession.getFoods();

        double total = 0;
        for (BasketFood b :
                bySession.getFoods()) {
            total = total + b.getFood().getPrice() * b.getQty();
        }

        basketService.save(bySession);
        model.addAttribute("foods", foods);
        model.addAttribute("user, user");
        model.addAttribute("form", new OrderForm(total));
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

        return "redirect:/";
    }
    @PostMapping("/order")
    public String makeOrder(@Valid OrderForm orderForm, BindingResult bindingResult, HttpSession session) throws BindException {

        if (bindingResult.hasFieldErrors()) {
            throw new BindException(bindingResult);
        }
        Basket basket;
        try {
            basket = basketService.findBySession(session.getId());
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("There is nit such basket");
        }

        if (basket == null) {
            throw new ResourceNotFoundException("There is not such basket");
        }

        Order order = Order.builder()
                .address(orderForm.getAddress())
                .name(orderForm.getName())
                .tel(orderForm.getTel())
                .basket(basket)
                .total(orderForm.getTotal())
                .build();
        orderRepository.save(order);
        return "redirect:/basket/review";
    }


    @GetMapping("/review")
    public String getRewiewPage(Principal principal, Model model) {
        var user = userService.getByEmail(principal.getName());
        if (orderRepository.findAllByBasket_User(user).isEmpty()) {
            throw new ResourceNotFoundException("You cant write any reviews");
        }
        List<Order> allByBasket_user = orderRepository.findAllByBasket_User(user);
        Set<Food> foods = new HashSet<>();
        for (Order o :
                allByBasket_user) {
            List<BasketFood> foods1 = o.getBasket().getFoods();
            for (BasketFood f :
                    foods1) {
                foods.add(f.getFood());
            }
        }
        model.addAttribute("foods", foods);
//        model.addAttribute("form", new ReviewForm());
        return "review";
    }

    @PostMapping("/review")
    public String getReview(Principal principal, @RequestParam Long foodId, @RequestParam String text) {
        var user = userService.getByEmail(principal.getName());
        if (!foodService.existById(foodId)) {
            throw new ResourceNotFoundException("There is not such food");
        }
        if (text.isEmpty() || text.isBlank()) {
            throw new ResourceNotFoundException("Review input is empty");
        }
        Food byId = foodService.getById(foodId);

        ReviewForFood r = ReviewForFood.builder()
                .name(text)
                .food(byId)
                .date(LocalDate.now())
                .user(user)
                .build();

        reviewRepository.save(r);
        String m = String.format("redirect:/food/%s", byId.getId());
        return m;
    }
}
