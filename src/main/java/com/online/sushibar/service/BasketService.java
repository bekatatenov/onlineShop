package com.online.sushibar.service;


import com.online.sushibar.entity.Basket;
import com.online.sushibar.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class BasketService {
    private final BasketRepository basketRepository;


    public Basket findBySession(String session) {
        return basketRepository.findBySession(session);
    }

    public void save(Basket basket) {
        basketRepository.save(basket);
    }

    public void delete(Basket basket) {
        basketRepository.delete(basket);
    }
}