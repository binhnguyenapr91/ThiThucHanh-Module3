drop database examModule3;

create database examModule3;
use examModule3;

create table products (
	productId int primary key auto_increment,
    productName varchar(255),
    productPrice float,
    productQuantity int,
    productColor varchar(255),
    productDescription varchar(255),
    productCategoryId int,
    foreign key (productCategoryId) references categories(categoryId)
);

create table categories(
	categoryId int primary key auto_increment,
    categoryName varchar(255)
);


insert into categories (categoryName)values('Phone');
insert into categories (categoryName)values('Television');

insert into products (productName, productPrice,productQuantity,productColor,productDescription,productCategoryId)
values('Iphone 11',50000000,20,'Red,Green,Silver','OS 13; high performance, camera very good','1');
insert into products (productName, productPrice,productQuantity,productColor,productDescription,productCategoryId)
values('Iphone 10',45000000,20,'Red,Green,Silver','OS 13; high performance, camera very good','1');
insert into products (productName, productPrice,productQuantity,productColor,productDescription,productCategoryId)
values('Iphone 5',40000000,20,'Red,Green,Back','OS 13; high performance, camera very good','1');
insert into products (productName, productPrice,productQuantity,productColor,productDescription,productCategoryId)
values('Samsung Galaxy',30000000,20,'Red,Violet,Silver','OS 13; high performance, camera very good','1');
insert into products (productName, productPrice,productQuantity,productColor,productDescription,productCategoryId)
values('Huawei',20000000,20,'Red,Gray,Silver','OS 13; high performance, camera very good','1');
insert into products (productName, productPrice,productQuantity,productColor,productDescription,productCategoryId)
values('Oppo',10000000,20,'Red,Yellow,Silver','OS 13; high performance, camera very good','1');
insert into products (productName, productPrice,productQuantity,productColor,productDescription,productCategoryId)
values('Tivi LTC',500000,10,'Red,Back,Silver','OS 13; high performance, camera very good','2');
insert into products (productName, productPrice,productQuantity,productColor,productDescription,productCategoryId)
values('Iphone 11',50000000,20,'Red,Blue,Silver','OS 13; high performance, camera very good','1');
insert into products (productName, productPrice,productQuantity,productColor,productDescription,productCategoryId)
values('Iphone 11',50000000,20,'Red,Green,Silver','OS 13; high performance, camera very good','1');


