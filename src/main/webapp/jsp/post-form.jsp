
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!--action속성에 서버요청 url을 적고, method속성에 요청 방식을 적습니다.-->
<form action="/jsp/user-save.jsp" method="get">
    이름: <input type="text" name="username"> <br>
    나이: <input type="text" name="age"> <br>
    <button type="submit">확인</button>
</form>
</body>
</html>