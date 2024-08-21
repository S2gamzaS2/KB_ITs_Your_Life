package org.scoula.dynamicweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //세션 invalidate
        HttpSession session = request.getSession(false);
        session.invalidate();
        //첫페이지로 redirect
        response.sendRedirect("/jstl_ex");
    }
}