데이터베이스 언어
- DDL : CREATE, ALTER, DROP -> CAD
- ALTER TABLE 테이블명
    ADD        추가필드명   자료형    옵션
    DROP      삭제필드명
    CHANGE  수정할필드명   새로넣을필드명   자료형  옵션
    MODIFY   수정할필드명   자료형  옵션
    RENAME  새로운테이블명

1) alter 문법
https://dev.mysql.com/doc/refman/8.0/en/table.html
help alter
help alter table;

ALTER TABLE 테이블명

    ADD    : 추가
    >> 추가컬럼명 | 자료형 | 옵션 | [FIRST | AFTER col_name]

    DROP   : 삭제
    >> 삭제할필드명

    CHANGE : 수정(테이블명)
    >> 이전 필드명 | 새로운 필드명 | 자료형 | 옵션

    MODIFY : 수정(자료형,옵션)
    >> 수정할필드명 | 자료형 | 옵션

    RENAME : 새로운 테이블 이름

#1) 필드 추가
    alter table (테이블명) add (필드명) (자료형) (옵션);

    alter table userinfo add uno int;
    alter table userinfo add uno2 int first;
    first -> 맨앞에

    alter table userinfo add email varchar(100) after name;
    after -> name 뒤에

#2) 필드 삭제
    alter table (테이블명) drop (필드명);

    alter table userinfo drop uno;
    uno2 삭제 -> alter table userinfo drop uno2;

#3) 필드 수정(CHANGE) - 필드명 수정
    alter table (테이블명) change (기존필드명) (새로운필드명) (자료형) (옵션);

    alter table userinfo change email email2 varchar(50);
    email로 다시변경 -> alter table userinfo change email2 email varchar(50);

#4) 필드 수정(modify) - 자료형 옵션 수정 ( add, drop, change | modify)
    alter table (테이블명) modify (필드명) (자료형) (옵션);

    alter table userinfo modify email varchar(20) not null;

#5) 테이블명 수정 ( add, drop, change | modify, rename )
    alter table (목표 테이블명) rename (바꿀 테이블명);

    alter table userinfo rename users;

1. 테이블 준비
mysql> desc userinfo;
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| no    | int          | NO   | PRI | NULL    | auto_increment |
| name  | varchar(100) | NO   |     | NULL    |                |
| age   | int          | NO   |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)


>>>> 연습문제1)
[001]  다음과 같이 테이블을 준비하시오    >> alter_coffee
create table alter_coffee(
    cno int,
    cname varchar(20),
    cprice int
);

mysql> desc alter_coffee;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| cno    | int(11)     | YES  |     | NULL    |       |
| cname  | varchar(20) | YES  |     | NULL    |       |
| cprice | int(11)     | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)


[002] 다음과 같이 DB와 테이블을 수정하시오  [TABLE명 : alter_coffee] -  ALTER TABLE
연습문제1) cno, cname, cprice필드를 ( not null )으로 수정

alter table alter_coffee change cno cno int not null;
alter table alter_coffee modify cno int not null;

alter table alter_coffee change cname cname varchar(20) not null;
alter table alter_coffee modify cname varchar(20) not null;

alter table alter_coffee change cprice cprice int not null;
alter table alter_coffee modify cprice int not null;

mysql> desc alter_coffee;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| cno    | int         | NO   |     | NULL    |       |
| cname  | varchar(20) | NO   |     | NULL    |       |
| cprice | int         | NO   |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

-------------------------------------------------------

연습문제2) 쿠폰필드  cgift    문자열고정(10)  미필수로 추가

alter table alter_coffee add cgift char(10);

mysql> desc alter_coffee;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| cno    | int         | NO   |     | NULL    |       |
| cname  | varchar(20) | NO   |     | NULL    |       |
| cprice | int         | NO   |     | NULL    |       |
| cgift  | char(10)    | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

-------------------------------------------------------

연습문제3) 쿠폰필드  cgift를  ccoupon으로 바꾸기

alter table alter_coffee change cgift ccoupon char(10);

mysql> desc alter_coffee;
+---------+-------------+------+-----+---------+-------+
| Field   | Type        | Null | Key | Default | Extra |
+---------+-------------+------+-----+---------+-------+
| cno     | int         | NO   |     | NULL    |       |
| cname   | varchar(20) | NO   |     | NULL    |       |
| cprice  | int         | NO   |     | NULL    |       |
| ccoupon | char(10)    | YES  |     | NULL    |       |
+---------+-------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

-------------------------------------------------------

연습문제4) 쿠폰필드 ccoupon삭제

alter table alter_coffee drop ccoupon;

mysql> desc alter_coffee;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| cno    | int         | NO   |     | NULL    |       |
| cname  | varchar(20) | NO   |     | NULL    |       |
| cprice | int         | NO   |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

-------------------------------------------------------

연습문제5) cno를 cprice뒤로이동

alter table alter_coffee change cno cno int not null after cprice;
alter table alter_coffee modify cno int not null after cprice;

mysql> desc alter_coffee;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| cname  | varchar(20) | NO   |     | NULL    |       |
| cprice | int         | NO   |     | NULL    |       |
| cno    | int         | NO   |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

-------------------------------------------------------

연습문제6) cno를 맨위로

alter table alter_coffee change cno cno int not null first;
alter table alter_coffee modify cno int not null first;

mysql> desc alter_coffee;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| cno    | int         | NO   |     | NULL    |       |
| cname  | varchar(20) | NO   |     | NULL    |       |
| cprice | int         | NO   |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

-------------------------------------------------------

연습문제7) cno를 primary key 추가

alter table alter_coffee change cno cno int not null primary key;

alter table alter_coffee add primary key(cno);

-- primary key 삭제
alter table alter_coffee drop primary key;

mysql> desc alter_coffee;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| cno    | int         | NO   | PRI | NULL    |       |
| cname  | varchar(20) | NO   |     | NULL    |       |
| cprice | int         | NO   |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

-------------------------------------------------------

연습문제8) alter_coffee테이블의 이름을 alter_coffee2로 바꾸기

alter table alter_coffee rename alter_coffee2;

mysql> desc alter_coffee2;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| cno    | int         | NO   | PRI | NULL    |       |
| cname  | varchar(20) | NO   |     | NULL    |       |
| cprice | int         | NO   |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

-------------------------------------------------------

연습문제9) 다음과 같이 최종본으로 테이블만들기

-- alter table alter_coffee2 change cno cno int not null primary key auto_increment;
-- >> 이미 primary key가 부여되어있으면 따로 안적어도 되는거같음 
-- >> primary key가 테이블당 1개밖에 부여가 안됨

alter table alter_coffee2 change cno cno int not null auto_increment;
alter table alter_coffee2 modify cno int not null auto_increment;

mysql> desc alter_coffee2;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| cno    | int(11)     | NO   | PRI | NULL    | auto_increment |
| cname  | varchar(20) | NO   |     | NULL    |                |
| cprice | int(11)     | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)