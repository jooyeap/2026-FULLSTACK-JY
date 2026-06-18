■ 1. ERD (ENTITY RELATIONSHIP DIAGRAM)
    -> 데이터 관계간에 초점을 둔 모델

1. 개체(Entity) - 테이블
2. 속성(Attirbute) - 열, 컬럼
3. 관계(Realtionship) - 외래키

예) dept(deptno) ─┼---∈ emp(deptno) ★
    DEPTNO : PK         EMPNO : PK
                        DEPTNO : FK

풀이 1) dept와 emp는 1 : 다
    - 한 부서는 여러명의 사원이 소속 
풀이 2) 부모 테이블 : dept / 자식 테이블 : emp
    - dept(부서) 테이블이 존재 해야, 사원(emp)을 해당 부서에 배치할수 있음
풀이 3) 점선 (비식별 관계), dept 테이블의 PK 를 fk로 사용

■ 2. ~ 구성되어 있다

ex1) 하나의 A 는 하나의 B로 구성되어 있다
[홍길동] ─┼───────┼─ [주민증]

ex2) 하나의 A 는 여러개의 B로 구성되어 있다
한명의 학생은 여러개의 수강내역을 가진다
[홍길동] ─┼───────∈ [JAVA, JSP, SPRING, MYSQL]

■ 3. 점선 VS 실선
실선 : 부모 테이블의 기본키를 자식 테이블의 기본키로 사용
점선 : 부모 테이블의 기본키를 자식 테이블의 기본키로 사용 안 한 경우

1 : 1 / 1 : 다 / 다 : 다

- 학과 와 학생 -> 1 : 다
    - 학과는 많은 학생을 가질 수 있다.
    - 학생은 한 학과에 소속 된다.

- 학과 와 교수 -> 1 : 다
    - 학과는 많은 교수를 가질 수 있다.
    - 교수는 한 학과에 소속 된다.

- 교수 와 개설과목 -> 1 : 다
    - 교수는 많은 과목을 가질 수 있다
    - 과목은 강의하는 교수 한명이 지정된다.

- 개설과목 과 학생 -> 다 : 다
    - 과목은 수강하는 많은 학생을 가진다.
    - 학생은 많은 과목을 수강한다.


<<테이블>>
    학생(Student)
        학번(std_id), 성명(std_name), 키(height), 학과코드(dept_id)

    학과(Department)
        학과코드(dept_id), 학과명(dept_name)

    교수(Professor)
        교수코드(prof_id), 교수명(prof_name), 학과코드(dept_id)

    개설과목(Course)
        과목코드(course_id), 과목명(course_name), 교수코드(prof_id),
        시작일(start_date), 종료일(end_date)

    수강(std_Course)
        학번(std_id), 과목코드(course_id)


ex1)   학과와 학생은  

<< 학과(Department)>> ─┼------∈ <<학생(Student)>>
학과코드(dept_id:pk)              학번(std_id:pk) 
학과명(dept_name)                 성명(std_name)   
                                  키(height)   
                              학과코드(dept_id:☆fk)

풀이1) 학과와 학생은 1 : 다
풀이2) 부모 테이블 : 학과 / 자식 테이블 : 학생 
풀이3) 점선

ex2) 학과와 교수 -> 1:다

<<학과>>     ─┼------∈        <<교수>>
학과코드(dept_id:pk)        교수코드(prof_id:pk)
학과명(dept_name)          교수명(prof_name)
                          학과코드(dept_id:fk)

풀이1) 학과와 교수는 1 : 다
풀이2) 부모 테이블 : 학과 / 자식 테이블 : 교수
풀이3) 점선

ex3) 교수와 개설과목 -> 1 : 다

<<교수>>     ─┼------∈      <<개설과목>>
교수코드(prof_id:pk)      과목코드(course_id:pk)
교수명(prof_name)         과목명(course_name)
학과코드(dept_id:fk)       교수코드(prof_id:fk)
                         시작일(start_date)
                          종료일(end_date)

풀이1) 교수와 개설과목은 -> 1 : 다
풀이2) 부모 테이블 : 교수 / 자식 테이블 : 개설과목
풀이3) 점선

ex4) 과목과 학생 -> 다 : 다

<<개설과목(Course)> ─┼──────────∈ <<수강(std_Course)>> ∋──────────┼─ <<학생(Student)>>
과목코드(course_id:prof_id:pk)         학번(std_id:pk)                 학번(std_id:pk)       
과목명(course_name)                과목코드(course_id:pk)              성명(std_name)
교수코드(prof_id:fk)                                                    키(height)
시작일(start_date)                                                  학과코드(dept_id:fk)
종료일(end_date)

풀이1) 과목과 학생 -> 다 : 다
풀이2) 부모 테이블 : 개설 과목, 학생 / 자식 테이블 : 수강
풀이3) 실선 (부모테이블의 PK 가 자식테이블의 PK 일때) / 점선 (부모테이블의 PK 가 자식테이블의 FK 일때)

■3.FOREIGN KEY
    => 외래키(참조키)
    => 다른테이블의 기본키를 참조하는 키
    => 중복가능 / NULL 허용함
    => 참조되고있는테이블의 데이터 값 이외의 값은 삽입할수 없음.
    => insert할때 잘못된 데이터 삽입이 안되록하는 것
    => 레코드 삭제나 테이블삭제를 할때는 반드시 FOREIGN KEY가
       지정된 레코드나 테이블을 삭제한후에 참조대상을 삭제할수 있다.


    방법
       [ CONSTRAINT 별칭 ] REFERENCES 테이블이름(필드명)

(1) 부모 테이블 t1
create table t1(
    no int not null primary key auto_increment,
    name varchar(100)
);

(2) 자식 테이블 t2
create table t2(
    ino int not null primary key,
    foreigen key (ino) references t1(no)
); -- 외래키 (ino) 참고 테이블 t1(no필드)

(3) t1에서 no는 1, 2

(4) 다음에서 오류나는 코드는?
    insert into t2 (ino) values (1);
    insert into t2 (ino) values (3);
    -> t1에 no가 3인 필드가 없기때문에 오류발생 / 부모에게 없는값 입력 불가능


(5) 부모테이블 t3
create table t3 (
    no int not null auto_increment primary key, name varchar(100)
);

(6) 부모테이블 t4
create table t4(
    ino int not null primary key,
    foreign key (ino) references t3(no) on delete cascade on update cascade
);

(7)
    insert into t3(no, name) values (1, 'first');
    insert into t3(no, name) values (2, 'second');
    insert into t4(ino) values (2);
    insert into t4(ino) values (2);

(8) 부모 수정시 자식값들도 수정, 부모삭제시 자식 값들도 삭제 확인
    update t3 set no=20 where no=2;
    delete from t3 where no=20;