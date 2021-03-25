package com.online.sushibar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "basket_foods")
public class BasketFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    @Builder.Default
    private Integer qty = 1;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    public BasketFood(@Positive Integer qty, Basket basket, Food food) {
        this.qty = qty;
        this.basket = basket;
        this.food = food;
    }
}
