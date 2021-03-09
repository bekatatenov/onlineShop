package com.online.sushibar.service;

import com.online.sushibar.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class FoodService {
    private final FoodRepository foodRepository;
}
