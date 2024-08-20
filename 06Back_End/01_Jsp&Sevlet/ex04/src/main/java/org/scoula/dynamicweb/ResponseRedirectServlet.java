package org.scoula.dynamicweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response_redirect")
public class ResponseRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = (String) request.getAttribute("username"); //null
//        String useraddress = (String) request.getAttribute("useraddress"); //null
//
//        //속성 설정
//        request.setAttribute("username", username); //null
//        request.setAttribute("useraddress", useraddress); //null

        //★세션에서 정보 가져오기
//        HttpSession session = request.getSession(false);
//        String username_ss = (String)session.getAttribute("username");
//        String useraddress_ss = (String)session.getAttribute("useraddress");
//        request.setAttribute("username_ss", username_ss);
//        request.setAttribute("useraddress_ss", useraddress_ss);


        //forward
        RequestDispatcher dis = request.getRequestDispatcher("/redirect_response.jsp");
        dis.forward(request, response);
    }
}