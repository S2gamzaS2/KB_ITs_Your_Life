package org.scoula.dynamicweb.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_view_cookie")
public class CartViewCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // html 작성 및 출력
        out.print("<html><body>");
        out.print("장바구니 리스트<br>");

        //기존 쿠키 얻기
        Cookie[] cookies = request.getCookies();

        if(cookies != null) {
            for(Cookie c : cookies) {
                out.print(c.getName() + " : " + c.getValue() + "<br>");
            }
        }else {
            out.print("장바구니 비었음냐<br>");
        }

        out.print("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_delete_cookie'>장바구니 비우기</a>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}