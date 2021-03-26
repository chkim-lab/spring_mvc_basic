

## 스프링 MVC 첫 세팅
1. 우측 상단 gradle눌러서 새로고침 한번
2. src/main/resources폴더로 가서 application.properties 파일에
'server.port = 80'으로 수정
3. src/main/java에 MVCApplication클래스 main메서드 실행해서 서버띄우기

## JSP 파일 템플릿
'''
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Hello Spring ~~ 반갑습니다.</h1>
    <ul>
        <li><a href="/hello?name=hong">Hello Servlet</a></li>
        <li><a href="/basic/post-form.html">post-form페이지 열기</a>
        </li>
    </ul>
</body>
</html>
'''