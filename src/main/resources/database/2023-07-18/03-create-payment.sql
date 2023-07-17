--liquibase formatted sql
--changeset sebastiancielma:14
create table payment(
    id bigint not null auto_increment PRIMARY KEY,
    name varchar(64) not null,
    type varchar(32) not null,
    default_payment boolean default false,
    note text
);
insert into payment(id, name, type, default_payment, note)
values (1, 'Bank transfer', 'BANK_TRANSFER', true, 'Please make a transfer to the account number 66 1240 2816 1111 0010 3328 1245');
