create sequence appr_seq;

CREATE TABLE IF NOT EXISTS "appr_form" (
  for_id NUMBER NOT NULL,
  com_id NUMBER NOT NULL,
  for_code VARCHAR(50) NOT NULL,
  for_title VARCHAR(50) NOT NULL,
  for_content VARCHAR(500) NOT NULL,
  for_status TINYINT NOT NULL,
  for_created DATE NOT NULL,
  for_updated DATE NOT NULL,
  PRIMARY KEY (for_id),
 -- INDEX "fk_appr_form_company1_idx" ("com_id" ASC) VISIBLE,
  CONSTRAINT fk_appr_form_company1
    FOREIGN KEY (com_id)
    REFERENCES company (com_id)
    ON DELETE NO ACTION
);


CREATE TABLE IF NOT EXISTS `sb_erp_db`.`appr_doc` (
  `doc_id` NUMBER NOT NULL AUTO_INCREMENT,
  `emp_id` NUMBER NOT NULL,
  `for_id` NUMBER NOT NULL,
  `com_id` NUMBER NOT NULL,
  `doc_title` VARCHAR(100) NOT NULL,
  `doc_content` VARCHAR(1000) NOT NULL,
  `doc_status` VARCHAR(20) NOT NULL DEFAULT 'WAI',
  `doc_created` DATE NOT NULL,
  `doc_updated` DATE NOT NULL,
  PRIMARY KEY (`doc_id`),
  INDEX `fk_appr_doc_appr_form1_idx` (`for_id` ASC) VISIBLE,    
  INDEX `fk_appr_doc_company1_idx` (`com_id` ASC) VISIBLE,
  INDEX `fk_appr_doc_employee1_idx` (`emp_id` ASC) VISIBLE,
  CONSTRAINT `fk_appr_doc_appr_form1`
    FOREIGN KEY (`for_id`)
    REFERENCES `sb_erp_db`.`appr_form` (`for_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appr_doc_company1`
    FOREIGN KEY (`com_id`)
    REFERENCES `sb_erp_db`.`company` (`com_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appr_doc_employee1`
    FOREIGN KEY (`emp_id`)
    REFERENCES `sb_erp_db`.`employee` (`emp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE TABLE IF NOT EXISTS `sb_erp_db`.`appr_line` (
  `lin_id` NUMBER NOT NULL,
  `doc_id` NUMBER NOT NULL,
  `emp_id` NUMBER NOT NULL,
  `lin_order` NUMBER NOT NULL,
  `lin_status` VARCHAR(20) NOT NULL,
  `lin_approved` DATE NULL,
  PRIMARY KEY (`lin_id`),
  INDEX `fk_appr_line_appr_doc1_idx` (`doc_id` ASC) VISIBLE,
  INDEX `fk_appr_line_employee1_idx` (`emp_id` ASC) VISIBLE,
  CONSTRAINT `fk_appr_line_appr_doc1`
    FOREIGN KEY (`doc_id`)
    REFERENCES `sb_erp_db`.`appr_doc` (`doc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appr_line_employee1`
    FOREIGN KEY (`emp_id`)
    REFERENCES `sb_erp_db`.`employee` (`emp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;