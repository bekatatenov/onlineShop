create table tokens
(
    id       bigint auto_increment,
    token    varchar(255) null,
    users_id bigint       null,
    constraint tokens_id_uindex
        unique (id),
    constraint FKl50lok37qf2734u04knlj57ct
        foreign key (users_id) references users (id)
);

create table orders
(
    id        bigint auto_increment
        primary key,
    address   varchar(255) null,
    name      varchar(255) null,
    tel       varchar(255) null,
    basket_id bigint       null,
    total     double       null,
    constraint FKkeq4ha3u9m7f5nv9wqyk4lnap
        foreign key (basket_id) references baskets (id)
);