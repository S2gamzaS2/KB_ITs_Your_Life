<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int age = 10; //지역변수
    Integer agenull = null;
    request.setAttribute("age", 40);
    request.setAttribute("agenull", null);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
변수 age : <%=age%> <br>
EL age: ${age} <br>
변수 null : <%=agenull%> <br>
EL null: ${agenull}
</body>
</html>
