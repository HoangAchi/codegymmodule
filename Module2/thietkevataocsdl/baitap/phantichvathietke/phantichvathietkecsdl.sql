create database cuahangbanoto;

use cuahangbanoto;

create table Customers(
customerNumber int(11) not null primary key,
customerName varchar(50) not null,
contactLastName varchar(50) not null,
contactFirstName varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50), 
city varchar(50) not null,
state varchar(50) not null,
postalCode varchar(15) not null,
country varchar(50) not null,
creditLimit decimal(10,2),
eployeesNumber int(11)
);

create table ProductLine(
productlineNumber varchar (50) not null primary key,
productDescribe text,
image varchar(100)
);

create table Products(
productCode varchar(15) not null primary key,
productName varchar(70) not null,
productScale varchar(10) not null,
productVendor varchar(50) not null,
productDescription text,
quantityInStock int not null,
buyPrice decimal(10,2) not null,
MSRP decimal(10,2) not null,
orderNumber int(11),
productlineNumber varchar(15)
);

create table Orders(
orderNumber int(11) not null primary key,
orderDate datetime not null,
requiredDate datetime not null,
shippedDate datetime not null,
comments  text,
quantityOrdered int(11) not null,
bill int(11) not null,
customerNumber int(11)
);

create table Payments(
paymentNumber int(11) not null primary key,
checkNumber varchar(50) not null,
paymentDate datetime not null,
amount decimal(10,2),
customerNumber int(11)
);

create table Employees(
eployeesNumber int(11) not null auto_increment primary key,
lastName varchar(50) not null,
firstName varchar(50) not null,
email varchar(100) not null,
nameWork varchar(50) not null,
manageEployees int(11)
);

create table Offices(
officeCode varchar(10) not null primary key,
city varchar(50) not null,
address1 varchar(50)not null,
address2 varchar(50),
phone varchar(50) not null,
state  varchar(50),
country varchar(50) not null,
postalCode varchar(15) not null,
eployeesNumber int(11)
);

alter table Customers
add foreign key (eployeesNumber) references Employees(eployeesNumber);

alter table Products
add foreign key (orderNumber) references Orders(orderNumber);

alter table Products
add foreign key(productlineNumber) references ProductLine(productlineNumber);

alter table Orders
add foreign key (customerNumber) references Customers(customerNumber);

alter table Payments
add foreign key (customerNumber) references Customers(customerNumber);

alter table Employees
add foreign key (manageEployees) references Employees(eployeesNumber);

alter table Offices
add foreign key (eployeesNumber) references Employees(eployeesNumber);