package com.online.sushibar.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "food_types")
public class FoodType {
    @Id
    private Long id;

    @NotBlank
    @Size(min = 3, max = 128)
    private String name;

    @OneToMany(mappedBy = "type")
    @OrderBy("name ASC")
    List<Food> foods;
}