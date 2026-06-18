use sb_erp_db;
desc company;
show databases;
show tables;

desc company;
desc appr_form;
desc appr_doc;
desc appr_line;

alter table appr_form change `for_status (boolean)` for_status boolean not null;

select * from company;
select * from department;

select * from appr_form;
SHOW VARIABLES LIKE 'char%';
SHOW VARIABLES LIKE 'collation%';
SHOW VARIABLES LIKE 'character_set%';

show create table appr_form;

delete from appr_form where for_id > 0;

insert into (com_id, for_code, for_title, for_)



