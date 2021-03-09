package com.online.sushibar.service;


import com.online.sushibar.repository.FoodTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class FoodTypeService {

    private final FoodTypeRepository foodTypeRepository;
    

}
