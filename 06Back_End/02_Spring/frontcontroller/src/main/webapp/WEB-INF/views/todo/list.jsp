<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>[list] Todo 리스트 보기</h1>
<div>
    <c:forEach var="li" items="${todoList}">
        ${li} <br>
    </c:forEach>
</div>
<hr>
<div>
  <a href="view">상세보기</a> | <a href="create">Todo 추가</a>
</div>

</body>
</html>
