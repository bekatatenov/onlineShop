create table baskets
(
    id      bigint       not null auto_increment
        primary key,
    session varchar(255) null,
    user_id bigint       null,
    constraint FK87s17cinc4wkx0taas5nh0s8h
        foreign key (user_id) references users (id)
);
create table basket_foods
(
    id        bigint not null  auto_increment
        primary key,
    qty       int    null,
    basket_id bigint null,
    food_id   bigint null,
    constraint FKlomoboid5pugq7ajp2kvqe5id
        foreign key (basket_id) references baskets (id),
    constraint FKs86tjrwd3ex57i294fpntxuc6
        foreign key (food_id) references foods (id)
);