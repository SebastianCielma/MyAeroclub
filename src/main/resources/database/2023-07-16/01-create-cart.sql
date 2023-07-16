--liquibase formatted sql
--changeset sebastiancielma:10
create table cart(
    id bigint not null auto_increment PRIMARY KEY,
    created datetime not null
);
create table cart_item(
    id bigint not null auto_increment PRIMARY KEY,
    airplane_id bigint not null,
    quantity int,
    cart_id bigint not null,
    constraint fk_cart_item_airplane_id foreign key (airplane_id) references airplane(id),
    constraint fk_cart_item_cart_id foreign key (cart_id) references cart(id)
);