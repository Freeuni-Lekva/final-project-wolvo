use wolvo_db;

create table users ( 
	user_id int auto_increment primary key, 
	email varchar(100) unique, 
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	password varchar(100) not null,
	user_type varchar(100) not null,
	district varchar(30) not null,
	building_address varchar(100) not null,
	privacy int not null,
	phone_number varchar(20) not null
);

insert into users (email,first_name,last_name,password,user_type,privacy,district,building_address,phone_number)
	 values ('tbabu19@freeuni.edu.ge', 'Tsotne', 'Babunashvili', 'c80adfeea5a0af6d3ab04a8dba3a8769064f0d90',
		'Admin', 0, 'Didube', 'Dighmis Masivi V kvartali 1a','555685305');

insert into users (email,first_name,last_name,password,user_type,privacy,district,building_address,phone_number)
	 values ('tarus19@freeuni.edu.ge', 'Temur', 'Arustashvili', '5ed092a75b55d250d7cf19448ff66601d254d356', 
		'Admin',0, 'Saburtalo', 'Fanjikidze str 22a/26', '595055777');
        
insert into users (email,first_name,last_name,password,user_type,privacy,district,building_address,phone_number)
	 values ('achuk19@freeuni.edu.ge', 'Akaki', 'Chukhua', 'db0d9ba0b474fc1a9ce19a389f4ed37df6350b3a',
		'Admin', 0, 'Gldani', '3 MD Naneishvili str 20/8', '555725362');
        
