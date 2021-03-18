package com.online.sushibar.service;

import com.online.sushibar.entity.Food;
import com.online.sushibar.entity.FoodType;
import com.online.sushibar.repository.FoodRepository;
import com.online.sushibar.repository.FoodTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class FoodService {
    private final FoodRepository foodRepository;
    private final FoodTypeRepository foodTypeRepository;

    public Page<Food> getByName(Pageable pageable, String text) {
        return foodRepository.findAllByNameContaining(text, pageable);
    }

    public Page<Food> getByType(Pageable pageable, String text) {
        List<Food> foods = new ArrayList<>();
        List<FoodType> foodTypes = foodTypeRepository.findAllByNameContaining(text);

        for (FoodType t :
                foodTypes) {
            List<Food> allByType = foodRepository.findAllByType(t);
            foods.addAll(allByType);
        }

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), foods.size());
        Page<Food> foodPage = new PageImpl<>(foods.subList(start, end), pageable, foods.size());
        return foodPage;
    }


    public Page<Food> getByDesc(Pageable pageable, String text) {
        return foodRepository.findAllByDescriptionContaining(text, pageable);
    }
}
