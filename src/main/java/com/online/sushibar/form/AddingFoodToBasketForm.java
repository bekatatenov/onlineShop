package com.online.sushibar.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class AddingFoodToBasketForm {

    @NotNull
    private Long foodId;

    @Positive
    private Integer qty;
}