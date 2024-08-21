package org.scoula.dynamicweb;

import org.scoula.dynamicweb.domain.Member;
import org.scoula.dynamicweb.dto.LoginDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1) 파라미터 추출
        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");

        // 2) 비지니스 로직 실행 (로그인 체크) - 했다 치고

        // 3) 결과 request scope에 저장 -> 개별 저장 안좋음 - 캡슐화(DTO)해야함
        request.setAttribute("userid", userid);
        request.setAttribute("passwd", passwd);
        //DTO 객체에 저장 ver
        LoginDTO loginDTO = new LoginDTO(userid, passwd);
        request.setAttribute("login", loginDTO);

        //로그인 처리..~?
        HttpSession session = request.getSession();
        Member member = new Member("홍길동", userid); // name, userid
        session.setAttribute("users", member);

        // 4) forward or redirect
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}