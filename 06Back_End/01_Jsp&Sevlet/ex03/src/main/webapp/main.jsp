<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>메인 화면 페이지</title>
</head>
<body>
    <h1>include 지시어 태그 실습</h1>
    내용 수정 중~ 다음 줄에 copyright.jsp 삽입 됩니다~ </br>
    <%@ include file="copyright.jsp"%>

    <% if (Calendar.getInstance().get(Calendar.AM_PM) == Calendar.AM) { %>
        Good Morning
    <% } else { %>
        Good Afternoon
    <% } %>
</body>
</html>
