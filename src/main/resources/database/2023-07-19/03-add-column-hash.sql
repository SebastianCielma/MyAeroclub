--liquibase formatted sql
--changeset sebastiancielma:23
alter table users add hash varchar(120);
--changeset sebastiancielma:24
alter table users add hash_date datetime;