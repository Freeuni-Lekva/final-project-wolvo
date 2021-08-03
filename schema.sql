drop table if exists users;
create table users ( 
	user_id int auto_increment primary key, 
	email varchar(100) unique, 
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	password varchar(100) not null,
	user_type int not null,
	district varchar(30) not null,
	building_address varchar(100) not null,
	privacy int not null,
	phone_number varchar(20) not null
);

DROP TABLE IF EXISTS restaurants;

CREATE TABLE restaurants(
	res_id int AUTO_INCREMENT primary key,
	name varchar(100) not null,
	manager_id int not null,
	district varchar(30) not null,
	address varchar(100) not null,
	rating float(3, 2)
);

DROP TABLE IF EXISTS dishes;

CREATE TABLE dishes(
	dish_id int AUTO_INCREMENT primary key,
	name varchar(100) not null,
	rest_id int not null,
	price float(7, 2) not null,
	category varchar(100) not null,
	rating float(3, 2)
);
	
drop table if exists friend_requests;

create table friend_requests(
	from_id int NOT NULL,
	to_id int NOT NULL, 
	PRIMARY KEY (fromid_, to_id)
);

drop table if exists messages;

create table messages(
	message_id int AUTO_INCREMENT primary key,
	from_id int NOT NULL, 
	to_id int NOT NULL, 
	date_sent datetime,
	seen BOOLEAN default false, 
	body varchar(8000) NOT NULL
);

drop table if exists friends;

create table friends(
	first_id int NOT NULL, 
	second_id int NOT NULL,
	primary key(first_id, second_id)
);

drop table if exists couriers;

create table couriers{
	user_id primary key;
	rating float(3,2),
	completed_orders int,
	is_free boolean not null
);
	
drop table if exists orders;

create table orders(
	order_id auto_increment primary key,
	user_id int not null, 
	dish_id int,
	order_date datetime not null,
	district varchar(30) not null,
	courier_id int not null,
	location varchar(100) not null
);

drop table if exists orders_history;

create table orders_history(
	user_id int primary key,
	num_orders int not null,
	last_order datetime  not null
);

drop table if exists reviews;

create table reviews(
	user_id int NOT NULL,
	dish_id int NOT NULL,
	rating int,
	courier _rating int,
	review varchar(8000)
);
