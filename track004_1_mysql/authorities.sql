use mbasic;

create table testp(
test1 int primary key,
test2 int,
test3 int
);

desc testp;

create table tests(
test2 int primary key,
author_test1 int,
foreign key (author_test1) references testp(test1)
);

desc tests;

use mbasic;
desc users;
alter table users modify bpass varchar(500) not null;


select * from users;

select count(*) from users where nickname='aaa';
delete from users where nickname = 'b';

SET SQL_SAFE_UPDATES=0;


create table authorities(
email varchar(50) not null,
auth varchar(50) not null
);

desc authorities;

insert into authorities (email, auth) values('aaa@aaa.com','ROLE_MEMBER');
insert into authorities (email, auth) values('aaa@aaa.com','ROLE_ADMIN');

select * from authorities;

select  a.email, a.bpass, b.auth
from users a left join authorities b
on a.email=b.email
where a.email='aaa@aaa.com';