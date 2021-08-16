DROP TABLE IF EXISTS test;
create table contact
(
    phone varchar(255) not null,
    email varchar(255),
    name varchar(255),
    position varchar(255),
    company_name varchar(255),
    primary key (phone)
);

create table customer (
    company_name varchar(255) not null,
    address varchar(255),
    country varchar(255),
    primary key (company_name)
);

alter table contact add constraint FK9sjyif0htbdy1dfsqpgw695q4 foreign key (company_name) references customer;

