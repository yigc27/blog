drop database if exists blog;
create database blog;

use blog;

drop table if exists author_infomation;

create table author_infomation(
id int not null primary key auto_increment,
login_id varchar(30),
login_pass varchar(30),
name varchar(30),
admin boolean default false
);

drop table if exists entries;

create table entries(
id int not null primary key auto_increment,
title varchar(50) not null,
text TEXT(21844) not null,
author_id int not null,
category int default 1,
publish boolean default true,
post_date datetime,
update_date datetime
);

drop table if exists categorys;

create table categorys(
id int not null primary key auto_increment,
name varchar(255) unique not null
);

insert into author_infomation(login_id,login_pass,name,admin) VALUES("admin","admin","管理者",true);
insert into author_infomation(login_id,login_pass,name,admin) VALUES("general","general","一般ユーザ",false);
insert into categorys(name) VALUES("未分類");
insert into categorys(name) VALUES("雑記");
insert into entries(title,text,author_id,post_date,update_date)VALUES("管理者ログイン","ログインID:admin\nパスワード:admin",1,'20181003','20181003');
insert into entries(title,text,author_id,post_date,update_date)VALUES("一般ユーザログイン","ログインID:general\nパスワード:general",2,'20181002','20181002');