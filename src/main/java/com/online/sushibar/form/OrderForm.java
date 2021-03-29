package com.online.sushibar.form;

import com.online.sushibar.entity.Basket;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;

@Getter
@Setter
public class OrderForm {

    @NotBlank
    private String name = "";

    @NotBlank
    private String address = "";

    @NotBlank(message = "error")
    private String tel = "";


    @Positive
    private double total;

    public OrderForm(double total) {
        this.total = total;
    }
}
