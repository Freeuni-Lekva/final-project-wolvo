drop table if exists users;
create table users ( 
	user_id int auto_increment primary key, 
	email varchar(100) unique, 
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	password varchar(100) not null,
	user_type varchar(30) not null,
	district varchar(30) not null,
	building_address varchar(100) not null,
	privacy varchar(30) not null,
	phone_number varchar(20) not null
);

drop table if exists managers;

create table managers (
	user_id int auto_increment primary key,
	email varchar(100) unique,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	password varchar(100) not null,
	res_id int foreign key not null,
	phone_number varchar(20) not null
);

DROP TABLE IF EXISTS restaurants;

CREATE TABLE restaurants(
	res_id int AUTO_INCREMENT primary key,
	name varchar(100) not null,
	manager_id int foreign key not null,
	district varchar(30) not null,
	address varchar(100) not null,
	raters_number int default 0,
	is_added boolean default false,
	rating float(3, 2) default 0.0
);

DROP TABLE IF EXISTS dishes;

CREATE TABLE dishes(
	dish_id int AUTO_INCREMENT primary key,
	name varchar(100) not null,
	rest_id int foreign key not null,
	price float(7, 2) not null,
	category varchar(100) not null,
	raters_number int default 0,
	is_added boolean default false,
	rating float(3, 2) default 0.0
);
	
drop table if exists friend_requests;

create table friend_requests(
	from_id int foreign key NOT NULL,
	to_id int foreign key NOT NULL,
	request_status varchar(30) not null,
	PRIMARY KEY (from_id, to_id)
);

drop table if exists messages;

create table messages(
	message_id int AUTO_INCREMENT primary key,
	from_id int foreign key NOT NULL,
	to_id int foreign key NOT NULL,
	date_sent timestamp,
	seen BOOLEAN default false, 
	body varchar(8000) NOT NULL
);

drop table if exists friends;

create table friends(
	first_id int foreign key NOT NULL,
	second_id int foreign key NOT NULL,
	primary key(first_id, second_id)
);

drop table if exists couriers;

create table couriers(
	user_id int auto_increment primary key,
    email varchar(100) unique,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    password varchar(100) not null,
    phone_number varchar(30) not null,
	rating float(3,2) default 0.0,
	completed_orders int default 0,
	raters_number int default 0,
	is_added boolean default false,
	is_free boolean default true
);
	
drop table if exists orders;

create table orders(
	order_id int auto_increment primary key,
	user_id int foreign key not null,
	dish_id int foreign key not null,
	order_date timestamp not null,
	district varchar(30) not null,
	courier_id int not null,
	location varchar(100) not null
);

drop table if exists reviews;

create table reviews(
	user_id int foreign key NOT NULL,
	dish_id int foreign key NOT NULL,
	courier_id int foreign key not null,
	rating int,
	courier_rating int,
	review varchar(8000)
);
