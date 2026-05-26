create database dbdbig;
show databases;
use dbdbig;
drop database dbdbig;
use mbasic;

create table mvcboard1 (
bno int not null primary key auto_increment,
bname varchar(200) not null,
bpass varchar(50) not null,
btitle varchar(1000) not null,
bcontent text not null,
bdate timestamp not null default current_timestamp,
bhit int not null default 0,
bip varchar(50) not null );

desc mvcboard1;
insert into mvcboard1 (bno, bname, bpass, btitle, bcontent, bip) values((count(bno)+1),aaa,aaa,aaa,aaa,aaa);

select count(bno) from mvcboard1;

use mbasic;

select count(*) `cnt` from mvcboard1;
select * from mvcboard1 order by bno desc;

SELECT b.*, (SELECT COUNT(*) FROM mvcboard1) AS cnt
FROM mvcboard1 b
ORDER BY bno DESC;

select * from mvcboard1 where bhit > (select bhit from mvcboard1 where bname in ('qwe'));
select bhit from mvcboard1 where bhit ;

-- mysql>
-- mysql> desc users;
-- +----------+--------------+------+-----+-------------------+-------------------+
-- | Field    | Type         | Null | Key | Default           | Extra             |
-- +----------+--------------+------+-----+-------------------+-------------------+
-- | uno      | int          | NO   | PRI | NULL              | auto_increment    |
-- | nickname | varchar(20)  | NO   |     | NULL              |                   |
-- | bpass    | varchar(50)  | NO   |     | NULL              |                   |
-- | email    | varchar(100) | NO   |     | NULL              |                   |
-- | mobile   | varchar(50)  | NO   |     | NULL              |                   |
-- | udate    | timestamp    | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
-- | bip      | varchar(50)  | NO   |     | NULL              |                   |
-- +----------+--------------+------+-----+-------------------+-------------------+
-- 7 rows in set (0.00 sec) 
-- bname > nickname char(20), 

create table users(
uno int not null primary key auto_increment,
nickname varchar(20) not null,
bpass varchar(50) not null,
email varchar(100) not null,
mobile varchar(50) not null,
udate timestamp not null default current_timestamp,
bip varchar(50) not null
);

desc users;
select * from users;
select * from users where email='aaa@aaa.com' and bpass='aaa';
