--liquibase formatted sql
--changeset sebastiancielma:12
create table shipment(
    id bigint not null auto_increment PRIMARY KEY,
    name varchar(64) not null,
    price decimal(6,2) not null,
    type varchar(32) not null,
    default_shipment boolean default false
);
insert into shipment(name, price, type, default_shipment) values ('Self pickup', 0.0, 'SELFPICKUP', false);
