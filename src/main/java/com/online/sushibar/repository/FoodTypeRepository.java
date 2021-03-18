package com.online.sushibar.repository;

import com.online.sushibar.entity.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {

    List<FoodType> findAllByNameContaining(@NotBlank String name);
}