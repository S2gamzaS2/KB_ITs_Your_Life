package org.scoula.frontcontroller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//매개변수와 리턴타입이 Command 인터페이스와 맞아야 함
public class HomeController {
    public String getIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "index"; //viewName
    }
}
