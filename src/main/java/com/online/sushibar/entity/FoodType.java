package com.online.sushibar.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "food_types")
public class FoodType {
    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "type")
    @OrderBy("name ASC")
    List<Food> foods;
}