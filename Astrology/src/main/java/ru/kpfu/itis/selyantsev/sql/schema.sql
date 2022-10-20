drop table if exists account;

create table account (
    id serial primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    login_name varchar(255) not null,
    password_account varchar(255) not null,
    email varchar(255) not null,
    gender varchar(255) not null
)

select * from account where first_name = 'Vladislav';