package com.online.sushibar.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ReviewForm {

    @NotBlank
    private Long foodId;

    @NotBlank
    private String text;

}
