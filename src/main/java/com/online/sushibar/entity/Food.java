package com.online.sushibar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "foods")
public class Food {
    @Id
    private Long id;

    @NotBlank
    @Size(min = 1, max = 128)
    private String name;

    @NotBlank
    @Size(min = 1, max = 128)
    private String image;

    @Positive
    private Double gram;
    @Positive
    private Double quantity;
    @Positive
    private Double price;
    @NotBlank
    @Size(min = 10, max = 240)
    private String description;

    @ManyToOne
    @JoinColumn(name = "foodType_id")
    private FoodType type;
}