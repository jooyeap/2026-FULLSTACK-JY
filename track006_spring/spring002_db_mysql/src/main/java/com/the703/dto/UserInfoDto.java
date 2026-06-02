package com.the703.dto;

import lombok.Data;

@Data
public class UserInfoDto {
	private int no;
	private String email;
	private int age;
}

//+-------+--------------+------+-----+---------+----------------+
//| Field | Type         | Null | Key | Default | Extra          |
//+-------+--------------+------+-----+---------+----------------+
//| no    | int          | NO   | PRI | NULL    | auto_increment |
//| email | varchar(100) | NO   |     | NULL    |                |
//| age   | int          | YES  |     | NULL    |                |
//+-------+--------------+------+-----+---------+----------------+