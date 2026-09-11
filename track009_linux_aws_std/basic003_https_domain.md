■Step4. HTTPS + DOMAIN

1. DucksDns 도메인생성
    1) https://www.duckdns.org
    2) 로그인
    3) SUB DOMAIN -> 원하는 이름.duckdns.org
    4) ec2 public ip 연동
    5) Token

    bubobo.duckdns.org
    9657bb44-f052-4e91-ada4-95c4555d503c

2. EC2 서버에서 DucksDns IP 자동 갱신설정
    > Aws Ec2의 인스턴스를 중지했다 키면, 퍼블릭 ip 주소가 바뀜

    1) ssh 접속
        ssh -i "thejoa703.pem" ubuntu@ec2-13-209-70-179.ap-northeast-2.compute.amazonaws.com
    2) duckdns 폴더만들기
        ```bash
        sudo mkdir -p ~/duckdns
        cd ~/duckdns
        ```
    3) duck.sh 쉘스크립트작성
        ```bash
        sudo vi duck.sh
        esc, i
        esc, :wq!
        ```

        ```bash
        echo url="https://www.duckdns.org/update?domains=도메인명&token=복사해둔토큰&ip="
        curl -k -o ~/duckdns/duck.log -K -

        echo url="https://www.duckdns.org/update?domains=bubobo&token=9657bb44-f052-4e91-ada4-95c4555d503c&ip="
        curl -k -o ~/duckdns/duck.log -K -
        ```

        ※ -k : ssl/tls 인증서 건너뛰기
        ※ -o ~/duckdns/duck.log : 성공 ok, 실패 ko
        ※ -K 표준입력의 설정 ,,,,, 코드 중간에 | curl 설정파일 형태로 읽어들이기

    4) 실행권한주기 소유자 모든권한, 그룹 x, 다른유저 x
        ```bash
        sudo chmod 700 duck.sh
        crontab -e
        2
        # esc, i
        # 맨 아랫줄에
        */5 * * * * /home/ubuntu/duckdns/duck.sh >/dev/null 2>&1
        # esc, :wq!
        # 년[월일 시분]초 <- 
        # 분 시 일 월 요일

        # >/dev/null 화면에 안띄우기
        # 2>&1 에러메세지 무시
        ```

3. nginx 설정 변경

    1) 설정파일 수정
        ``` 
        sudo vi   /etc/nginx/sites-available/default
        ```
        ```bash
        #  esc , i

        server {
            listen 80;
            server_name   thejoa703v2.duckdns.org;
            #   ... 기존내용그대로  ...
        } 
        # esc  :wq!
        ```   
    2) nginx 재시작

        ```
        sudo nginx -t
        sudo systemctl restart nignx
        ```

4. Certbot 으로 Https(SSL) 인증서 발급받기

    1) certbot설치
        ```bash
        sudo apt update
        # 격리된 환경
        sudo apt install snapd -y
        sudo snap install core 
        sudo snap refresh core
        # certbot SSL 무료 인증서 발급도구
        sudo snap install --classic certbot
        # 터미널 어디에서든지 certbot 사용가능
        sudo ln -s /snap/bin/certbot /usr/bin/certbot
        ```
    2) 인증서 발급 명령어 실행
        ```bash
        # sudo certbot --nginx -d mytestapp.duckdns.org
        sudo certbot --nginx -d bubobo.duckdns.org

        # email 입력 - 만료 알림용 , 약관동의 y, 이메일 수신 y
        ```

5. 프로젝트 환경변수 및 설정 수정
> before : http://13.209.70.179
> after : https://bubobo.duckdns.org

1) boot : SecurityConfig, yml
2) react : .env

6. 소셜마무리
http://13.209.70.179
bubobo.duckdns.org
9657bb44-f052-4e91-ada4-95c4555d503c