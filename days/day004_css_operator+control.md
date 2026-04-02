### Todo 1 : CSS 기본

- 5. css(1)
1. 배경 : background
2. 글자 : color
3. 글자크기 : text-size
4. 정렬 : text-align
5. 밑줄 : text-decoration
6. 글꼴 : font-family
7. 굵게 : font-weigth
8. 가로 : width
9. 바깥쪽 여백 : margin
10. 안쪽 여백 : padding
11. 선 : border
12. 둥근모서리 : border-raidus
13. 그림자효과 : box-shadow



- 6. block vs line 0401 수업

1. block vs line
Q) a 태그에 margin 적용 x , text-align 적용 x , width 적용 x

display:block 박스 ( 갈치냄비 )                   - width , 줄바꿈 o
        예) div , p , pre

display:inline 박스 안의 내용물( 국물 , 무 , 갈치 ) - width(부분가능) , 줄바꿈 x
        예) img , a , span , strong

- 7. css(2) 내부적용 / id vs class

css 적용방법
1) 인라인 스타일  - 태그안에 직접 적용  

```html
<p style="color:red">color</p>
```

2) 내부 스타일 시트 - head 안의 style을 사용해 작성

```html
<style> p{ color:red; } </style>
```

3) 외부 스타일 시트

---

### Todo 2 : java 자료형2/연산자/제어문?


### 복습문제

> 정리문제 (1)
1. 배경을 파란색으로 설정하는 속성은?  background-color: blue
2. 글자색상을 빨간색으로 지정하는 속성은?  color: red
3. 글자 크기를 20px로 지정하는 속성은?  font-size: 20px
4. 글자를 가운데 정렬하는 속성은?  text-align: center
5. 글자에 밑줄을 추가하는 속성은?  font-decoration: line-through
6. 글꼴을 Arial로 지정하는 속성은?  font-family: Arial
7. 글자를 굵게 표시하는 속성은?  font-weight: bold
8. 요소의 가로 길이를 300px로 지정하는 속성은?  width: 300px
9. 요소의 바깥쪽 여백을 10px로 지정하는 속성은?  margin: 10px
10. 요소의 안쪽 여백을 15px로 지정하는 속성은?  padding: 15px
11. 요소에 1px 실선 테두리를 추가하는 속성은?  border: 1px
12. 모서리를 둥글게 10px로 만드는 속성은?  border-raidus: 10px
13. 그림자 효과를 추가하는 속성은?  box-shadow: 0, 0, 0 rgba(0,0,0,0)
14. 천천히 움직이는 장면전환효과를 주는 속성은? trasition: 범위 값

> 정리문제 (2)
15.  가로 사이즈 지정가능한것은 block o   /    inline
16.  a태그에 margin-top 줄수   o   /   x v
17.  css 적용방법 3가지 (인라인/내부스타일/외부스타일)
18.  css 적용 내부적용방법은 (head) 태그안에 (style) 태그 적용해서 사용
