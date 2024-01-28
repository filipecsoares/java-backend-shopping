create schema if not exists users;

create table users.user (
    id bigserial primary key,
    name varchar(200) not null,
    email varchar(100) not null,
    phone varchar(100) not null,
    created_at timestamp not null
);