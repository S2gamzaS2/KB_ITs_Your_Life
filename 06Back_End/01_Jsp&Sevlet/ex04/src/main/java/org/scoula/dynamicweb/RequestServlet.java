package org.scoula.dynamicweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //속성 설정
        request.setAttribute("username", "홍길동");
        request.setAttribute("useraddress", "서울");

        //forward
        RequestDispatcher dis = request.getRequestDispatcher("/response.jsp");
        dis.forward(request, response);
    }
}