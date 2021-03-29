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