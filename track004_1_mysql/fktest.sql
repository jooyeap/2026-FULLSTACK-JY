create table t1(
no int not null primary key auto_increment,
name varchar(100)
);

drop table t2;
desc t1;
desc t2;

create table t2(
ino int not null primary key,
foreign key (ino) references t1(no)
);

insert into t1 (name) values ('first');
insert into t1 (name) values ('second');

select * from t1;
select * from t2;

insert into t2 (ino) values (1);
insert into t2 (ino) values (3);

create table t3 (
    no int not null auto_increment primary key, name varchar(100)
);

create table t4(
    ino int not null primary key,
    foreign key (ino) references t3(no) on delete cascade on update cascade
);

desc t3;
desc t4;

insert into t3(no, name) values (1, 'first');
insert into t3(no, name) values (2, 'second');
insert into t4(ino) values (2);
insert into t4(ino) values (2);

select * from t3;
select * from t4;

update t3 set no=20 where no=2;
delete from t3 where no=20;