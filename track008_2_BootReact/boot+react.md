1. CSR VS SSR
- SSR : 서버가 웹페이지에 렌더링 , 초기속도가 빠름 / 서버 부하가 커지고 깜빡임
- CSR : 브라우저가 웹페이지를 렌더링 , 초기속도가 느림 / 화면바뀜이 빠름

2. 기술스택
[PROJECT]
ㄴ BACK : boot + oracle + jpa + (mybatis) + jwt + redis
ㄴ FRONT : react + next + antd

### 1. BACK
1. JAVA 17
2. SPRING BOOT (gradle)
3. security + jwt + redis + oauth2.0 + jpa + mybatis + oracle

1) spring boot - 애플리케이션 기반의 프레임워크 / 내장 tomcat이 설정되어있음 / 자동 설정
2) spring security - 인증,인가 / 필터체인의 요청 보호 / oauth2.0(외부인증)와 쉬운 연동
3) mybatis - xml로 복잡한 sql쿼리 작성
4) jwt - json web token / 토큰 기반의 인증방식
                          토큰 안에 사용자의 정보와 권한을 담아 전달,
                          서버가 세션을 직접 관리하지 않고,
                          클라이언트가 토큰을 보관
5) redis - 캐시와 세션을 관리, refresh token을 저장, 캐싱처리에 활용
           캐싱처리? -> 자주 사용하는 값을 미리 넣어놓고 요청이 있을때 서버 거치지 않고 빠르게 제공
6) jpa - sql 작성없이 객체 중심의 데이터처리 


1.  SPRING boot  → 애플리케이션 실행기반
2.  SPRING security + jwt/oauth2.0   → 인증/인가 처리
3.  redis   →  토큰/세션/캐시관리
4.  jpa + mybatis  → 데이터베이스 접근 (orm + sql mapper 병행)

##### [실습]  1. 스프링부트 프로젝트 
- [x] 1. 개발개요안내
- [x] 2. java.sun.com - JAVA 17 다운로드 - 설치
- [x] 3. SPRING BOOT   - https://spring.io/ - 다운로드 - 설치
  > 이전버젼
  https://github.com/spring-projects/spring-tools/wiki/Previous-Versions
- [x] 4. SPRING BOOT 프로젝트 만들기
- [x] 5. lombok


##### [실습]  2. docker 설치
- [x] 1. docker 설치
- https://www.docker.com/products/docker-desktop/
- 다운로드 및 설치
  1. window 업데이트
  2. USE WSL 2 instead... 체크 확인

```bash
wsl --update
```

```bash
docker --version
docker ps
```

- [x] 2. redis 설치 

```bash
docker pull  redis
docker run   -d  --name  my-redis  -p 6379:6379   redis

docker  exec  -it  my-redis  redis-cli
docker  exec  -it  my-redis  redis-cli  FLUSHALL
keys *
get  저장이름
```

```필기
docker pull  redis --> 최신버전 redis 다운로드
docker run   -d  --name  my-redis  -p 6379:6379   redis
--> 생성 및 실행 (docker run) / 백그라운드에서(-d) / 생성될 이름(--name my-redis) / 내 컴퓨터 번호로 내부 번호로 연결 (-p 6379:6379 redis)

docker  exec  -it  my-redis  redis-cli
-->  실행(exec) / i: 표준입력, t: 가상터미널
docker  exec  -it  my-redis  redis-cli  FLUSHALL
keys *
get  저장이름
```

1.  JWT  VS  세션
- 세션 : 서버 메모리에 사용자 상태를 저장 →  서버확장시 부담  
                                    (서버에서 출입명단 직접 들고 있는 것)
- JWT(Json Web Token) : 토큰 자체에 인증정보를 포함  → 확장성
                                    (사용자가 출입증을 직접 들고다니기)

2.  Access  Token vs  Refresh Token 
1) Access  Token :  짧은 기간 유효(출입증)    → api 호출 시 사용    
2) Refresh Token :  긴   기간 유효(장기체류증) →  redis 냉장고에 안전보관   

3. Redis 사용이유?
- 토큰냉장고 → 장기체류증 안전하게 보관, 필요시 꺼내 씀
- Refresh Token 중앙에서 관리
- TTL(만료 시간)로 자동 만료처리
- 로그아웃 시 즉시 삭제  

##### [실습] 3. oracle 유저셋팅

``` sql
-- cmd
-- sqlplus
-- conn system/1234

-- 유저만들기 ( 오라클 12 이상에서 기존방식으로 생성자 생성 허용)
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
CREATE USER boot identified by react;

-- 권한부여
grant connect, resource to boot;

ALTER USER boot DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;    -- 물리적공간이용
grant  create table to boot;
```

##### [실습] 4. Boot + React ver 1 ( 기본 게시판, 회원가입 )
##### [실습] 5. Boot + React + 세션/쿠키 - ver 2 (기본 게시판, 회원가입, 이미지, 해쉬태그, 좋아요, 팔로우)
entity -> resository -> service -> controller
##### [실습] 6. Boot + React + jwt + security + redis - ver 3 ( 2와 동일 )

##### [실습] 4. Boot + React ver 1 ( 기본 게시판, 회원가입 )

1. board
- [x] 1. project
- [x] 2. 부품객체 () : gradle
  ※ https://mvnrepository.com/
- [x] 3. application.yml
```
spring:
  datasource:
    url: jdbc:oracle:thin:@localhost:1521/XE      # jdbc URL 설정
    username: boot                                # 사용자 계정
    password: react                               # 계정 비밀번호
    driver-class-name: oracle.jdbc.OracleDriver   # oracle, mysql, h2

  jpa:
    hibernate:
      ddl-auto: update    # 엔티티 변경사항 db테이블 자동으로 변경사항 반영
                          # update:수정 반영, 기존 데이터 유지 / create-drop : 생성 후 삭제, 매번 초기화
                          # 배포 할때는 none ( 기본 ), validate
    properties:
      hibernate:
        format_sql: true  # 콘솔 및 로그에 출력되는 sql 들여쓰기 속성
        show_sql: true    # sql 쿼리 문장 그대로 로그에 출력

  servlet:
    multipart:
      enabled: true           # 파일 업로드 처리 기능 활성화 
      max-file-size: 10MB     # 업로드하는 최대 허용 용량
      max-request-size: 20MB  # 한번에 전송되는 총 용량

  data:
    redis:
      host: localhost   # redis 연결주소
      port: 6379        # 서버포트 
      timeout: 2000     # 서버와 연결 대기시간 

  config:
    import: 
      - optional:application-oauth.yml    # api 설정관련
      - optional:file:.env[.properties]   # .env 파일 실제 보관 키


mybatis:
  config-location: classpath:mybatis-config.xml # 전역 설정 파일
  mapper-locations: classpath:mapper/**/*.xml   # 매퍼 경로 패턴
  type-aliases-package: com.thejoa703.domain    # 도메인 설정

jwt:
  issuer: thejoa703                   # jwt 토큰 발행한 주체자
  secret: ${JWT_SECRET}               # 사용할 비밀 키 - 외부환경변수에서 불러와서 설정
  access-token-exp-seconds: 900       # 토큰 유효 시간
  refresh-token-exp-seconds: 1209600  # 토큰 유효 시간
  header: Authorization               # 토큰 전달시 http요청 헤더 이름 지정
  prefix: Bearer                      # 토큰 앞에 붙는 이름 (접두사)

file:
  upload-dir: uploads   # 업로드된 파일 설정 경로 

#server:
#  port: 8484     # 포트 번호
```
- [x] 4. entity ( 테이블을 객체로 처리 )
```
  ※ (oracle db:table) -> mapper     -> dto -> service -> controller -> view / 기존
  ※ @Entity           -> repository -> dto -> service -> controller -> view / 기존
```
  back1
    ㄴ src/main/java
      ㄴ com.thejoa703.entity
        - AppUser
        - Post


  A. JPA
    - ORM(Object-Relational Mapping)
    부품객체(자바 클래스) 와 RDB(관계형 데이터베이스)의 불일치를 해결하려고
    SQL 중심이 아니라 객체 중심으로 데이터를 다룰수 있게 해주는 기술

    1) @Entity DB의 테이블과 매핑
    - 테이블 컬럼 변경시 SQL을 일일이 수정할 필요 없이 엔티티 클래스만 수정
    - 데이터베이스 방언(Dialect) 지원 - oracle, mysql 특정 데이터에 종속

    2) JpaRepository 
    - db에 접속해서 crud 작업을 처리하는 인터페이스

    3) 외래키 설정
    - 한사람이 여러 글을 쓸수있다.
    @OneToMany
    > AppUser 입장

    @ManyToOne
    > Post 입장

- [x] 5. Repository
  back1
    ㄴ src/main/java
      ㄴ com.thejoa703.repository
        - AppUserRepository
        - PostRepository

https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

- [x] 6. Dto
  back1
    ㄴ src/main/java
      ㄴ com.thejoa703.dto
        - UserDto
        - PostDto
        
- [x] 7. Service
  back1
    ㄴ src/main/java
      ㄴ com.thejoa703.service
        - UserService
        - PostService

  1. 클래스 명   : UserService (package com.thejoa703.service;)
  메서드 명
  - createUser (회원가입 / 사용자 등록 기능)
  - getUser (사용자 단건 조회 기능)

  2. 클래스 명   : PostService
  - getAllPosts (모든 글)
  - getPostById (단건 조회)
  - getPostPaged (오라클 네이티브 페이징 조회)
  - createPost (게시글 생성)
  - updatePost (게시글 수정)
  - deletePost (게시글 삭제)
        
- [ ] 8. Controller
  back1
    ㄴ src/main/java
      ㄴ com.thejoa703.Controller
        - UserController
        - PostController

  1. User Api    - 사용자 관련 API
  - POST   /api/users      회원가입
  - GET      /api/users/{id}      사용자 단건조회

  2. Post API     - 게시글 관련 API
  - GET        /api/posts/{id}      게시글 단건 조회
  - PUT        /api/posts/{id}      게시글 수정
  - DELETE   /api/posts/{id}      게시글 삭제
  - GET        /api/posts      전체 게시글 조회
  - POST      /api/posts      게시글 작성


- [ ] 9. View

1. 회원가입
   ↓
2. 마이페이지
   ↓
3. 글쓰기
   ↓
4. 글수정   
   ↓
5. 글삭제    

front/
├── .next/                     # Next.js 빌드 결과물 (자동 생성, 배포 시 사용)
├── components/                # 재사용 가능한 UI 컴포넌트 폴더
│   └── Layout.js              # 페이지 공통 레이아웃 컴포넌트
├── node_modules/              # 설치된 npm 패키지들
├── pages/                     # Next.js 라우팅 기반 페이지 폴더
│   ├── posts/             
│   │  └──new.js               # 글쓰기 파일
│   ├── _app.js                # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── signup.js              # 회원가입
│   ├── mypage.js              # 마이페이지
│   └── index.js               # 메인 페이지
├── reducers/                  # Redux 리듀서 폴더
│   ├── __tests__/       
│   │  ├── post.test.js        # 게시판 테스트 코드 
│   │  └── user.test.js        # 리듀서 테스트 코드
│   ├── index.js               # 루트 리듀서 (combineReducers)
│   ├── authReducer.js         # 사용자 관련 리듀서
│   └── postReducer.js         # 게시판 관련 리듀서 
├── sagas/                     # Redux-Saga 폴더
│   ├── __tests__/       
│   │  ├── post.test.js        # 게시판 사가 테스트 코드
│   │  └── user.test.js        # 유저   사가 테스트 코드
│   ├── index.js               # 루트 사가
│   ├── userSaga.js            # 사용자 관련 사가
│   └── postSaga.js            # 게시판 관련 사가 
├── store/                     # Redux 스토어 설정 폴더
│   ├── configureStore.js      # Redux 스토어 설정
│   └── configureStore.test.js # 스토어 테스트 코드
├── styles/                    # CSS 스타일 폴더
│   └── globals.css            # 글로벌 스타일
├── .babelrc                   # Babel 설정 파일
├── .eslintrc                  # ESLint 설정 파일
├── package-lock.json          # npm 의존성 잠금 파일
├── package.json               # 프로젝트 메타 정보 및 의존성
└── setupTests.js              # 테스트 환경 설정 파일


Step1) 프로젝트 만들기
```
mkdir front -> cd front
npm init
```
Step2) 기본 셋팅 (store)
```
package.json 셋팅
npm install
```
Step3) reducer
Step4) saga
Step5) view
