package com.online.sushibar.repository;

import com.online.sushibar.entity.Basket;
import com.online.sushibar.entity.BasketFood;
import com.online.sushibar.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketFoodRepository extends JpaRepository<BasketFood, Long> {
    BasketFood findBasketFoodByBasketAndFood(Basket basket, Food food);

    List<BasketFood> findBasketFoodByBasket(Basket basket);
}
