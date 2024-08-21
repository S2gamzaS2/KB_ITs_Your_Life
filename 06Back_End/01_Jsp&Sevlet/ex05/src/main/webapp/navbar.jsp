<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<hr>
<c:if test="${empty users}">
    <a href="/login_form.jsp">로그인</a> | <a href="#">회원가입</a> <br>
</c:if>
<c:if test="${!empty users}">
    ${users.name} | <a href="/logout">로그아웃</a> <br>
</c:if>
</hr>