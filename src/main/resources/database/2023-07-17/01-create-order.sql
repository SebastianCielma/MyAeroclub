--liquibase formatted sql
--changeset sebastiancielma:11
create table `order`(
    id bigint not null auto_increment PRIMARY KEY,
    place_Date datetime not null,
    order_Status varchar(32) not null,
    gross_Value decimal(6,2) not null,
    firstname varchar(64) not null,
        lastname varchar(64) not null,
        street varchar(80) not null,
        zipcode varchar(6) not null,
        city varchar(64) not null,
        email varchar(64) not null,
        phone varchar(16) not null
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