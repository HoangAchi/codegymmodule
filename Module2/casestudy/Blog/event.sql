CREATE DATABASE events default CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
use events;

create table Category(
id int not null auto_increment primary key,
name_Category varchar (100) not null,
create_Date datetime not null default now(),
last_Edited_Date datetime not null default now()
); 

create table admin(
id int auto_increment primary key not null,
username varchar(50) not null,
password varchar(80) not null,
fullName varchar(50) not null,
year_Old int(3) not null,
phone varchar(10) not null,
email varchar(100) not null,
address varchar(100) not null,
image text not null,
create_Date datetime not null default now(),
last_Edited_Date datetime not null default now() 
);

create table subscriber(
id int auto_increment primary key not null,
fullname varchar(50) not null,
email varchar(100) not null,
phone varchar(10) not null,
address varchar(100) not null
);

create table event(
id int auto_increment primary key not null,
name_Event varchar(250) not null,
image text not null,
note_Image varchar(100) not null,
place varchar(100) not null,
time_To_Organize datetime not null,
organizational_Unit varchar(50) not null,
detailed_Program text not null,
title text not null,
is_Delete tinyint(1) not null default 0,
post_Date datetime not null default now(),
last_Edited_Date datetime not null default now(),
id_Category int not null,
foreign key (id_Category) references  Category(id) on delete cascade on update cascade,
id_Admin int not null,
foreign key (id_Admin) references admin(id) on delete cascade on update cascade
);

create table registrationdetail(
id_subscriber int not null,
id_Event int not null,
primary key(id_Event,id_Subscriber),
time_Registration datetime not null,
content_Registration varchar(250) not null,
foreign key (id_Event) references event(id)  on delete cascade on update cascade,
foreign key (id_subscriber) references subscriber(id)  on delete cascade on update cascade
);

insert into Category(name_Category)
values ('technology');
insert into Category(name_Category)
values ('sport');
insert into Category(name_Category)
values ('fashion');
insert into Category(name_Category)
values ('society');
insert into Category(name_Category)
values ('art');

insert into admin(username,password,fullName,year_Old,phone,email,address,image)
values ('hai123','hai123','Nguyễn Vũ Hồ Hải','22','0835566236','hai@gmail.com','26 nguyễn tri phương','https://scontent.fsgn2-2.fna.fbcdn.net/v/t1.0-9/54798176_2155011671261847_3959002623255773184_n.jpg?_nc_cat=100&_nc_oc=AQnDqt4-xBMrJoIv8m-bqJGWR1FgmDwrO3iDP93RvW1w68AUeQGDbjwOcUKRH7KYCa0&_nc_ht=scontent.fsgn2-2.fna&oh=e5d0d935ca3f1b40359c3b5c0c8bfe3b&oe=5DBF6F2D');
insert into admin(username,password,fullName,year_Old,phone,email,address,image)
values ('nhat111','nhat111','Ngô Phan Anh Nhật',22,'0835566236','nhat@gmail.com','26 nguyễn tri phương','https://scontent.fhan2-4.fna.fbcdn.net/v/t1.0-1/46337865_2083486041698122_6445709479852900352_n.jpg?_nc_cat=104&_nc_oc=AQmqrvaYJlzqN5jNr5dMTYhZGoHLqZ5kL3Cut9PN2H19MhVQm_WeHfTP0DpFm7TZ2BI&_nc_ht=scontent.fhan2-4.fna&oh=a3e1ff3744e61b74d56ffc20f94e6e33&oe=5DC2C1F4');
insert into admin(username,password,fullName,year_Old,phone,email,address,image)
values ('thanhtin','thanhtin123','Trần Thanh Tín',21,'0835566236','thanhtin123@gmail.com','26 nguyễn tri phương','http://www.pxleyes.com/images/contests/avatar%20wars/fullsize/avatar%20wars_4a5f5b501b376_hires.jpg');
insert into admin(username,password,fullName,year_Old,phone,email,address,image)
values ('achihoang','hoang123','Nguyễn Đức Thanh Hoàng',21,'0835566236','achihoang@gmail.com','26 nguyễn tri phương','https://scontent.fsgn2-3.fna.fbcdn.net/v/t1.0-9/36585486_2158466447756128_7622169492595933184_n.jpg?_nc_cat=108&_nc_oc=AQnowvNTSaD-ONJUTAhxQXZtEwacyTN5LGZC2qZs3c_JwakOEum0aDqWRo57eurJA94&_nc_ht=scontent.fsgn2-3.fna&oh=0d3cbcc480bb339dbf2ba083fb3941c8&oe=5DBAAB55');
insert into admin(username,password,fullName,year_Old,phone,email,address,image)
values ('ducanh','anhken123','Nguyễn Đức Anh',22,'0835566236','anhken238@gmail.com','26 nguyễn tri phương','https://scontent.fsgn2-2.fna.fbcdn.net/v/t1.0-1/c0.0.580.580a/55244448_2233288523601348_2745591705490161664_n.jpg?_nc_cat=100&_nc_oc=AQlHT-emJY_hiuXtmF313niSeLISgKfY9R45v1u5paj7A3OvpymEYLwU9m0pZhPbeQU&_nc_ht=scontent.fsgn2-2.fna&oh=9eaa1ea6b41756f71e37585dcaf2057f&oe=5DC557DD');

insert into subscriber(fullname,email,phone,address)
values ('Nguyễn Văn Hải Đức','haiduc1120@gmail.com','0834821540','Huế');
insert into subscriber(fullname,email,phone,address)
values ('Lê Tường Phúc','phuc.le@codegym.vn','0834821540','Huế');
insert into subscriber(fullname,email,phone,address)
values ('Lê Quốc Khánh','khanh.le@codegym.vn','0834821540','Huế');
insert into subscriber(fullname,email,phone,address)
values ('Phạm Văn Hoài Phụng','hoaiphungcntt@gmail.com','0834821540','Huế');
insert into subscriber(fullname,email,phone,address)
values ('Nguyễn Duy Tài','nguyenduytai945@gmail.com','0834821540','Huế');

insert into event(name_Event,image,note_Image,place,time_To_Organize,organizational_Unit,detailed_Program,title,id_Category,id_Admin)
values ('The 13th Int l Conference on Research, Innovation and Vision for the Future','https://rivfconference.files.wordpress.com/2019/05/saigon-south_l_1220px_72dpi.jpg','RMIT Vietnam – SaiGon South Campus','Da Nang, Vietnam.','2019-02-22','IEEE, UDN','​RIVF 2020 is the 14th conference in this series. RMIT University Vietnam is hosting the conference for April 6-7, 2020 in HoChiMinh city, Vietnam. It continues to offer an opportunity for researchers and innovators to discuss problems, share results, identify emerging issues, and establish academic collaborations in various disciplines of computing and communications.','note','1','1');
insert into event(name_Event,image,note_Image,place,time_To_Organize,organizational_Unit,detailed_Program,title,id_Category,id_Admin)
values ('The 23rd Pacific-Asia Conference on Knowledge Discovery and Data Mining','http://pakdd2019.medmeeting.org/upload/meeting/7566/Banner/201806/2018622492610_big.jpg','note','DMacau, China.','2019-04-17','IEEE','The Pacific-Asia Conference on Knowledge Discovery and Data Mining (PAKDD) ','note','2','1');
insert into event(name_Event,image,note_Image,place,time_To_Organize,organizational_Unit,detailed_Program,title,id_Category,id_Admin)
values ('ội nghị khoa học quốc gia lần thứ XII về "Nghiên cứu cơ bản và ứng dụng Công nghệ thông tin','https://rivfconference.files.wordpress.com/2019/05/saigon-south_l_1220px_72dpi.jpg','RMIT Vietnam – SaiGon South Campus','Da Nang, Vietnam.','2019-07-22','IEEE, UDN','​RIVF 2020 is the 14th conference in this series. RMIT University Vietnam is hosting the conference for April 6-7, 2020 in HoChiMinh city, Vietnam. It continues to offer an opportunity for researchers and innovators to discuss problems, share results, identify emerging issues, and establish academic collaborations in various disciplines of computing and communications.','note','3','1');
insert into event(name_Event,image,note_Image,place,time_To_Organize,organizational_Unit,detailed_Program,title,id_Category,id_Admin)
values ('The 11th International Conference on Knowledge and Systems Engineering','https://rivfconference.files.wordpress.com/2019/05/saigon-south_l_1220px_72dpi.jpg','RMIT Vietnam – SaiGon South Campus','Da Nang, Vietnam.','2019-09-17','IEEE, UDN','​RIVF 2020 is the 14th conference in this series. RMIT University Vietnam is hosting the conference for April 6-7, 2020 in HoChiMinh city, Vietnam. It continues to offer an opportunity for researchers and innovators to discuss problems, share results, identify emerging issues, and establish academic collaborations in various disciplines of computing and communications.','note','5','1');
insert into event(name_Event,image,note_Image,place,time_To_Organize,organizational_Unit,detailed_Program,title,id_Category,id_Admin)
values ('The 19th International Symposium on Communications and Information Technologies (ISCIT)','https://rivfconference.files.wordpress.com/2019/05/saigon-south_l_1220px_72dpi.jpg','RMIT Vietnam – SaiGon South Campus','Da Nang, Vietnam.','2019-09-25','IEEE, UDN','​RIVF 2020 is the 14th conference in this series. RMIT University Vietnam is hosting the conference for April 6-7, 2020 in HoChiMinh city, Vietnam. It continues to offer an opportunity for researchers and innovators to discuss problems, share results, identify emerging issues, and establish academic collaborations in various disciplines of computing and communications.','note','4','1');

insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (2,1,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (3,1,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (1,1,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (4,1,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (5,1,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (2,2,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (3,2,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (1,2,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (4,2,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (5,2,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (2,3,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (3,3,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (1,3,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (4,3,'2019-07-03','note');
insert into registrationdetail(id_subscriber,id_Event,time_Registration,content_Registration)
values (5,3,'2019-07-03','note');