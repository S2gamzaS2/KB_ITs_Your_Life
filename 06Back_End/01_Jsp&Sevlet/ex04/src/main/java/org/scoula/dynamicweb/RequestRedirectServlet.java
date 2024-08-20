package org.scoula.dynamicweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/request_redirect")
public class RequestRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //속성 설정 -> 리다이렉트하면 아무 의미 없어지는 정보~
//        request.setAttribute("username", "홍길동");
//        request.setAttribute("useraddress", "서울");

        //★속성을 최종 jsp에서 출력하려면 session에 저장
        HttpSession session = request.getSession();
        session.setAttribute("username", "홍길동");
        session.setAttribute("useraddress", "서울");

        //리다이렉트
        response.sendRedirect("response_redirect");
    }
}