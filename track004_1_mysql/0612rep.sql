create database sb_erp_db;
use sb_erp_db;

-- 권한 테이블
-- 테이블 ID / 사용자 ID / 직급 ID / auth
create table authorities(
auth_id int not null primary key auto_increment,
user_id varchar(50) not null,
dept_id int not null,
auth varchar(50) not null,
foreign key (user_id) references users(user_id),
foreign key (dept_id) references dept(dept_id)
);

-- 사용자 테이블
-- 사용자 ID / 비밀번호 / 이메일 
create table users(
user_id varchar(50) not null primary key,
user_pass varchar(500) not null,
user_email varchar(50) not null
);

-- 사용자 조회

-- 결재 양식 테이블
-- 양식 ID / 양식코드 / 양식 이름 / 양식 본문 / 양식 추가할 회사 / 활성화 여부
create table  appr_form(
form_id int not null primary key auto_increment,
com_id int not null,
form_code varchar(50) not null,
form_title varchar(50) not null,
form_content varchar(500) not null,
form_status boolean not null,
foreign key (com_id) references com(com_id)
);


-- 결재 문서 테이블
-- 문서 상태 ( WAI, APP, REJ )
-- 문서 ID / 양식 ID / 제목 / 본문 / 문서상태 / 작성 일시 / 부서 / 작성사명 / 회사 ID(조직도 사원 검색)
create table appr_doc(
doc_id int not null primary key auto_increment,
from_id int not null,
dept_id int not null,
com_id int not null,
doc_title varchar(50) not null,
doc_content varchar(500) not null,
doc_status varchar(20) not null default 'WAI',
doc_name varchar(30) not null, -- 작성자명은 join 이용
foreign key (from_id) references appr_form(from_id),
foreign key (dept_id) references dept(dept_id),
foreign key (com_id) references com(com_id)
);
