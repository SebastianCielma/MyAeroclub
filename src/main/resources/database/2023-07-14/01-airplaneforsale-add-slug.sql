--liquibase formatted sql
--changeset sebastiancielma:3
alter table airplane add slug varchar(255) after image;
alter table airplane add constraint ui_airplane_slug unique key(slug);