<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>TEST페이지 입니다.</h2>

<h2>${home}</h2>


<%-- 
<c:forEach var="member" items="${memberList}">
  아이디 : ${member.member_id}
    이름 : ${member.member_name}
    이메일 : ${member.member_email}
</c:forEach> --%>
멤버 리스트 : ${memberList}

</body>
</html>