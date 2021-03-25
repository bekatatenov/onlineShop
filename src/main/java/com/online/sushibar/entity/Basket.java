package com.online.sushibar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "baskets")
public class Basket {
    @Id
    private Long id;

    private String session;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "basket")
    private List<BasketFood> foods;

    public Basket(String session, User user) {
        this.session = session;
        this.user = user;
    }
}
