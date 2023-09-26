create database student_manager;

use student_manager;

create table clazz
(
    id   int primary key auto_increment,
    name varchar(50) unique
);

create table student
(
    id    int primary key auto_increment,
    name  varchar(50),
    score double
);

alter table student add clazz_id int references clazz(id);

create table user
(
    id       int primary key auto_increment,
    username varchar(100) not null unique,
    password varchar(100) not null
);

insert into clazz (name) values ('N0623C1');
insert into clazz (name) values ('N0723C1');
insert into clazz (name) values ('N0823C1');

insert into student (name, score) values ('Nguyễn Văn A', 9.6);
insert into student (name, score) values ('Nguyễn Văn B', 9.0);
insert into student (name, score) values ('Nguyễn Văn C', 5.6);
insert into user (username, password) VALUES ('QuangNN', 'QuangNN');

select * from user where username = ? and password = ?

