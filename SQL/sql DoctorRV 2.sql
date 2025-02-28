create database doctorRv;
use doctorRv;
create table user(
	id int primary key auto_increment,
	username varchar(50) not null,
	email varchar(20) not null unique,
	telephone varchar(20) not null,
	mot_de_passe varchar(20) not null,
	role enum('patient','medecin') not null
);
create table medecin(
	user_id int primary key ,
	specialite varchar(50),
	foreign key (user_id) references user(id)
);
show tables;
drop table medecin;
desc user;
desc medecin;
select * from user;
select * from medecin;