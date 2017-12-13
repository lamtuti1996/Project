Create database SpringMVC

create table Users(
Username nvarchar(50) not null primary key,
Password nvarchar(50) not null, 
Fullname nvarchar(50) not null

)

create table Departs(
Id nvarchar(10) not null primary key,
Name nvarchar(50) not null
)


create table Staffs(
Id nvarchar(10) not null primary key,
Name nvarchar(50) not null ,
Gender bit not null,
Birthday date not null,
Photo nvarchar(50) not null,
Email nvarchar(50) not null,
Phone nvarchar(25) not null,
Salary float not null,
Notes nvarchar(500) ,
DepartID nvarchar(10) foreign key references Departs(Id)
)

create table Records(
Id bigint not null primary key identity(1,1),
Type bit not null,
Reason nvarchar(200) not null,
Date date not null,
StaffId nvarchar(10)  foreign key references Staffs(Id)
)