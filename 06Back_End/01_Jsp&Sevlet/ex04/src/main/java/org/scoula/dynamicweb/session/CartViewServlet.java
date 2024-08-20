package org.scoula.dynamicweb.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_view")
public class CartViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<html><body>");
        out.print("장바구니 리스트");

        //세션 객체 얻기
        HttpSession session = request.getSession(false); //false: 세션을 생성하지 않고, 이미 존재하는 세션만 반환하도록 요청

        if(session != null) {
            //if문 밖에 있으면 비어있는 세션이어서 null.setMaxInactiveInterval()이 돼서 에러 - 밑에 코드 실행 안됨~!
            session.setMaxInactiveInterval(10); //10초

            ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");
            out.print(" 상품: " + list + "<br>");
        } else {
            out.print(" 세션 없음" + "<br>");
        }

        out.print("<a href='session_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_delete'>장바구니 비우기</a><br>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}