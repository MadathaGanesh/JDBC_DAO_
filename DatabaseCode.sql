create database jdbc;
use jdbc;
create table Students_Data_Display (UserID int,StudName varchar(100),Address varchar(100));

desc Students_Data_Display;
insert into Students_Data_Display(UserID,StudName,Address) values(101,"Ganesh","Warangal");

insert into Students_Data_Display values(102,"Rahul","Karimnagar"),(103,"Hari","Ramnagar"),(104,"Karthik","Noida");
insert into Students_Data_Display values(105,"Krishna","Balharshah");
select * from Students_Data_Display;

alter table Students_Data_Display add primary key(UserID);
desc NewJDBCTable;
select * from NewJDBCTable;

--  Creating  a new Table "StudentManagementSystem"
create table StudentManagementSystem(ID int primary key , name varchar(100) not null,Address varchar(100));
desc StudentManagementSystem;
select * from StudentManagementSystem;

