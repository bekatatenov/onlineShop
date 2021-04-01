package com.online.sushibar.repository;

import com.online.sushibar.entity.BasketFood;
import com.online.sushibar.entity.Order;
import com.online.sushibar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByBasket_User(User basket_user);
}