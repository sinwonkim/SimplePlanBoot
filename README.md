# SimplePlanBoot
생각의 정리가 필요할 때 어떠한 주제나 생각에 관하여 다른 사람의 의견을 물어보고  싶을때 이용 하세요.

If you do using this you can easy to make a plan ^_^

---
## 메인화면
<div>
<img src = "https://i.imgur.com/be3DjCB.jpg">
</div>
  
## 로그인
<div>
<img src = "https://i.imgur.com/txqDb1o.png">
</div>

## 회원가입
<div>
<img src = "https://i.imgur.com/azeVXKf.png">
</div>


---
## 기술스택
Spring boot(2.1.3)+Maven+MyBatis+Mysql

Front End: HTML, CSS, JavaScript, BootStrap
Back End: JAVA
library: JSTL
DB: MySQL

---

## Trouble Shooting
<div>
<img src="https://i.imgur.com/VBoXQmg.png">
</div>
[WARNING] The requested profile "pom.xml" could not be activated because it does not exist. 

Resolution : 
프로젝트 마우스 오른쪽 클릭
Run as => Run Configurations 클릭 
Profiles 부분에 있는 pom.xml 삭제 (여기에 내 경우 안적혀 있었다.)

그래서 이렇게 해결 하였다.
1. 이클립스 프로젝트에서 우측 마우스 클릭
2. 속성에서 MAVEN 선택
3. Active Maven Profile 텍스트 박스에서 pox.xml을 지우고 적용

<br/>


Launching springBoot -Aplication' has encountered a problem
The archive: C:/Users/사용자/Desktop/jstl.jar wh is referenced by the classpath, does not exist

원인 :
jstl jar 파일이 존재하지 않아서 내꺼 프로젝트 자체를 인식못함 

해결방안: jstl jar 필요 라이브러리 추가  + 프로젝트 오른쪽 클린  clean   , Maven 클릭  Maven Clean로 해결 

---

<div>
<img src="https://i.imgur.com/6sSfJXW.png">
</div>

원인 : 
mybatis 연동이 제대로 되지 않아 있었음  mybatis연동하는 방식 아래 3가지 방식인데 나의 경우 1번과 2번을 혼합해서 사용하는 방식을 
사용해서 하다가 제대로 마이바티스 연동이 되지 않았음. @MaperScan과  sqlsession을 사용해서 제대로 인식을 못함.. 

해결방안 
<div>
<img src="https://i.imgur.com/ErgEwT4.png">  
</div>

매퍼스캔방식 안하고  XML만을 이용해서 SQL문을 설정하는 방식으로 하였다. 

MyBatis를 이용할때 SQL문을 사용하는 방식은 크게 다음과 
같이 나눠짐

1.XML만을 이용해서 SQL문을 설정, DAO에서는 XML을 찾아서 
  실행하는 코드를 작성하는 방식

2.애노테이션과 인터페이스만을 이용해서 SQL문을 설정 

3.간단한 SQL문은 애노테이션으로, 복잡한 SQL문은 XML로처리

---

<div>
<img src="https://i.imgur.com/FaznXDu.png">
</div>
<div>
<img src="https://i.imgur.com/WEXvalb.png">
</div>

원인 : MemberVO라는 객체를 못 찾는데  에러를 자세히 안보면 초반부에는 다른 컨트롤러의 sqlsession이 inject 안됬다고 뜬다 하지만 실제 에러의 
      원인은 Mapper 의 쿼리중 ResultType이 MemberVO로 된걸 못 찾는데 있었다. 
    

해결
<div>
  <img src="https://i.imgur.com/4o9Ejfs.png">
</div>

컨트롤러에서 MemberVO 리스트를 만들고   서비스를 호출해서 궁극적으론 Mapper에서 Member테이블의 데이터를 가져와 데이터의 값을 비교하는 테스트를 
하려고 호출한 거였는데 ResultType에서   Alias 별칭으로 사용하지 않았을시에는 정확히 ResultType의 경로를 ResultType에 작성해주어야 한다.

---

[에러]
<div>
  <img src="https://i.imgur.com/w1RC6cA.png">
</div>

[원인]
<div>
  <img src="https://i.imgur.com/d75iMO1.png">
</div>
게시판 글쓰는 폼인데 폼 method는 POST 방식으로 해놓았는데   해당 컨트롤러를 보면 

<div>
  <img src="blob:https://imgur.com/f82676f2-2a41-462f-93cc-856156322570">
</div>
<div>
  <img src="https://i.imgur.com/0QZzBwp.png">
</div>
boardService.boardInsert() 를 통해 폼에서 작성된 writer와, title,content 를 BoardVO 객체로 셋 한 이후로 전달인자로 사용 하는데 
거기서 writer 경우 not null 로 설정 해놨다. 난 단순히 write 페이지를 보려고 했는데  그러한 이유로 not null이 발생해서 에러가 발생 



[해결]
<div>
   <img src="https://i.imgur.com/OgHRKHo.png">
</div>

단순히 boardWrite 페이지를 GET방식으로 하나더 매핑 시켜 boardWrite 페이지를 view 띄워줘서 해결 하였다.


참고사항
---
1인개발 3월 15일부터 현재 진행중 입니다.
