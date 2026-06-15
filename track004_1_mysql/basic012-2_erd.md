■ 1. ERD (ENTITY RELATIONSHIP DIAGRAM)
    -> 데이터 관계간에 초점을 둔 모델

1. 개체(Entity) - 테이블
2. 속성(Attirbute) - 열, 컬럼
3. 관계(Realtionship) - 외래키

예) emp(deptno) dept(deptno) ★

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

<<개설과목(Course)>                <<수강(std_Course)>>                    <<학생(Student)>>
과목코드(course_id:prof_id)         학번(std_id)                             학번(std_id)       
과목명(course_name)                과목코드(course_id)                       성명(std_name)
교수코드(prof_id)                                                              키(height)
시작일(start_date)                                                         학과코드(dept_id)
종료일(end_date)