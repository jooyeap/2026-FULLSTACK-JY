show tables;
desc milk;
select * from milk;
alter table milk modify mnum int;
alter table milk modify mtotal int;
insert into milk (mno,mname,mprice) values(1,'white',1500);
insert into milk (mno,mname,mprice) values(2,'choco',1800);
insert into milk (mno,mname,mprice) values(3,'banana',1800);

-- <!--       주문현황표             -->
-- <!--       주문현황표             -->
-- <!-- 
-- = MODEL
-- ★ 다음과 같이 테이블을 준비해주세요!
-- mysql> desc milk_order;
show tables;
create table milk_order(
ono int not null primary key auto_increment,
oname varchar(20) not null,
onum int not null,
odate datetime default current_timestamp,
oip varchar(100) not null
);
desc milk_order;
-- +-------+--------------+------+-----+-------------------+-------------------+
-- | Field | Type         | Null | Key | Default           | Extra             |
-- +-------+--------------+------+-----+-------------------+-------------------+
-- | ono   | int          | NO   | PRI | NULL              | auto_increment    |
-- | oname | varchar(20)  | NO   |     | NULL              |                   |
-- | onum  | int          | NO   |     | NULL              |                   |
-- | odate | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
-- | oip   | varchar(100) | NO   |     | NULL              |                   |
-- +-------+--------------+------+-----+-------------------+-------------------+
-- 5 rows in set (0.00 sec)


-- -- Q1.  milk_order 값삽입.  insert 구문 완성    
insert into milk_order (oname, onum, oip) values('banana',1,'198.160.0.1');
-- -- Q2.  milk_order ono가 1인데이터 조회 
select * from milk_order where ono=1;
-- -- Q3.  milk_order 전체데이터조회
select * from milk_order;
-- -- Q4.  milk_order 해당번호의 이름과 갯수 수정
update milk_order set oname='', onum=0 where ono=0;
-- -- Q5.  milk_order 해당번호의 데이터 삭제
delete from milk_order where ono=0;



--  -->