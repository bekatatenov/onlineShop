package com.online.sushibar.service;

import com.online.sushibar.entity.Food;
import com.online.sushibar.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class FoodService {
    private final FoodRepository foodRepository;

    public Page<Food> getByName(Pageable pageable, String text) {
        return foodRepository.findAllByNameContaining(text, pageable);
    }

}
