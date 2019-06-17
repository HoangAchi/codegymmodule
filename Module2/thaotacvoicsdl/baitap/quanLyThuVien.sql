create database quanlymuontrasach;
use quanlymuontrasach;
create table Book(
bookNumber varchar(15) primary key not null,
bookName varchar(50) not null,
publishingHouse varchar(50) not null,
author varchar(50) not null,
numberofPublications int(11) not null,
bill int(11) not null,
image binary,
categoryNumber varchar(15),
bookStatus varchar(50) not null
);

create table Student(
studentNumber varchar(15) primary key not null,
studentName varchar(50) not null,
birthday date not null,
address varchar(500) not null,
email varchar(50) not null,
image binary,
bookNumber varchar(15)
);

create table Category(
categoryNumber varchar(15) primary key not null,
categoryName varchar(50) not null
);

create table RegisterBorrowBook(
borroworderNumber varchar(15) primary key not null,
dateBorrow date not null,
datePay date not null,
studentNumber varchar(15),
bookNumber varchar(15)
);

create table BorowBook(
borrowBookNumber varchar(15) primary key not null,
studentNumber varchar(15),
bookNumber varchar(15),
borrowBookStatus varchar(50) not null
);

alter table Book
add foreign key (categoryNumber) references Category(categoryNumber);

alter table Student
add foreign key (bookNumber) references Book(bookNumber);

alter table RegisterBorrowBook
add foreign key (studentNumber) references Student(studentNumber);

alter table RegisterBorrowBook
add foreign key (bookNumber) references Book(bookNumber);

alter table BorowBook
add foreign key (studentNumber) references Student(studentNumber);

alter table BorowBook
add foreign key (bookNumber) references Book(bookNumber);

insert into Book(bookNumber,bookName,publishingHouse,author,numberofPublications,bill,image,categoryNumber,bookStatus)
values ('1','The Blue Umbrella','NXB KimDong','Ruskin Bond',2,93.00,'','1','is already borrowed');

insert into Book(bookNumber,bookName,publishingHouse,author,numberofPublications,bill,image,categoryNumber,bookStatus)
values ('2','Java The Complete Reference','NXB young','Herbert Schildt',2,649.00,'','2','is already borrowed');

insert into Book(bookNumber,bookName,publishingHouse,author,numberofPublications,bill,image,categoryNumber,bookStatus)
values ('3','Diary of an Awesome Friendly Kid','KimDong','Jeff Kinney',2,93.00,'','3','not yet borrowed');

insert into Book(bookNumber,bookName,publishingHouse,author,numberofPublications,bill,image,categoryNumber,bookStatus)
values ('4','The Blue Umbrella','Daystar','Ruskin Bond',2,93.00,'','1','not yet borrowed');

insert into Book(bookNumber,bookName,publishingHouse,author,numberofPublications,bill,image,categoryNumber,bookStatus)
values ('5','Programming with Java','Daystar','E. Balagurusamy',2,147.00,'','2','is already borrowed');

insert into Student(studentNumber,studentName,birthday,address,email,image,bookNumber)
values ('1','Tai','1997-04-05','Huế','tai@gmail.com','','1');

insert into Student(studentNumber,studentName,birthday,address,email,image,bookNumber)
values ('2','Tin','1997-04-05','Huế','tin@gmail.com','','2');

insert into Student(studentNumber,studentName,birthday,address,email,image,bookNumber)
values ('3','San','1997-04-05','Huế','san@gmail.com','','3');

insert into Student(studentNumber,studentName,birthday,address,email,image,bookNumber)
values ('4','Duc','1997-04-05','Huế','duc@gmail.com','','4');

insert into Student(studentNumber,studentName,birthday,address,email,image,bookNumber)
values ('5','Phung','1997-04-05','Huế','phung@gmail.com','','2');

insert into Category(categoryNumber,categoryName)
values ('1','story');

insert into Category(categoryNumber,categoryName)
values ('2','program');

insert into Category(categoryNumber,categoryName)
values ('3','novel');

insert into Category(categoryNumber,categoryName)
values ('4','affection');

insert into Category(categoryNumber,categoryName)
values ('5','action');

insert into RegisterBorrowBook(borroworderNumber,dateBorrow,datePay,studentNumber,bookNumber)
values ('1','2018-06-07','2018-06-22','1','2');

insert into RegisterBorrowBook(borroworderNumber,dateBorrow,datePay,studentNumber,bookNumber)
values ('2','2018-06-07','2018-06-22','2','1');

insert into RegisterBorrowBook(borroworderNumber,dateBorrow,datePay,studentNumber,bookNumber)
values ('3','2018-06-07','2018-06-22','4','3');

insert into RegisterBorrowBook(borroworderNumber,dateBorrow,datePay,studentNumber,bookNumber)
values ('4','2018-06-07','2018-06-22','5','5');

insert into RegisterBorrowBook(borroworderNumber,dateBorrow,datePay,studentNumber,bookNumber)
values ('5','2018-06-07','2018-06-22','3','2');

insert into BorowBook(borrowBookNumber,studentNumber,bookNumber,borrowBookStatus)
values ('1','1','1','Unpaid');

insert into BorowBook(borrowBookNumber,studentNumber,bookNumber,borrowBookStatus)
values ('2','3','4','Paid');

insert into BorowBook(borrowBookNumber,studentNumber,bookNumber,borrowBookStatus)
values ('3','1','3','Unpaid');

insert into BorowBook(borrowBookNumber,studentNumber,bookNumber,borrowBookStatus)
values ('4','1','2','Paid');

insert into BorowBook(borrowBookNumber,studentNumber,bookNumber,borrowBookStatus)
values ('5','4','1','Unpaid');

select * from Book;

select bookName from Book Inner join Category where Category.categoryName = 'program' and	Book.categoryNumber = Category.categoryNumber;

select * from Book where bookStatus = 'is already borrowed';

select studentName from 
	Student 
	Inner join Book on Student.bookNumber = Book.bookNumber
	inner join BorowBook on Student.studentNumber = BorowBook.studentNumber
where Book.bookStatus = 'is already borrowed' and BorowBook.borrowBookStatus = 'Unpaid' ;