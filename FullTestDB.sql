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
    phone_number varchar(30) not null,
	rating float(3,2) not null,
    raters int not null,
	completed_orders int not null,
	curr_status varchar(30) not null,
    add_status varchar(30) not null,
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
	rating float(3, 2)
);

DROP TABLE IF EXISTS restaurants;

CREATE TABLE restaurants(
	rest_id int AUTO_INCREMENT primary key,
	name varchar(100) not null,
	manager_id int not null,
	district varchar(30) not null,
	address varchar(100) not null,
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
	user_id int NOT NULL,
	dish_id int NOT NULL,
    courier_id int NOT NULL,
	dish_rating int,
	courier_rating int,
	review varchar(8000)
);

------------------------------------------------------------------------------------------------

insert into users values (1, 'tbabu19@freeuni.edu.ge', 'Tsotne', 'Babunashvili', 'c80adfeea5a0af6d3ab04a8dba3a8769064f0d90',
		"Admin", "Private", 'Didube', 'Dighmis Masivi V kvartali 1a','555685305');

insert into users values (2, 'tarus19@freeuni.edu.ge', 'Temur', 'Arustashvili', '5ed092a75b55d250d7cf19448ff66601d254d356', 
		"Customer", "Friends", 'Saburtalo', 'Fanjikidze str 22a/26', '595055777');
        
insert into users values (3, 'achuk19@freeuni.edu.ge', 'Akaki', 'Chukhua', 'db0d9ba0b474fc1a9ce19a389f4ed37df6350b3a',
		"Admin", "Private", 'Gldani', '3 MD Naneishvili str 20/8', '555725362');
        
insert into users values (4,'tbabu19(1)@freeuni.edu.ge', 'Tsotne(1)', 'Babunashvili(1)', 'c80adfeea5a0af6d3ab04a8dba3a8769064f0d90',
		"Customer", "Public", 'Didube', 'Dighmis Masivi V kvartali 1a','555685305');

insert into users values (5, 'tarus19(1)@freeuni.edu.ge', 'Temur(1)', 'Arustashvili(1)', '5ed092a75b55d250d7cf19448ff66601d254d356', 
		"Admin", "Private", 'Saburtalo', 'Fanjikidze str 22a/26', '595055777');

-------------------------------------------------------------------------------------------------

insert into friends (first_id, second_id) values(1, 2);
insert into friends (first_id, second_id) values(1, 3);
insert into friends (first_id, second_id) values(1, 4);
insert into friends (first_id, second_id) values(2, 5);
insert into friends (first_id, second_id) values(3, 4);

-------------------------------------------------------------------------------------------------

insert into friend_requests(from_id, to_id, request_status)
values (1, 2, "Accepted");
insert into friend_requests(from_id, to_id, request_status)
values (1, 3, "Accepted");
insert into friend_requests(from_id, to_id, request_status)
values (4, 1, "Accepted");
insert into friend_requests(from_id, to_id, request_status)
values (2, 5, "Accepted");
insert into friend_requests(from_id, to_id, request_status)
values (3, 4, "Accepted");
insert into friend_requests(from_id, to_id, request_status)
values (1, 5, "Rejected");
insert into friend_requests(from_id, to_id, request_status)
values (2, 3, "Rejected");
insert into friend_requests(from_id, to_id, request_status)
values (4, 5, "NotResponded");
insert into friend_requests(from_id, to_id, request_status)
values (2, 4, "NotResponded");

-----------------------------------------------------------------------------------------

insert into couriers values (1, 'tbabu19@freeuni.edu.ge', 'Tsotne', 'Babunashvili', 'c80adfeea5a0af6d3ab04a8dba3a8769064f0d90',
		'Didube','555-68-53-05', 0.0, 0, 100, 'Free', 'Accepted', 103);

insert into couriers values (2, 'tarus19@freeuni.edu.ge', 'Temur', 'Arustashvili', '5ed092a75b55d250d7cf19448ff66601d254d356', 
		'Gldani','595-05-57-77', 5.0, 10, 10, 'Occupied', 'NotResponded', 104);
        
insert into couriers values (3, 'achuk19@freeuni.edu.ge', 'Akaki', 'Chukhua', 'db0d9ba0b474fc1a9ce19a389f4ed37df6350b3a',
		'Saburtalo','555-72-53-62', 5.0, 10, 9, 'Free', 'Rejected', 105);
        
insert into couriers values (4, 'tbabu19(1)@freeuni.edu.ge', 'Tsotne(1)', 'Babunashvili(1)', 'c80adfeea5a0af6d3ab04a8dba3a8769064f0d90',
		'Vake','555-68-53-05', 3.4, 374, 1078, 'Free', 'Accepted', 106);

insert into couriers values (5, 'tarus19(1)@freeuni.edu.ge', 'Temur(1)', 'Arustashvili(1)', '5ed092a75b55d250d7cf19448ff66601d254d356', 
		'Didube','595-05-57-77', 2.4, 103, 1999, 'Occupied', 'Accepted', 107);
        
----------------------------------------------------------------------------------------------	

insert into orders 
	values (103, 1, 210, '2008-11-11 13:23:44', '2008-11-11 14:23:44', 'Delivered', 'Didube', 1, 'Dighmis Masivi V kvartali 1a', 1);
insert into orders
	values (104, 2, 211, '2009-11-11 13:23:44', '2009-11-11 14:23:44', 'Delivered', 'Saburtalo', 2, 'Fanjikidze str 22a/26', 100);
insert into orders
	values (105, 3, 212, '2010-11-11 13:23:44', null, 'OnWay', 'Gldani', 3, '3 MD Naneishvili str 20/8', 3);
insert into orders
	values (106, 4, 213, '2011-11-11 13:23:44', null, 'NotReceive', 'Didube', 4, 'Dighmis Masivi V kvartali 1a', 1);
insert into orders
	values (107, 5, 214, '2012-11-11 13:23:44', '2013-11-11 13:23:44', 'Delivered', 'Saburtalo', 4, 'Fanjikidze str 22a/26', 1);

-------------------------------------------------------------------------------------

insert into dishes (dish_id,name,rest_id,price,category, raters_number, rating)
	values (210, "Alpen Gold", 1001, 2.6, "Candy", 1, 3.4);
insert into dishes (dish_id,name,rest_id,price,category, raters_number, rating)
	values (211, "Khinkali", 1002, 1.2, "Meat", 1, 4.5);
insert into dishes (dish_id,name,rest_id,price,category, raters_number, rating)
	values (212, "Khachapuri", 1003, 15.0, "Georgian", 1, 5.0);
insert into dishes (dish_id,name,rest_id,price,category, raters_number, rating)
	values (213, "Cookie", 1004, 3.4, "Candy", 1, 5.0);
insert into dishes (dish_id,name,rest_id,price,category, raters_number, rating)
	values (214, "Peach", 1005, 1.5, "Fruit", 1, 4.6);

---------------------------------------------------------------------------------------------------

insert into managers (manager_id, email, first_name, last_name, password, rest_id, phone_number)
	values (501, 'tbabu19@freeuni.edu.ge', 'Tsotne', 'Babunashvili', 'c80adfeea5a0af6d3ab04a8dba3a8769064f0d90',
		1001, '555-68-53-05');

insert into managers (manager_id, email, first_name, last_name, password, rest_id, phone_number)
	values (502, 'tarus19@freeuni.edu.ge', 'Temur', 'Arustashvili', '5ed092a75b55d250d7cf19448ff66601d254d356', 
		1002, '595-05-57-77');
        
insert into managers (manager_id, email, first_name, last_name, password, rest_id, phone_number)
	values (503, 'achuk19@freeuni.edu.ge', 'Akaki', 'Chukhua', 'db0d9ba0b474fc1a9ce19a389f4ed37df6350b3a',
		1003, '555-72-53-62');
        
insert into managers (manager_id, email, first_name, last_name, password, rest_id, phone_number)
	values (504, 'tbabu19(1)@freeuni.edu.ge', 'Tsotne(1)', 'Babunashvili(1)', 'c80adfeea5a0af6d3ab04a8dba3a8769064f0d90',
		1004, '555-68-53-05');

insert into managers (manager_id, email, first_name, last_name, password, rest_id, phone_number)
	values (505, 'tarus19(1)@freeuni.edu.ge', 'Temur(1)', 'Arustashvili(1)', '5ed092a75b55d250d7cf19448ff66601d254d356', 
		1005, '595-05-57-77');
        
----------------------------------------------------------------------------------------------

insert into restaurants (rest_id, name, manager_id, district, address, raters, rating)
	values (1001, "HB", 501, "Saburtalo", "Vazha-pshavela street", 1, 4.3);
insert into restaurants (rest_id, name, manager_id, district, address, raters, rating)
	values (1002, "Machakhela", 502, "Didube", "Some Adress2", 1, 3.2);
insert into restaurants (rest_id, name, manager_id, district, address, raters, rating)
	values (1003, "Weihenstephan", 503, "Saburtalo", "Vazha-pshavela Str", 1, 4.9);
insert into restaurants (rest_id, name, manager_id, district, address, raters, rating)
	values (1004, "Bernard", 504, "Gldani", "Gldanis misamarti rame", 1, 3.8);
insert into restaurants (rest_id, name, manager_id, district, address, raters, rating)
	values (1005, "Nikora", 505, "Digomi", "FU-s win", 1, 4.2);
  
---------------------------------------------------------------------------------------------------

insert into reviews (user_id,dish_id,courier_id,dish_rating,courier_rating,review)
	values (1, 210, 1, 4, 4, "KARGIA");
insert into reviews (user_id,dish_id,courier_id,dish_rating,courier_rating,review)
	values (2, 211, 2, 3, 2, "Fuf");
insert into reviews (user_id,dish_id,courier_id,dish_rating,courier_rating,review)
	values (3, 212, 3, 1, 1, "normie");
insert into reviews (user_id,dish_id,courier_id,dish_rating,courier_rating,review)
	values (4, 213, 4, null, null, null);
insert into reviews (user_id,dish_id,courier_id,dish_rating,courier_rating,review)
	values (5, 214, 5, 5, 5, "MAGARIA");