create table CUSTOMER(id int not null, name varchar(60));
create table utilisateurs(id int not null auto_increment,lastname varchar(100) not null,
firstname varchar(100) not null,email varchar(100) not null,password varchar(40) NOT NULL,role enum('normal','admin')not null, primary key (id))