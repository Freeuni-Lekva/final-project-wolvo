drop database if exists wolvo_db;

create database wolvo_db;

use wolvo_db;

drop table if exists users;

create table users ( 
	user_id int auto_increment primary key, 
	email varchar(100) unique, 
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	password varchar(100) not null,
	user_type varchar(30) not null,
	privacy varchar(30) not null,
	district varchar(30) not null,
	building_address varchar(100) not null,
	phone_number varchar(20) not null
);
        
drop table if exists friends;

create table friends(
	first_id int NOT NULL, 
	second_id int NOT NULL,
	primary key(first_id, second_id),
    foreign key (first_id) references users(user_id),
	foreign key (second_id) references users(user_id)
);

drop table if exists friend_requests;

create table friend_requests(
	from_id int NOT NULL,
	to_id int NOT NULL, 
    request_status varchar(30) not null,
	PRIMARY KEY (from_id, to_id),
    foreign key (from_id) references users(user_id),
	foreign key (to_id) references users(user_id)
);

drop table if exists couriers;

create table couriers(
	courier_id int auto_increment primary key,
    email varchar(100) unique,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    password varchar(100) not null,
    district varchar(30) not null,
    phone_number varchar(30) not null,
    rating float(3,2) not null default 0,
    raters int not null default 0,
    completed_orders int not null default 0,
    curr_status varchar(30) not null default 'Free',
    add_status varchar(30) not null default 'Pending',
    curr_order int
);

drop table if exists orders;

create table orders(
	order_id int auto_increment primary key,
	user_id int not null,
	dish_id int not null,
	order_date datetime not null,
    receive_date datetime,
    order_status varchar(30),
	district varchar(30) not null,
	courier_id int not null,
	location varchar(100) not null,
    quantity int not null
);

DROP TABLE IF EXISTS dishes;

CREATE TABLE dishes(
	dish_id int AUTO_INCREMENT primary key,
	name varchar(100) not null,
	rest_id int not null,
	price float(7, 2) not null,
	category varchar(100) not null,
	raters_number int not null default 0,
	rating float(3, 2) default 0,
	is_added varchar(30) not null default 'Pending'
);

DROP TABLE IF EXISTS restaurants;

CREATE TABLE restaurants(
	rest_id int AUTO_INCREMENT primary key,
	name varchar(100) not null,
	manager_id int not null,
	district varchar(30) not null,
	address varchar(100) not null,
	is_added varchar(30) not null default 'Pending',
	raters int not null default 0,
	rating float(3, 2)
);
  
drop table if exists managers;

create table managers (
	manager_id int auto_increment primary key,
	email varchar(100) unique,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	password varchar(100) not null,
	rest_id int not null,
	phone_number varchar(20) not null
);

drop table if exists reviews;

create table reviews(
	review_id int auto_increment primary key,
	user_id int NOT NULL,
	dish_id int NOT NULL,
    courier_id int NOT NULL,
	dish_rating int,
	courier_rating int,
	review varchar(8000)
);
