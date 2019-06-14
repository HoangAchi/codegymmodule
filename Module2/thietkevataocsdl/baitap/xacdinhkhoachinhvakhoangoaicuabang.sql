Create database quanlytaikhoannganhang;

use quanlytaikhoannganhang;

create table Customers (
customer_number int primary key  AUTO_INCREMENT not null,
fullname varchar(50),
address varchar(50),
email varchar(50),
phone int(10) 
);

create table Accounts (
account_number int primary key  AUTO_INCREMENT not null,
account_type text,
openingdate datetime,
balance int,
customer_number int,
FOREIGN KEY (customer_number) REFERENCES Customers(customer_number)
);

create table Transactions(
tran_number int primary key  AUTO_INCREMENT not null,
account_number int,
transactiontime datetime,
amounts int,
descriptions text,
FOREIGN KEY (account_number) REFERENCES Accounts(account_number)
);