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

select * from appr_form where com_id = 1;

alter table appr_form modify (for_content null);
update appr_doc set doc_status = 'REJ' where doc_status = 'CAN';

 -- 기존 CHECK 제약 삭제
alter table evaluation_period drop constraint ck_period_status;

-- 새 CHECK 제약 (REPORTING, REPORTING_FAILED 추가)
alter table evaluation_period 
    add constraint ck_period_status 
    check (period_status in ('READY', 'OPEN', 'CLOSED', 'REPORTING', 'REPORTING_FAILED', 'REPORTED'));

-- 새 제약 확인이 필요하면
select constraint_name, search_condition
  from user_constraints
 where table_name = 'EVALUATION_PERIOD'
   and constraint_type = 'C'; 

--사원
update employee set emp_pass='$2b$10$zaOMPKyTkWmzevgUykuqtut57S3Py02TWhUo1JIXs1np4y2ihE5YW' where emp_id = 218;
--주임
update employee set emp_pass='$2b$10$zaOMPKyTkWmzevgUykuqtut57S3Py02TWhUo1JIXs1np4y2ihE5YW' where emp_id = 55;
--대리
update employee set emp_pass='$2b$10$zaOMPKyTkWmzevgUykuqtut57S3Py02TWhUo1JIXs1np4y2ihE5YW' where emp_id = 41;
--과장
update employee set emp_pass='$2b$10$zaOMPKyTkWmzevgUykuqtut57S3Py02TWhUo1JIXs1np4y2ihE5YW' where emp_id = 31;
-- 차장
update employee set emp_pass='$2b$10$zaOMPKyTkWmzevgUykuqtut57S3Py02TWhUo1JIXs1np4y2ihE5YW' where emp_id = 136;
-- 부장 a@a

select 
    e.emp_id,
    e.emp_email,
    e.emp_name,
    e.pos_id,
    e.com_id,
    d.dept_id,
    d.dept_name,
    p.pos_name
from employee e
left join emp_position p on e.pos_id = p.pos_id
left join department d on e.dept_id = d.dept_id
where e.com_id = 1 and d.dept_id = 1;

commit;

select * from appr_doc where com_id = 1;
desc appr_line;


select * from appr_form where com_id = 1;
select * from appr_doc where com_id = 1;
-- 1086테스트3 1087테스트1 1088테스트2 1089
select * from appr_line where doc_id = 1086;

-- 버전 확인용 양식
insert into appr_form (for_id, com_id, for_code, for_title, for_schema, for_status, is_deleted, for_version)
values (99998, 1, '양식버전테스트용', '버전테스트용', '{
	"title": "휴가 신청서",
	"fields": [
		{
			"key": "employee_name",
			"label": "신청자 이름",
			"type": "text",
			"required": true
		},
		{
			"key": "department",
			"label": "부서",
			"type": "text",
			"required": true
		},
		{
			"key": "start_date",
			"label": "휴가 시작 일자",
			"type": "date",
			"required": true
		},
		{
			"key": "end_date",
			"label": "휴가 종료 일자",
			"type": "date",
			"required": true
		},
		{
			"key": "leave_type",
			"label": "휴가 종류",
			"type": "select",
			"required": true,
			"options": ["연차", "병가", "경조사", "기타"]
		},
		{
			"key": "reason",
			"label": "신청 사유",
			"type": "textarea",
			"required": true
		}
	]
}',1,0,1);

-- 일반 양식
insert into appr_form (for_id, com_id, for_code, for_title, for_content, for_status, is_deleted, for_version)
values (99999, 1, '일반문서테스트용', '일반문서', '
		<div class="appr-table-wrap">
			<table class="appr-table">
				<tbody>
					<tr>
						<th colspan="4" style="font-size: 20px; padding: 15px; background-color: #e9ecef;">휴 가 신 청 서</th>
					</tr>
					<tr>
						<td class="appr-title-cell">휴가 종류</td>
						<td>(연차 / 오전반차 / 오후반차 / 공가 / 병가) 중 기입</td>
						<td class="appr-title-cell">비상 연락처</td>
						<td>010-</td>
					</tr>
					<tr>
						<td class="appr-title-cell">기간</td>
						<td colspan="3">2026년 __월 __일 ~ 2026년 __월 __일 (총 __일간)</td>
					</tr>
					<tr>
						<td class="appr-title-cell">휴가 사유</td>
						<td colspan="3" style="height: 150px; vertical-align: top;">
							<p>※ 구체적인 휴가 사유를 입력해 주세요.</p>
						</td>
					</tr>
					<tr>
						<td colspan="4" style="text-align: center; color: #666; font-size: 12px; background-color: #fafafa;">
							위와 같이 휴가를 신청하오니 승인하여 주시기 바랍니다.
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		'
        ,1,0,1);
        
-- 결재 문서 (테스트 2)
insert into appr_doc (doc_id, emp_id, for_id, com_id, doc_title, doc_content, doc_status, is_important, doc_revision, for_version)
values(3333, 218, 99998, 1, '테스트2','<div class="appr-table-wrap">
					<table class="appr-table">
						<tbody>
							<tr><th>신청자 이름</th><td>test</td></tr><tr><th>부서</th><td>test</td></tr><tr><th>휴가 시작 일자</th><td>2026-07-20</td></tr><tr><th>휴가 종료 일자</th><td>2026-07-25</td></tr><tr><th>휴가 종류</th><td>기타</td></tr><tr><th>신청 사유</th><td>test</td></tr>
						</tbody>
					</table>
				</div>','ING',0,1,1);

-- 결재 문서 (테스트 3) 
insert into appr_doc (doc_id, emp_id, for_id, com_id, doc_title, doc_content, doc_status, is_important, doc_revision, for_version)
values(3334, 218, 99999, 1, '테스트3', '
		<div class="appr-table-wrap">
			<table class="appr-table">
				<tbody>
					<tr>
						<th colspan="4" style="font-size: 20px; padding: 15px; background-color: #e9ecef;">휴 가 신 청 서</th>
					</tr>
					<tr>
						<td class="appr-title-cell">휴가 종류</td>
						<td>(연차 / 오전반차 / 오후반차 / 공가 / 병가) 중 기입</td>
						<td class="appr-title-cell">비상 연락처</td>
						<td>010-</td>
					</tr>
					<tr>
						<td class="appr-title-cell">기간</td>
						<td colspan="3">2026년 __월 __일 ~ 2026년 __월 __일 (총 __일간)</td>
					</tr>
					<tr>
						<td class="appr-title-cell">휴가 사유</td>
						<td colspan="3" style="height: 150px; vertical-align: top;">
							<p>※ 구체적인 휴가 사유를 입력해 주세요.</p>
						</td>
					</tr>
					<tr>
						<td colspan="4" style="text-align: center; color: #666; font-size: 12px; background-color: #fafafa;">
							위와 같이 휴가를 신청하오니 승인하여 주시기 바랍니다.
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		','ING',0,1,1);

-- 결재 문서 (테스트 버전)
insert into appr_doc (doc_id, emp_id, for_id, com_id, doc_title, doc_content, doc_status, is_important, doc_revision, for_version)
values(3332, 218,

-- 결재선 (테스트 2)
insert into appr_line (lin_id, doc_id, emp_id, lin_order, lin_status) values (appr_line_seq.nextval, 3333,55,1,'APP');
insert into appr_line (lin_id, doc_id, emp_id, lin_order, lin_status) values (appr_line_seq.nextval, 3333,41,2,'APP');
insert into appr_line (lin_id, doc_id, emp_id, lin_order, lin_status) values (appr_line_seq.nextval, 3333,1,3,'WAI');

-- 결재선 (테스트 3)
insert into appr_line (lin_id, doc_id, emp_id, lin_order, lin_status) values (appr_line_seq.nextval, 3334,1,1,'WAI');

-- 테스트 이후 데이터 삭제
-- delete from appr_line where doc_id in (3332,3333,3334);
-- delete from appr_doc where doc_id in (3332,3333,3334);
select * from appr_form where com_id = 1;
select * from appr_doc where com_id = 1;
select * from appr_doc where for_id = 1031;
select * from appr_line where doc_id = 1093;
delete from appr_form where for_code = '양식버전테스트용';
delete from appr_doc where for_id = 1031;
delete from appr_line where doc_id = 1093;
        
commit;