select * from appr_form where com_id = 1; 
desc appr_form;

ALTER TABLE appr_form DROP CONSTRAINT UQ_APPR_FORM_COM_CODE;
alter table appr_form add constraint uq_appr_form_com_code UNIQUE (com_id, for_code, for_version);

select * from employee;
select * from appr_doc where is_important = 1;
select * from appr_doc where doc_status = 'ING';
select * from appr_doc order by emp_id desc; -- emp_id 117
select * from employee order by com_id asc;
select * from appr_doc where emp_id = 17;
select * from employee where com_id = 1;
select * from appr_line where lin_status = 'WAI';
select * from company;

select emp_name from employee where emp_id = 117;

desc appr_line;

update employee
set emp_pass = '$2a$10$Qci4eB7OsX3GEjYpthpquO.TFoA6ylChzZTyoEdry3K/qS5Y8piHu'
where emp_id <= 10;

update employee 
set emp_name = '윤정한'
,emp_pass = '$2b$12$YNP0b.AzY.C58SNYcTKn7O./NrF1aE00I2oF.symAc6qnhh71M9YW'
where emp_id = 130; 

update employee 
set emp_name = '한소희'
,emp_pass = '$2b$12$fGTYXZz2QOlraT4GAHz68u39muWEpzN98qJ2kw/2DF.OuUmhAkgJO'
where emp_id = 17; 

commit;

-- CONSTRAINT uq_appr_form_com_code UNIQUE (com_id, for_code, for_version) for_version 추가해야함

alter table appr_form drop constraint uq_appr_form_com_code;

alter table appr_form add constraint uq_appr_form_com_code unique (com_id, for_code, for_version);

commit;

desc appr_doc;

select * from company;
select * from authority;
select * from employee;
select * from employee where com_id = 1;
select * from emp_auth;
select * from appr_doc where com_id = 1;
select * from appr_doc where doc_id = 221;
select * from appr_form where com_id =1;
select * from appr_line where doc_id =125;
select * from appr_line;

select * from appr_form;

select * from appr_doc where doc_status = 'CAN';
update appr_doc set doc_status = 'REJ' where doc_status = 'CAN';
commit;

delete from appr_form where for_id = 106;
delete from appr_form where for_version = 2;

update appr_form set for_content = null where for_id = 121;

commit;

select doc_id, doc_title, doc_status from appr_doc where emp_id = 130;
delete from appr_doc where doc_id = 118;
delete from appr_line where doc_id = 118;

-- 1. 기존 유니크 제약 조건 삭제
ALTER TABLE appr_form DROP CONSTRAINT UQ_APPR_FORM_COM_CODE;

-- 2. 버전(for_version)을 포함한 복합 유니크 제약 조건 재생성
ALTER TABLE appr_form ADD CONSTRAINT UQ_APPR_FORM_COM_CODE UNIQUE (com_id, for_code, for_version);

alter table appr_form add for_schema clob;

select
			l.lin_id,
			l.doc_id,
			l.emp_id,
			l.lin_order,
			l.lin_status,
            l.lin_approved,
			e.emp_name,
			p.pos_name
		from
			appr_line l
		join
			employee e on e.emp_id = l.emp_id
		join
		 	emp_position p on p.pos_id = e.pos_id
		where
			l.doc_id = 122
		order by
			l.lin_order;
            
            
ALTER TABLE appr_form MODIFY for_content NULL;

ALTER TABLE appr_form ADD CONSTRAINT ck_appr_form_content_xor
CHECK (
    (for_content IS NOT NULL AND for_schema IS NULL)
    OR
    (for_content IS NULL AND for_schema IS NOT NULL)
)

