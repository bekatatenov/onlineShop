package com.online.sushibar.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddingFoodToBasketForm {

    @NotNull
    private Long foodId;
}