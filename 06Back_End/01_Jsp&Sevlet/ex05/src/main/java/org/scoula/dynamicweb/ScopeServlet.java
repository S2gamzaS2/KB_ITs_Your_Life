package org.scoula.dynamicweb;

import org.scoula.dynamicweb.domain.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    ServletContext sc; //application scope

    @Override
    public void init(ServletConfig config) throws ServletException {
        sc = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Application Scope
        sc.setAttribute("scopeName", "application scope값");

        //Session Scope
        HttpSession session = request.getSession();
        session.setAttribute("scopeName", "session scope값");

        //Request Scope
        request.setAttribute("scopeName", "request scope값");
        //DTO 캡슐화


        request.getRequestDispatcher("scope.jsp").forward(request, response);
    }
}