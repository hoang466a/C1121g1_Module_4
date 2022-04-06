
drop database jpa_blog_category_data;
create database jpa_blog_category_data;
use jpa_blog_category_data;


create table category(
id_category int auto_increment primary key,
name_category varchar(255)
);

create table blog(
id_blog int auto_increment primary key,
id_category int, 
name_blog varchar(50),
note_blog varchar(255),
date_blog date,
foreign key(id_category) references category(id_category)
);

insert into category values(1,'car'),(2,'cat'),(3,'dog'),(4,'bird');