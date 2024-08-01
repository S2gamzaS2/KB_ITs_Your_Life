package org.scoula.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

// web.xml 대체
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class }; // Root Context 만들어짐 (MVC와 무관, 여러곳에서 공통으로 쓸 수 있는 bean)
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { ServletConfig.class }; // MVC Context 만들어짐 (MVC 패턴(Controller)을 위해 사용되는 bean 등록)
    }

    //스프링의 FrontController인 DispatcherServlet이 담당할 url 매핑 리턴
    // "/" : 모든 요청에 대해 매핑
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    // POST body 문자 인코딩 필터 설정 - UTF-8
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();

        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true); // 항상 인코딩 해야한다

        return new Filter[] {characterEncodingFilter};
    }
}
