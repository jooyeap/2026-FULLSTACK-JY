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

drop table authorities;

create sequence appuser_seq;
create table appuser(
    APP_USER_ID number(5) not null primary key,
    EMAIL VARCHAR2(100) not null,
    PASSWORD VARCHAR2(100),
    MBTI_TYPE_ID number(3),
    CREATED_AT DATE,
    UFILE VARCHAR2(255),
    MOBILE VARCHAR2(50),
    NICKNAME VARCHAR2(50),
    PROVIDER VARCHAR2(50) not null,
    PROVIDER_ID VARCHAR2(100)
);

alter table appuser modify CREATED_AT date default sysdate;

create sequence auth_seq;
create table authorities(
    AUTH_ID number(5) not null primary key,
    EMAIL VARCHAR2(255),
    AUTH VARCHAR2(255) not null,
    APP_USER_ID number(5)    
);

alter table authorities modify
    APP_USER_ID number(5) constraint APP_USER_ID foreign key (APP_USER_ID) references appuser(APP_USER_ID)

desc appuser;
desc authorities;

select * from appuser;
select * from authorities;

-- 1) 회원가입
insert into appuser 
    (APP_USER_ID, EMAIL, PASSWORD, MBTI_TYPE_ID, CREATED_AT, UFILE, MOBILE, NICKNAME, PROVIDER, PROVIDER_ID)
values
    (appuser_seq.nextval, 'first@gmail.com', 'first', 1, sysdate, '1.png', '000-1111-2222', 'first', 'the703', 't7-1');
    
-- 2) 로그인 - 이메일로 이메일, 비밀번호 권한 가져오기
select u.email, u.password, a.auth
from appuser u left join authorities a on u.email = a.email
where u.email = 'first@gmail.com';

-- 3) 이메일로 유저찾기
select * from appuser where email = 'first@gmail.com';

-- 4) 이메일로 중복검사
select count(*) from appuser where email = 'first@gmail.com';

-- 5) 회원수정
update appuser
set
    password='2222',
    mbti_type_id=2,
    ufile = '2.png',
    nickname = 'second',
    mobile = '000-2222-2222',
    provider = 'naver',
    provider_id =  'n-1'
where app_user_id = 1;

-- 6) 회원삭제
delete from appuser where app_user_id = 1;

-- 7) 권한삽입
insert into authorities
    (AUTH_ID, EMAIL, AUTH)
values
    (auth_seq.nextval, 'first@gmail.com', 'ROLE_MEMBER');

-- 8) 권한삭제
delete from authorities where EMAIL = 'first@gmail.com';

select * from authorities;
select * from appuser;

delete from appuser where app_user_id = 123;
delete from authorities where auth_id = 123;

commit;
