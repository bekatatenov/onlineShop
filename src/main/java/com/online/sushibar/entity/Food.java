package com.online.sushibar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "foods")
public class Food {
    @Id
    private Long id;

    private String name;
    private String image;

    private Double gram;
    private Double quantity;
    private Double price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "foodType_id")
    private FoodType type;
}