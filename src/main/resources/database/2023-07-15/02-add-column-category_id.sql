--liquibase formatted sql
--changeset sebastiancielma:6
alter table airplane add category_id bigint after category;
alter table airplane drop column category;
alter table airplane add constraint fk_airplane_category_id foreign key (category_id) references category(id);