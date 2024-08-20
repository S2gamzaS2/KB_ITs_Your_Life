<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--username: <%=request.getAttribute("username")%> <br>--%>
<%--useraddress: <%=request.getAttribute("useraddress")%> <br>--%>
<%--★세션에서 가져온 정보--%>
username_ss: <%=session.getAttribute("username")%> <br>
useraddress_ss: <%=session.getAttribute("useraddress")%> <br>
</body>
</html>
