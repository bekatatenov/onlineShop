create table food_types
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table foods
(
    id           bigint auto_increment
        primary key,
    description  varchar(255) null,
    gram         double       null,
    image        varchar(255) null,
    name         varchar(255) null,
    price        double       null,
    quantity     double       null,
    food_type_id bigint       null,
    constraint FKteg3f0l6cndtbn3nsbr1tmxcl
        foreign key (food_type_id) references food_types (id)
);

create table users
(
    id        bigint       not null
        primary key,
    email     varchar(255) null,
    password  varchar(255) null,
    user_name varchar(255) null
);

create table reviews
(
    id      bigint       not null
        primary key,
    date    date         null,
    name    varchar(255) null,
    food_id bigint       null,
    user_id bigint       null,
    constraint FK81nkg9op14w8c6hw7f25f029i
        foreign key (food_id) references foods (id),
    constraint FKcgy7qjc1r99dp117y9en6lxye
        foreign key (user_id) references users (id)
);

