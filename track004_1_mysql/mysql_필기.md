#### 1. Mysql?
> 1. mysql why?
1. DBMS 
- Data Base Management System
- 데이터베이스를 관리해주는 시스템

2. DataBase?
- Data + Base
- Data
    1) 데이터(수집된 사실, 값)
    2) 정보 (의미 부여)
- Data(의미를 제공하는 데이터) + Base(체계와 규격을 가진 집합)

Q1. 다음 빈칸을 채우시오
      1.     (#1데이터)는  수집된 사실이나 값을 의미하고
      2.     (#2정보  )는  데이터들 중에서 의미를 제공하는 데이터를 의미

3. DataBase의 종류
- Oracle , Mysql , MSsql

> 2. mysql Setting
1. MYSQL 다운로드
    https://dev.mysql.com/
    - Download
    - MySQL Community Server

2. MYSQL 설치

3. MYSQL 환경설정 
    1) path
    2) UTF-8  chcp 65001

#### 2. RDBMS
> 1. RDBMS (Relational DataBase Management System)

- 관계형 데이터베이스 관리 시스템
- 테이블들의 관계

> 2. RDBMS의 구성요소

- 개체 (Entity : Table)
- 관계 (Realationship)
- 속성 (Attribute : 필드)

  ※ 스키마 - 데이터베이스 구조와 제약조건을 명세정의
     외부스키마 = 사용자뷰
     개념스키마 = 전체적인뷰
     내부스키마 = 저장스키마

  ※ 데이터베이스 설계단계
   #1. 개념적설계 - 요구사항분석 후 개념적 설계 ERD
        (집을 어떻게 지을지? 방은 몇개, 주방은 어디, 거실은 얼마나크게)
   #2. 논리적설계 - ERD를 이용하여 데이터베이스 스키마를 설계
        (방 = 테이블, 사람 = 엔티티 , 관계 = 외래키)
   #3. 물리적설계 - 테이블 저장구조 설계 ( mysql,oracle,,,,)
        (실제 건축자재로 만들기 - mysql, oracle)

> 3. 데이터베이스 언어

1. 정의어 (DDL) Data Definition Language (데이터 정의어)
    Create , Alter , Drop -> CAD
2. 조작어 (DML) Data Manipulation Language (데이터 조작어)
    Insert , Select , Update , Delete -> CRUD
3. 제어어 (DCL) Data Control Language (데이터 제어어)
    Grant , Revoke

> 4. [실습] Database 만들기

1. 만들기       : create database db명
2. 확인         : show databases
3. 삭제(복구x)  : drop database db명
4. DB사용       : use db명

1) 접속
mysql -uroot -p
1234

2) mysql

> 5. [연습]
1. db명 : test, mbasic, db703 3개 db만들기
2. db만들어진것 확인
3. db703 삭제

///////////////////////////////////////
1.   MySQL은 _데이터베이스_ 관리 시스템(DBMS)이다.
2.  (#1 _데이터_)는 수집된 사실이나 값을 의미하고 (#2 _정보_)는 의미를 제공하는 데이터를 의미한다.
3. 대표적인 데이터베이스 종류에는 _mysql_, _oracle_, _mssql_ 등이 있다.
4.  RDBMS는 _Relational_ Database Management System의 약자이다.
5. RDBMS의 구성요소는   _개체_, _관계_, _속성_ 
6. 데이터베이스 언어
DDL(  정의어   )  CREATE, ALTER, DROP 
DML( 조작어  )    _Insert_, _Select_, _Update_ , _Delete_ 
DCL( 제어어  )     _Grant_, _Revoke_

7. 데이터베이스  mbasic, 를 생성하는 SQL 명령어를 작성하시오.
create database mbasic;
8.  생성된 데이터베이스 목록을 확인하는 SQL 명령어를 작성하시오.
show databases;
9. 데이터베이스 db703을 삭제하는 SQL 명령어를 작성하시오.
drop database db703;


#### 3. 테이블

1. RDBMS (Relational DataBase Management System)
- 관계형 데이터 베이스
- 테이블의 관계
- 속성(필드) 연결

2. 테이블 만들기 (집안의 방, 가방 안의 분류표)
DDL (정의 : create, alter, drop) , DML(조작 :) , DCL(제어 :)
-----------------------------------------------
CREATE TABLE table명 (
    필드1 자료형 옵션,
    필드2 자료형 옵션
);
-----------------------------------------------
자료형 : 
    1. 숫자 : int(정수 / 1,2,3), double(실수 / 1.23, 3.14)
    2. 문자 : char(고정, 남/여) , varchar(가변, abc,adcb,adcbe)
    3. 날짜 : date, datetime
옵션 :
    필수입력 - not null (비어있으면 안됨)
    숫자자동증가 - auto_increment
    기본키 - primary key

[실습1]
create table t1(
    name varchar(100) not null,
    age int
);

show tables; -> 테이블목록확인
desc t1; -> 구조확인

create table t11(
    no int not null,
    name varchar(30) not null
);

create talbe t12(
    bookid int not null,
    title varchar(100) not null
);

show tables;
desc t12;

ERROR 1046 (3D000): No database selected
use db명

mysql> show databases;

mysql> use mbasic;
Database changed
mysql> status

mysql> show tables;

※ 참고사항
not null 필수입력
mysql> insert into t1 (age) values (1); >> name not null 필수입력이므로 오류
mysql> insert into t1 (name, age) values ('aaa',1);
mysql> insert into t1 (name) values ('bbb'); >> 위두개는 오류 X

[실습2] auto_increment (숫자 자동증가) , primary key (기본키)

create table t2(
    jumin int not null auto_increment primary key,
    name varchar(100) not null,
    age int 
);

※ 참고사항
auto_increment 자동증가
insert into t2 (name, age) values ('aaa' , 1);
insert into t2 (name) values ('bbb');

insert into t2 (jumin, name, age) values (1, 'ccc', 1);
ERROR 1062 (23000): Duplicate entry '1' for key 't2.PRIMARY'
>> 키값(jumin)이 중복되어 오류남

select * from t2;
+-------+------+------+
| jumin | name | age  |
+-------+------+------+
|     1 | aaa  |    1 | insert into t2 (name, age) values ('aaa' , 1);
|     2 | bbb  | NULL | insert into t2 (name) values ('bbb');
+-------+------+------+
2 rows in set (0.00 sec)