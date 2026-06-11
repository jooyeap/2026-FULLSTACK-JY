use mbasic;

create table userinfo_e(
no int not null primary key auto_increment,
email varchar(100) not null,
age int
);

desc userinfo_e;
desc users;
select * from users;


insert into userinfo_e (no,email,age) value (1,'aaa',11);


-- mysql> desc mvcboard2;
-- +----------+---------------+------+-----+-------------------+-------------------+
-- | Field    | Type          | Null | Key | Default           | Extra             |
-- +----------+---------------+------+-----+-------------------+-------------------+
-- | bno      | int           | NO   | PRI | NULL              | auto_increment    |
-- | bname    | varchar(20)   | NO   |     | NULL              |                   |
-- | bpass    | varchar(50)   | NO   |     | NULL              |                   |
-- | btitle   | varchar(1000) | NO   |     | NULL              |                   |
-- | bcontent | text          | NO   |     | NULL              |                   |
-- | bdate    | timestamp     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
-- | bhit     | int           | NO   |     | 0                 |                   |
-- | bip      | varchar(50)   | NO   |     | NULL              |                   |
-- +----------+---------------+------+-----+-------------------+-------------------+
-- 8 rows in set (0.00 sec)

-- mysql>   
use mbasic;   
show tables;
desc mvcboard1;
create table mvcboard2 select *from mvcboard1 where 1=2;
desc mvcboard2;
alter table mvcboard2 modify bno int not null primary key auto_increment;

select * from mvcboard2;

alter table mvcboard2 auto_increment =4;

delete from mvcboard2 where bno>3;

alter table mvcboard2 add img varchar(50);
alter table mvcboard2 change bimg bimg varchar(500) default 'the703.png';