Q1)
mysql> desc coffee;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| cno    | int         | NO   | PRI | NULL    | auto_increment |
| cname  | varchar(50) | NO   |     | NULL    |                |
| cprice | int         | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+

create table coffee(
    cno int not null primary key auto_increment,
    cname varchar(50) not null,
    cprice int not null
);

Q2)
mysql> desc milk;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| mno    | int         | NO   | PRI | NULL    | auto_increment |
| mname  | varchar(50) | NO   |     | NULL    |                |
| mprice | int         | NO   |     | NULL    |                |
| mnum   | int         | NO   |     | NULL    |                |
| mtotal | int         | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+

create table milk(
    mno int not null primary key auto_increment,
    mname varchar(50) not null,
    mprice int not null,
    mnum int not null,
    mtotal int not null
);

Q3)
mysql> desc score;
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| sno      | int         | NO   | PRI | NULL    | auto_increment |
| sname    | varchar(20) | NO   |     | NULL    |                |
| sjava    | int         | NO   |     | NULL    |                |
| sjsp     | int         | NO   |     | NULL    |                |
| sspring  | int         | NO   |     | NULL    |                |
| sproject | int         | NO   |     | NULL    |                |
| sstotal  | int         | YES  |     | NULL    |                |
| ssavg    | int         | YES  |     | NULL    |                |
| semail   | varchar(50) | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+

create table score(
    sno int not null primary key auto_increment,
    sname varchar(20) not null,
    sjava int not null,
    sjsp int not null,
    sspring int not null,
    sproject int not null,
    sstotal int,
    ssavg int,
    semail varchar(50)
);

Q4)
mysql> desc emp;
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| empno    | int         | NO   | PRI | NULL    | auto_increment |
| ename    | varchar(20) | YES  |     | NULL    |                |
| job      | varchar(20) | YES  |     | NULL    |                |
| mgr      | varchar(20) | YES  |     | NULL    |                |
| hiredate | date        | YES  |     | NULL    |                |
| sal      | int         | YES  |     | NULL    |                |
| comm     | int         | YES  |     | NULL    |                |
| deptno   | int         | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+

create table emp(
    empno int not null primary key auto_increment,
    ename varchar(20),
    job varchar(20),
    mgr varchar(20),
    hiredate date,
    sal int,
    comm int,
    deptno int
);

Q5)
mysql> desc dept;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| deptno | int         | NO   | PRI | NULL    | auto_increment |
| dname  | varchar(20) | NO   |     | NULL    |                |
| loc    | varchar(20) | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+

create table dept(
    deptno int not null primary key auto_increment,
    dname varchar(20) not null,
    loc varchar(20) not null
);

Q6)
mysql> desc salagrade;
+-------+------+------+-----+---------+----------------+
| Field | Type | Null | Key | Default | Extra          |
+-------+------+------+-----+---------+----------------+
| grade | int  | NO   | PRI | NULL    | auto_increment |
| losal | int  | YES  |     | NULL    |                |
| hisal | int  | YES  |     | NULL    |                |
+-------+------+------+-----+---------+----------------+

create table salagrade(
    grade int not null primary key auto_increment,
    losal int,
    hisal int
);