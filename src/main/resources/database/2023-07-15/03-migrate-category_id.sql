--liquibase formatted sql
--changeset sebastiancielma:7
insert into category (id, name, description, slug) values(1, 'Inne', '', 'inne');
update airplane set category_id=1;
alter table airplane MODIFY category_id bigint not null;