-- here we will give sql commands which will be executed when we run an application
-- this will create course table once application runs
create table course(
    id bigint not null ,
    name varchar(255) not null,
    author varchar(255) not null,
    primary key (id)
);
