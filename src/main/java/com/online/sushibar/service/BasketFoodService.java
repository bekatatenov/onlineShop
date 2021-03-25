package com.online.sushibar.service;

import com.online.sushibar.entity.BasketFood;
import com.online.sushibar.repository.BasketFoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BasketFoodService {
    private final BasketFoodRepository basketFoodRepository;

    public void save(BasketFood basketFood) {
        basketFoodRepository.save(basketFood);
    }

    public void delete(BasketFood basketFood) {
        basketFoodRepository.delete(basketFood);
    }
    public void saveAll(List<BasketFood> foodList){
        basketFoodRepository.saveAll(foodList);
    }
}
