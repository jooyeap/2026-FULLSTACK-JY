conn scott/tiger;

create table sboard2(
ID number not null,
APP_USER_ID number not null,
BTITLE varchar2(1000) not null,
BCONTENT clob not null,
BPASS varchar2(255) not null,
BFILE varchar2(255) default 'the703.png',
BHIT number default 0 ,
BIP varchar2(255) not null,
CREATED_AT DATE default sysdate
);

create sequence sboard2_seq;

alter table sboard2 modify BHIT number not null;
desc sboard2;
drop table sboard2;

-- 데이터 삽입
insert into sboard2 (ID, APP_USER_ID, BTITLE, BCONTENT, BPASS, BFILE, BIP)
            values (sboard2_seq.nextval, 1001, 'title', 'bcontent', '1111', '1.png', '127.0.0.1');


-- 전체 select
-- select * from sboard2 order by id desc;

-- mysql 페이징
-- select * from sboard2 order by id desc limit 0, 10;

-- oracle 페이징
select * from sboard2 order by id desc;

-- 해당 번호 select
select * from sboard2 where id = 1;

-- 해당 번호 조회수
update sboard2 set bhit = bhit + 1 where id = 1;

-- 해당 번호 update
update sboard2 set btitle='new', bcontent='new', bfile='2.png' where id = 1;

-- 해당 번호 delete
delete from sboard2 where id = 1;