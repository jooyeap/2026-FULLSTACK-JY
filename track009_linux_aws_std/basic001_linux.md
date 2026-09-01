## CI/CD

1. CI (Continuous Integration, 지속적 통합)
- 개발자들이 작성한 코드를 정기적으로 중앙 저장소에 병합하고
  자동으로 빌드 및 테스트 하는 과정
2. CD (Continuous Delivery / Continuous Deployment, 지속적 전달 및 배포)
- CI과정을 거친 코드를 프로덕션(실 서비스)환경에 배포할수 있도록 준비, 배포 단계

## Part001. Linux
### 진행사항
1. Ubuntu 24.04 컨테이너 실행 방법
2. linux 사용자
3. 기본명령어
4. 파일
5. 유저
6. job + 쉘스크립트

#### 1. Ubuntu 컨테이너 실행
- 도커 : 컨테이너 기반의 가상화 플랫폼

1. 이미지 다운로드 (pull)
```bash
docker pull ubuntu:24.04
```

2. 컨테이너 실행 (run)
```bash
docker run -it --name myubuntu ubuntu:24.04 bash 
```

1) -it : -i(표준입력 Interactive), -t(터미널 Pseudo-TTY)
2) --name myubuntu : 컨테이너 이름 지정
3) ubuntu:24.04 : 이미지 이름 및 태그(버전)
4) bash : 컨테이너 내부에서 실행할 쉘 전달 및 배포)

3. 컨테이너 내부에서 패키지업데이트 및 필수 패키지 일괄설치
※ 도커 컨테이너 환경에서 설치가 중간에 멈추는 것을 방지하는 핵심 설정
```bash
apt update && apt upgrade -y && DEBIAN_FRONTEND=noninteractive apt install -y vim man-db net-tools iproute2 adduser sudo
```

1) apt update: 설치 가능한 패키지 목록을 최신 상태로 업데이트합니다.
2) &&: 앞의 명령어가 성공적으로 끝나면 뒤의 명령어를 연속해서 실행합니다.
3) apt upgrade -y: 설치되어 있는 모든 프로그램을 최신 버전으로 업그레이드합니다. (-y는 확인 질문에 자동으로 Yes 응답)
4) DEBIAN_FRONTEND=noninteractive: 패키지 설치 중 대국민 설문 형태(시간대 설정 등)의 키보드 입력을 요구하는 팝업 창을 띄우지 않고 기본값으로 자동 진행하게 만듭니다. (도커 컨테이너 환경에서 설치가 중간에 멈추는 것을 방지하는 핵심 설정)
4) apt install -y ...: 지정한 패키지들을 자동으로 설치합니다.

4. 컨테이너 종료 후 다시 실행 (ps 상태확인 / start 실행)
```bash
docker ps -a
```
```bash
docker start -ai myubuntu
```
-a : 터미널 실시간 화면 보이기
-i : 키보드 입력 (표준입력)

## ■정리 1) docker (prps)
1) 이미지 다운로드 - docker pull
2) 이미지 컨테이너 만들고 실행 - docker run
3) 도커확인 - docker ps
4) 다시실행 - docker start

#### 2. linux 사용자

1. # : root 사용자 ( 최고 관리자 )

2. $ : 일반 사용자 ( 일반 계정 사용자 )
       ※ AWS EC2에서 sudo 명령을 붙여서 실행

#### 3. 기본명령어

```bash
#1. 날짜 확인
date

#2. 출력
echo hello

#3. 명령어 위치확인
which date

#4. 명령어 설명서 (메뉴얼)
man date
```

```bash
#man 명령어가 작동하지 않거나 최소화된 메뉴얼 복원

# 패키지 최신상태
apt update

# 설치 , 조회도구(man-db), 기본명령어 메뉴얼(manpages) 
apt install -y man-db manpages

# 자동으로 yes 처리, 일반 문서 상태
yes | unminimize
```

```bash
man date
# 방향키 위, 아래 , q

date
date "+%Y-%m-%d"
```

Q1. hi 출력
-> echo hi
Q2. man 이용해서 echo확인
-> man echo

## ■정리 2) 기본
1) 날짜 date
2) 출력 echo
3) 위치 witch
4) 메뉴얼 man

#### 4. 파일

1) 파일 및 디렉토리 생성 및 삭제
```bash
# 디렉토리(폴더) 만들기
mkdir 디렉토리명
# 중간 디렉토리(폴더) 생성
mkdir -p 경로/하위경로
# 빈 파일 생성
touch 파일명 
# 파일 삭제
rm 파일명
# 안에있는 디렉토리(폴더) 삭제
rm -r 디렉토리명
# 빈 파일 생성
touch 파일명
```

2) 파일 확인 및 경로이동
```bash
# 상세 목록
ls -al
# 현재 경로
pwd
# 디렉토리 이동
cd 디렉토리명
# 상위 디렉토리 이동
cd ..
```

```bash
root@4d9326b8b3fa:/# pwd
/
root@4d9326b8b3fa:/# ls
root@4d9326b8b3fa:/# ls -al
root@4d9326b8b3fa:/# cd ~
root@4d9326b8b3fa:~# pwd
/root
root@4d9326b8b3fa:~# mkdir basic1
root@4d9326b8b3fa:~# ls
basic1
root@4d9326b8b3fa:~# ls -al
total 24
drwx------ 1 root root 4096 Sep  1 02:17 .
drwxr-xr-x 1 root root 4096 Sep  1 01:07 ..
-rw------- 1 root root  126 Sep  1 01:09 .bash_history
-rw-r--r-- 1 root root 3106 Apr 22  2024 .bashrc
-rw-r--r-- 1 root root  161 Apr 22  2024 .profile   
drwxr-xr-x 2 root root 4096 Sep  1 02:17 basic1
# 경로 폴더 없을시 오류남
root@4d9326b8b3fa:~# mkdir basic2/a/b/c
mkdir: cannot create directory 'basic2/a/b/c': No such file or directory
# -p 로 하위, 중간 경로도 같이 생성
root@4d9326b8b3fa:~# mkdir -p basic2/a/b/c
root@4d9326b8b3fa:~# ls
basic1  basic2
root@4d9326b8b3fa:~# ls -al
total 28
drwx------ 1 root root 4096 Sep  1 02:19 .
drwxr-xr-x 1 root root 4096 Sep  1 01:07 ..
-rw------- 1 root root  126 Sep  1 01:09 .bash_history
-rw-r--r-- 1 root root 3106 Apr 22  2024 .bashrc
-rw-r--r-- 1 root root  161 Apr 22  2024 .profile
drwxr-xr-x 2 root root 4096 Sep  1 02:17 basic1
drwxr-xr-x 3 root root 4096 Sep  1 02:19 basic2
root@4d9326b8b3fa:~# cd basic2
root@4d9326b8b3fa:~/basic2# ls
a
root@4d9326b8b3fa:~/basic2# cd a
root@4d9326b8b3fa:~/basic2/a# ls
b
root@4d9326b8b3fa:~/basic2/a# cd b
root@4d9326b8b3fa:~/basic2/a/b# ls
c
root@4d9326b8b3fa:~/basic2/a/b# cd c
root@4d9326b8b3fa:~/basic2/a/b/c# ls

root@4d9326b8b3fa:~# ls
basic1  basic2
# 디렉토리내 다른 디렉터리가있으면 삭제 불가능
root@4d9326b8b3fa:~# rm basic2
rm: cannot remove 'basic2': Is a directory
# -r 로 하위폴더까지 강제 삭제
root@4d9326b8b3fa:~# rm -r basic2
root@4d9326b8b3fa:~# ls
basic1
```

```bash
# Q1. test 폴더만들기
root@4d9326b8b3fa:~# mkdir test
# Q2. 폴더안에  test1.txt 파일만들기
root@4d9326b8b3fa:~# cd test
root@4d9326b8b3fa:~/test# touch test1.txt
# Q3. 파일확인 - 디렉토리인지, 폴더인지까지 구분
root@4d9326b8b3fa:~/test# ls -al
total 8
drwxr-xr-x 2 root root 4096 Sep  1 02:46 .
drwx------ 1 root root 4096 Sep  1 02:46 ..
-rw-r--r-- 1 root root    0 Sep  1 02:46 test1.txt
```

3) 파일 쓰기 > (덮어쓰기) , >> (이어쓰기)
```bash
# 파일 작성 (덮어쓰기)
echo "first" > file1.txt
# 파일 보기
cat file1.txt
# 파일 작성 (덮어쓰기)
echo "hi" > file1.txt
# 파일 작성 (이어쓰기)
echo "abc" >> file1.txt
```

```bash
root@4d9326b8b3fa:~/basic1# touch file1.txt
root@4d9326b8b3fa:~/basic1# echo "first" > file1.txt
root@4d9326b8b3fa:~/basic1# cat file1.txt
first
root@4d9326b8b3fa:~/basic1# echo "hi" > file1.txt
root@4d9326b8b3fa:~/basic1# cat file1.txt
hi
root@4d9326b8b3fa:~/basic1# echo "abc" >> file1.txt
root@4d9326b8b3fa:~/basic1# cat file1.txt
hi
abc
```

```bash
# Q1. test폴더로 이동
root@4d9326b8b3fa:~/basic1# cd ~
root@4d9326b8b3fa:~# cd test
root@4d9326b8b3fa:~/test# touch test1.txt
# Q2. test1.txt 파일에 apple 글쓰기
root@4d9326b8b3fa:~/test# echo "apple" > test1.txt
# Q3. test1.txt 파일에 banana, coconut 이어서 쓰기
root@4d9326b8b3fa:~/test# echo "banana, coconut" >> test1.txt
root@4d9326b8b3fa:~/test# cat test1.txt
apple
banana, coconut
```

4) 복사
```bash
# 복사하기
cp [원본파일] [이동할 폴더]
# 이동
mv [원본파일] [이동할 폴더]
mv test/test1.txt basic1/fruits.txt
```

```bash
root@4d9326b8b3fa:~# mv test/test1.txt basic1/fruits.txt
root@4d9326b8b3fa:~# cd basic1
root@4d9326b8b3fa:~/basic1# ls
file1.txt  fruits.txt
root@4d9326b8b3fa:~/basic1# cat fruits.txt
apple
banana, coconut
```

```bash
# Q1. basic 폴더의 fruits.txt 파일을 복사해서
# Q2. test 폴더의 eat.txt 파일명으로 옮기기
root@4d9326b8b3fa:~# cp basic1/fruits.txt test/eat.txt
root@4d9326b8b3fa:~# cd test
root@4d9326b8b3fa:~/test# ls
eat.txt
```

5) vi 에디터
```bash
# 1. sudo vi file1.txt 실행  
root@4d9326b8b3fa:~/basic1# sudo vi file1.txt
# 2. vi 안에서 Esc 눌러 명령 모드로 전환   
# 3. [i] 눌러 입력 모드로 전환 → 새 설정 붙여넣기 , 편집
# 4. [Esc] → :wq! → 저장 후 종료   
```

```bash
root@4d9326b8b3fa:~/basic1# cd ~
root@4d9326b8b3fa:~# cd test
# Q1.  test 폴더안에  num.txt 파일만들기
root@4d9326b8b3fa:~/test# touch num.txt
root@4d9326b8b3fa:~/test# ls
eat.txt  num.txt
# Q2.  num.txt vi에디터이용해서
# one-1
# two-2
# three-3 
root@4d9326b8b3fa:~/test# sudo vi num.txt
# Q3. 파일확인
root@4d9326b8b3fa:~/test# cat num.txt
one-1
two-2
three-3
root@4d9326b8b3fa:~/test#
```

> 정리문제
Q1. 파일만들기   mylinux.txt
Q2. 파일안에 답채우기  예)
echo 
man  ....
Q3. vi이용해서 맨위에 작성자본인이름 추가
Q5. mylinux.txt 백업해서 ubuntu에 backup.txt로 
Q6. 상위로 이동 testdir 삭제

Q2) 번 문제
-    출력
-    사용서
-    파일생성
-    디렉토리만들기
-    목록보기
-    상위이동
-    파일,폴더삭제
-    file1.txt 을 back.txt으로 파일복사
-    back.txt를 test.txt로 이름변경

#### 5. 유저
1. 유저 추가 및 삭제
```bash
sudo adduser one
sudo passwd 1111
sudo deluser one
```

2. 권한 구조 변경
```bash
ls -al
d               rwx                             r-x                         --- 2 sally sally 4096 Feb  3 15:04 .    
→  d 디렉토리  소유자(읽기:4/쓰기:2/실행:1)      그룹(읽기:4/쓰기:-/실행:1)     다른사람(읽기:-/쓰기:-/실행:-)
d               rwx                             r-x                         r-x 1 root  root  4096 Feb  3 14:59 ..
→  d 디렉토리  소유자(읽기:4/쓰기:2/실행:1)      그룹(읽기:4/쓰기:-/실행:1)     다른사람(읽기:-/쓰기:-/실행:-)
```

```
adduser one
New password:
Retype new password:
y

cd /home
su - one
exit

su - one
mkdir folder1
ls -al
echo date > log.txt
```

# d (폴더) 소유자 rwx 그룹 rwx 다른사람 r-x
# r (읽기) 4, w (쓰기) 2, x (실행) 1  / 4+2+1 = 7  775
mkdir folder1
drwxrwxr-x 2 one  one  4096 Sep  1 05:43 folder1

# - (파일) 소유자 rw- 그룹 rw- 다른사람 r--
# 664
echo date > log.txt
-rw-rw-r-- 1 one  one     5 Sep  1 05:51 log.txt

Q1. `two` 유저 만들기 (비번: 2222)
Q2. `two`로 로그인(`su - two`) / `two` 홈 디렉토리 찾아가기
Q3. `two`로 접속해서 `/home/one` 찾아가는 거 가능한지 확인

```bash
adduser two
su - two
cd /home
cd one
# -bash: cd: one: Permission denied
```

```bash
# root 계정에서 소유자/그룹/다른사람/ 7 rwx / 5 r-x / 5 r-x
chmod 755 /home/one
ls -al
```

Q two 다시접속, one 폴더 접속
```bash
root@4d9326b8b3fa:/home# cd ~
root@4d9326b8b3fa:~# su - two
two@4d9326b8b3fa:~$ cd /home
two@4d9326b8b3fa:/home$ cd one
two@4d9326b8b3fa:/home/one$ ls
folder1  log.txt
```

Q log.txt 파일 읽기
```bash
two@4d9326b8b3fa:/home/one$ cat log.txt
Tue Sep  1 05:53:40 UTC 2026
```

```bash
Q root계정에서 /home/one 폴더 다른사람이 못읽게처리
root@4d9326b8b3fa:~# chmod 750 /home/one
# drwxr-x--- 3 one    one    4096 Sep  1 05:58 one
two@4d9326b8b3fa:/home$ cd one
-bash: cd: one: Permission denied
```

■ 정리
1. 유저만들기 adduser
2. 권한주기 chmod 750 /home/one (rwxr-x---) 소유자 그룹 다른사람

#### 6. job + 쉘스크립트
1. 프로세스 상태확인
```bash
# e: 모든 프로세스 표시
# f: 풀포맷 자세하게 출력
ps -ef
```

2. 실시간 모니터링
```bash
top
```

3. ip주소 확인
```bash
ip a
```

4. hello world 출력 쉘스크립트 작성
```bash
vi hello.sh
root@4d9326b8b3fa:/home# vi hello.sh
#!/bin/bash
echo "Hello World"
```

```bash
ls -al
-rw-r--r-- 1 root   root     19 Sep  1 06:53 hello.sh
```

```bash
chmod +x hello.sh
-rwxr-xr-x 1 root   root     19 Sep  1 06:53 hello.sh
```

```bash
./hello.sh
root@4d9326b8b3fa:/home# ./hello.sh
Hello World
```

Q. 현재 시간출력 쉘 스크립트 작성 > date_log.sh

date
date > log.txt
echo "log.txt 파일에 시각이 저장되었습니다."

Q2. 권한 확인 실행권한 부여
```bash
-rw-r--r-- 1 root   root      6 Sep  1 07:01 date_log.sh
root@4d9326b8b3fa:/home# chmod +x date_log.sh
-rwxr-xr-x 1 root   root     79 Sep  1 07:03  date_log.sh
```

Q3. 실행 및 확인
```bash
root@4d9326b8b3fa:/home# ./date_log.sh
Tue Sep  1 07:03:50 UTC 2026
root@4d9326b8b3fa:/home# ./date_log.sh
Tue Sep  1 07:04:06 UTC 2026
root@4d9326b8b3fa:/home# ./date_log.sh
Tue Sep  1 07:04:11 UTC 2026
```

## Part001. AWS