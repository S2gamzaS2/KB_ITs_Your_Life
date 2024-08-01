package org.scoula.boardservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/setCookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        //쿠키 생성
        Cookie usercookie = new Cookie("username", "gamza");
        usercookie.setMaxAge(60 * 60 * 24); // 쿠키가 하루동안 생존할 수 있음 (쿠키는 초단위)
        response.addCookie(usercookie);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>쿠키가 생성되었습니다</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}