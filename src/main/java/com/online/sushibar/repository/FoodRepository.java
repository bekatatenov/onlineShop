package com.online.sushibar.repository;

import com.online.sushibar.entity.Food;
import com.online.sushibar.entity.FoodType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public interface FoodRepository extends JpaRepository<Food, Long> {

    Page<Food> findAllByNameContaining(@NotBlank String name, Pageable pageable);

    Page<Food> findAllByType(FoodType type, Pageable pageable);

    Page<Food> findAllByDescriptionContaining(@NotBlank String description, Pageable pageable);
}
