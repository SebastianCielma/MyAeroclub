--liquibase formatted sql
--changeset sebastiancielma:2

alter table airplane add image varchar(64)