<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 입력 파라미터 출력</h1>
<%
//    String userid = request.getParameter("userid");
//    String Password = request.getParameter("Password");
//    String strAge = request.getParameter("age");
//    int age = strAge != null ? Integer.parseInt(strAge) : -1;
//    int age = Integer.parseInt(request.getParameter("age"));

    String id = (String) session.getAttribute("userid");
    if(id == null) {
        response.sendRedirect("loginForm.jsp");
    } else {
        String pw = (String) session.getAttribute("Password");
        out.print("사용자 아이디: " + id + "<br>");
        out.print("<a href='logout.jsp'>로그아웃</a>");
    }
%>
<%--아이디: <%= userid %> <br>--%>
<%--비밀번호: <%= Password%> <br>--%>
<%--나이: <%= age%> <br>--%>
</body>
</html>

