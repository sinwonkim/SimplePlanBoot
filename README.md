# SimplePlanBoot
If you do using this you can easy to make a plan ^_^

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

원인 : jstl jar 파일이 존재하지 않아서 내꺼 프로젝트 자체를 인식못함 
해결방안: jstl jar 필요 라이브러리 추가  + 프로젝트 오른쪽 클린  clean   , Maven 클릭  Maven Clean로 해결 

---

<div>
<img src="https://i.imgur.com/6sSfJXW.png">
</div>

원인 : mybatis 연동이 제대로 되지 않아 있었음  mybatis연동하는 방식 아래 3가지 방식인데 나의 경우 1번과 2번을 혼합해서 사용하는 방식을 
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

2. 애노테이션과 인터페이스만을 이용해서 SQL문을 설정 

3.간단한 SQL문은 애노테이션으로, 복잡한 SQL문은 XML로처리
