package com.online.sushibar.repository;

import com.online.sushibar.entity.ReviewForFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewForFood, Long> {
}
