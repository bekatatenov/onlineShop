create table food_types
(
    id   bigint  auto_increment  not null
        primary key,
    name varchar(255) null
);

create table foods
(
    id           bigint  auto_increment     not null
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