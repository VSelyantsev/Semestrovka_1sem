drop table if exists account;
drop table if exists zodiac_signs;
drop table if exists planets;
drop table if exists articles;

create table account (
    id serial primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    login_name varchar(255) unique not null,
    password_account varchar(255) not null,
    email varchar(255) not null,
    gender varchar(255) not null
);

create table planets (
    id serial primary key,
    planet_name varchar(20) not null,
    planet_detection varchar(20) not null,
    planet_distance varchar(20) not null
);

create table zodiac_signs (
    id serial primary key,
    zodiac_name varchar(20) not null,
    zodiac_type varchar(50) not null,
    zodiac_element varchar(20) not null
);

create table articles (
    id serial primary key,
    article_name varchar(20) not null,
    article_date date not null,
    name_author varchar(255) references account(login_name)
);