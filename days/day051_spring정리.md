###  Spring
■ 기술스택 : spring + mysql  + mybatis  + security + jsp/jstl + ajax

- [ ] 1. project 만들기
    1. dynamic web project - project2
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path

- [ ] 2. pom.xml
    - 부품객체 다운로드 - 
    ```
- [ ] 3. web.xml

- [ ] 4. confing  
    1. root-context.xml
    2. servlet-context.xml
    3. security-context.xml

- [ ] 5. 각종설정파일
    1. root-context.xml 관련
        - config/db.properties -> db 설정
        - config/mybatis-config.xml -> sql구문 설정
        - config/test-mapper.xml
        - com.the703.dao.Mapper
        
        - resources/log4j2.properties
            - 보안관련 로그, 로그기록 분석
            - 어떻게 더 효율적으로 관리관련 고민
        - resources/log4jdbc.log4j2.properties
    
    2. servlet-context.xml 관련
    !1) 확장자 거르기 (png, jpg)
    !2) 글삭제시 이미지도 삭제되게

    3. security-context.xml

- [ ] 6. 부품테스트
    0. context, ds, sqlsession
    1. test-mapper.xml / TestMapper.java 인터페이스
    select now()

- [ ] 7. 개발 - Model
    0) 테이블
    1) boardDto - com.the703.dto / mybatis.config.xml
    2) BoardMapper , board-mapper.xml - root-context.xml
    3) BoardService, BoardServiceImpl

- [ ] 8. 개발 - Controller
    4) BoardController - Service 사용 - security-context.xml (허용)

- [ ] 9. 개발 - View
    5) [view] - [board] - csrf

 