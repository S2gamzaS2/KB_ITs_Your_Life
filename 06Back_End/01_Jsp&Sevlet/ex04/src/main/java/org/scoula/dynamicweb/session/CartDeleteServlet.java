package org.scoula.dynamicweb.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_delete")
public class CartDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // html 작성 및 출력
        out.print("<html><body>");
        out.print("장바구니 비웠다");

        //세션 객체 얻기
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        } else {
            out.print(" 세션 없음" + "<br>");
        }
        out.print("<a href='session_product.jsp'>상품 선택 페이지</a><br>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}