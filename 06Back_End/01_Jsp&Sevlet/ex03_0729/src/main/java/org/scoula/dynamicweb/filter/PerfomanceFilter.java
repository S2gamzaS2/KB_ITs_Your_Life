package org.scoula.dynamicweb.filter;

//수행 시간, 요청 처리 시간 체크 필터 - 성능 모니터링

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class PerfomanceFilter implements Filter {
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();

        // Servlet은 HttpServletRequest , Filter는 ServletRequest -> 인스턴스는 같음
        // 경로는 HttpServletRequest에서 알 수 있음 => 캐스팅해야 함
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println(
                httpRequest.getMethod() + ": " +
                httpRequest.getRequestURI() + " 실행시간: " + (end - start));
    }
}
