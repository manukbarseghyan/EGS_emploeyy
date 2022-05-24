create table employee
(
    id         int auto_increment
        primary key,
    first_name varchar(20) null,
    last_name  varchar(20) null,
    salary     int         null,
    username   varchar(20) null,
    password   varchar(20) null
);
