--liquibase formatted sql
--changeset sebastiancielma:11
create table `order`(
    id bigint not null auto_increment PRIMARY KEY,
    placeDate datetime not null,
    orderStatus varchar(32) not null,
    grossValue decimal(6,2) not null
);
create table order_row(
    id bigint not null auto_increment PRIMARY KEY,
    order_id bigint not null,
    airplane_id bigint not null,
    quantity int not null,
    price decimal(6,2) not null,
    constraint fk_order_row_order_id foreign key (order_id) references `order`(id),
    constraint fk_order_row_airplane_id foreign key (airplane_id) references airplane(id)
);