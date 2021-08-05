drop database if exists test_db;

create database test_db;

use test_db;

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

insert into users (email,first_name,last_name,password,user_type,privacy,district,building_address,phone_number)
 values ('tbabu19@freeuni.edu.ge', 'Tsotne', 'Babunashvili', 'c80adfeea5a0af6d3ab04a8dba3a8769064f0d90',
		'Admin', 'Private', 'Didube', 'Dighmis Masivi V kvartali 1a','555685305');

insert into users (email,first_name,last_name,password,user_type,privacy,district,building_address,phone_number)
 values ('tarus19@freeuni.edu.ge', 'Temur', 'Arustashvili', '5ed092a75b55d250d7cf19448ff66601d254d356', 
		'Courier', 'Friends', 'Saburtalo', 'Fanjikidze str 22a/26', '595055777');
        
insert into users (email,first_name,last_name,password,user_type,privacy,district,building_address,phone_number)
 values ('achuk19@freeuni.edu.ge', 'Akaki', 'Chukhua', 'db0d9ba0b474fc1a9ce19a389f4ed37df6350b3a',
		'Admin', 'Private', 'Gldani', '3 MD Naneishvili str 20/8', '555725362');
        
insert into users (email,first_name,last_name,password,user_type,privacy,district,building_address,phone_number)
 values ('tbabu19(1)@freeuni.edu.ge', 'Tsotne(1)', 'Babunashvili(1)', 'c80adfeea5a0af6d3ab04a8dba3a8769064f0d90',
		'Customer', 'Public', 'Didube', 'Dighmis Masivi V kvartali 1a', '555685305');

insert into users (email,first_name,last_name,password,user_type,privacy,district,building_address,phone_number)
 values ('tarus19(1)@freeuni.edu.ge', 'Temur(1)', 'Arustashvili(1)', '5ed092a75b55d250d7cf19448ff66601d254d356', 
		'Manager', 'Private', 'Saburtalo', 'Fanjikidze str 22a/26',  '595055777');
        
drop table if exists friends;

create table friends(
	first_id int NOT NULL, 
	second_id int NOT NULL,
	primary key(first_id, second_id)
);

insert into friends (first_id, second_id) values(1, 2);
insert into friends (first_id, second_id) values(1, 3);
insert into friends (first_id, second_id) values(1, 4);
insert into friends (first_id, second_id) values(2, 5);
insert into friends (first_id, second_id) values(3, 4);

drop table if exists friend_requests;

create table friend_requests(
	from_id int NOT NULL,
	to_id int NOT NULL, 
    request_status varchar(30) not null,
	PRIMARY KEY (from_id, to_id)
);

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
