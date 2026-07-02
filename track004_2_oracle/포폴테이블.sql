create sequence appr_form_seq start with 1 increment by 1;

create trigger appr_form_trg
before insert on appr_form
for each row
begin
 if :new.for_id is null then
  select appr_form_seq.nextval into :new.for_id from dual;
 end if;
end;
/

CREATE TABLE appr_form (
  for_id NUMBER NOT NULL primary key,
  com_id NUMBER NOT NULL,
  for_code VARCHAR2(50) NOT NULL,
  for_title VARCHAR2(50) NOT NULL,
  for_content VARCHAR2(500) NOT NULL,
  for_status number(3) NOT NULL,
  created_at DATE default sysdate NOT NULL,
  updated_at DATE default sysdate NOT NULL,
  CONSTRAINT fk_appr_form_company1
    FOREIGN KEY (com_id)
    REFERENCES company (com_id),
  constraint chk_appr_form_status check (for_status in (0,1))
);

create index fk_appr_form_company1_idx on appr_form (com_id);

create sequence appr_doc_seq start with 1 increment by 1;

create trigger appr_doc_trg
before insert on appr_doc
for each row
begin
 if :new.doc_id is null then
  select appr_doc_seq.nextval into :new.doc_id from dual;
 end if;
end;
/

CREATE TABLE appr_doc (
  doc_id NUMBER NOT NULL primary key,
  emp_id NUMBER NOT NULL,
  for_id NUMBER NOT NULL,
  com_id NUMBER NOT NULL,
  doc_title VARCHAR2(100) NOT NULL,
  doc_content VARCHAR2(1000) NOT NULL,
  doc_status VARCHAR2(20) DEFAULT 'WAI' NOT NULL,
  created_at DATE default sysdate NOT NULL,
  updated_at DATE default sysdate NOT NULL,
  CONSTRAINT fk_appr_doc_appr_form1
    FOREIGN KEY (for_id)
    REFERENCES appr_form (for_id),
  CONSTRAINT fk_appr_doc_company1
    FOREIGN KEY (com_id)
    REFERENCES company (com_id),
  CONSTRAINT fk_appr_doc_employee1
    FOREIGN KEY (emp_id)
    REFERENCES employee (emp_id)
);

create index fk_appr_doc_appr_form1_idx on appr_doc(for_id);
create index fk_appr_doc_company1_idx on appr_doc(com_id);
create index fk_appr_doc_employee1_id on appr_doc(emp_id);

create sequence appr_line_seq start with 1 increment by 1;

create trigger appr_line_trg
before insert on appr_line
for each row
begin
 if :new.lin_id is null then
  select appr_lin_seq.nextval into :new.lin_id from dual;
 end if;
end;
/

CREATE TABLE appr_line (
  lin_id NUMBER NOT NULL primary key,
  doc_id NUMBER NOT NULL,
  emp_id NUMBER NOT NULL,
  lin_order NUMBER NOT NULL,
  lin_status VARCHAR2(20) NOT NULL,
  lin_approved DATE NULL,
  is_current char(1) default 'N' not null,
  CONSTRAINT fk_appr_line_appr_doc1
    FOREIGN KEY (doc_id)
    REFERENCES appr_doc (doc_id),
  CONSTRAINT fk_appr_line_employee1
    FOREIGN KEY (emp_id)
    REFERENCES employee (emp_id)
);

create index fk_appr_line_appr_doc1_idx on appr_line(doc_id);
create index fk_appr_line_employee1_idx on appr_line(emp_id);