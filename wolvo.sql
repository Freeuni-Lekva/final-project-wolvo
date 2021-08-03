use wolvo_db;

create table users (
       user_id int,
       email char(100),
       first_name char(100) not null,
       last_name char(100) not null, 
       password char(100) not null,
       user_type int not null,
       privacy int not null,
       city char(100) not null,
       district char(100) not null,
       building_address char(100) not null,
       phone_number bigint not null, 
       constraint id primary key (user_id),
       constraint user_email unique(email)
);

insert into users values (1, 'tbabu19@freeuni.edu.ge', 'Tsotne', 'Babunashvili', 'c80adfeea5a0af6d3ab04a8dba3a8769064f0d90',
		101, 0, 'Tbilisi', 'Didube', 'Dighmis Masivi V kvartali 1a',555685305);

insert into users values (2, 'tarus19@freeuni.edu.ge', 'Temur', 'Arustashvili', '5ed092a75b55d250d7cf19448ff66601d254d356', 
		101, 0, 'Tbilisi', 'Saburtalo', 'Fanjikidze str 22a/26', 595055777);
        
insert into users values (3, 'achuk19@freeuni.edu.ge', 'Akaki', 'Chukhua', 'db0d9ba0b474fc1a9ce19a389f4ed37df6350b3a',
		101, 0, 'Tbilisi', 'Gldani', '3 MD Naneishvili str 20/8', 555725362);
        
