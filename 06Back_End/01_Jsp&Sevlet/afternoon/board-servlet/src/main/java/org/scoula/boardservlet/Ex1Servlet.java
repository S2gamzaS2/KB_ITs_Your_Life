package org.scoula.boardservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/ex1")
public class Ex1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Request 스코프
        request.setAttribute("msg1", "안녕하세요~~");

        //Session 스코프
        HttpSession session = request.getSession();
        session.setAttribute("msg2", "오늘은 하늘이 맑아서 하늘색을 보았어요~~~~!!!!");

        //Application
        ServletContext context = getServletContext();
        context.setAttribute("msg3", "이거 완전 럭키비키잖아?!🍀🍀🍀");

        // scope.jsp 파일로 이동
        request.getRequestDispatcher("ex1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}