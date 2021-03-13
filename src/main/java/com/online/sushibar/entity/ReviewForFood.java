package com.online.sushibar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class ReviewForFood {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Food food;

    private LocalDate date;

    @NotEmpty
    @Size(min = 3)
    private String name;
}