<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Scope 데이터 보기</h1>
page scope : ${pageScope.scopeName} <br>
request scope : ${requestScope.scopeName} <br>
session scope : ${sessionScope.scopeName} <br>
application scope : ${applicationScope.scopeName}<br>
<br>
\${scopeName} 자동 찾기 : ${scopeName} <br>
VO객체-Member name : ${member.name} <br>
VO객체-Member userid : ${member.userid}
</body>
</html>
