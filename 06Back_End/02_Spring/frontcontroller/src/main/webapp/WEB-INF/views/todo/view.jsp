<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>[view] Todo 상세보기</h1>
<div>
    <a href = "list">목록보기</a> |
    <a href= "update">수정하기</a>
</div>
<form action="delete" method="POST">
    <input type="submit" value="삭제">
</form>
</body>
</html>
