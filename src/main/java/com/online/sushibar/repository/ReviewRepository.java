package com.online.sushibar.repository;

import com.online.sushibar.entity.Food;
import com.online.sushibar.entity.ReviewForFood;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewForFood, Long> {

    List<ReviewForFood> findAllByFood(Food food);
}
