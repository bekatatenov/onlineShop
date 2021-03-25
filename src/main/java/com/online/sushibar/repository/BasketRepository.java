package com.online.sushibar.repository;

import com.online.sushibar.entity.Basket;
import com.online.sushibar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    Basket findBySession(String session);

    Basket findByUserAndSession(User user, String session);
}
