--liquibase formatted sql
--changeset sebastiancielma:5
create table category(
    id bigint not null auto_increment PRIMARY KEY,
    name varchar(255) not null,
    description tex,
    slug varchar(255) not null
);