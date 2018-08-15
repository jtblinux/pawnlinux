create database exdb;
use exdb;
/*用户表*/
drop table if exists user;
create table user (
    id int auto_increment primary key, 
    username varchar(50)  not null unique,
    password varchar(50) not null,
    gender int(1),
    email  varchar(50),
    phone  varchar(50) 
) default charset=utf8;

/*教练表*/
drop table if exists coach;
create table coach(
    id int auto_increment primary key,
    username varchar(50) not null unique,
    password varchar(50) not null,
    name varchar(50)
)default charset=utf8;

/*超管号*/
drop table if exists super;
create table super(
    id int auto_increment primary key,
    username varchar(50)  not null unique,
    password varchar(50)  not null
)default charset=utf8;

/*订单*/
drop table if exists orders;
create table orders(
    id int auto_increment primary key,
    name varchar(50) not null,
    money int not null,
    describle varchar(100)  
)default charset=utf8;
/*订单和用户维系表*/
drop table if exists u_o;
create table u_o(
   id int auto_increment primary key,
   uid int,
   oid int,
   ordertime varchar(50)  
)default charset=utf8;

/*订单本身为课程，和教练是相关的。即有一个排班次的表*/
drop table if exists major;
create table major(
   id int auto_increment primary key,
   describle varchar(100),
   oid int,
   cid int,
   starttime varchar(50),
   endtime varchar(50),
   uid int 
)default charset=utf8;




