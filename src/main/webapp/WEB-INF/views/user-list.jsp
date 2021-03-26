<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--JSP에서 자바 코드를 안쓰는 법 (EL, JSTL) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.example.mvc.user.domain.User" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <%--
        //JSP 전용주석
        for (var : items) {}

        ${모델이름} ->${userList} : 모델객체에서 userList를 사용함.
        <% List<User> userList = (List<User>) request.getAttribute("userList"); %> 대체
        EL문법으로 getName 형식으로 불러온다.
    --%>


    <c:forEach var="user" items="${userList}">
        <div>이름: , ${user.name}, 나이: ${user.age}세 </div>
    </c:forEach>

    =========================================================
    <br>
    <a href="/new-form">다시 회원가입하기</a>

</body>
</html>