package org.scoula.frontcontrollerservlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AboutController implements Controller{
    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("msg", "💌컨트롤러가 전달한 ⓜⓔⓢⓢⓐⓖⓔ입니다💌");
        request.setAttribute("imgSrc", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLkaw4imd5KhiblUbKDXyJxsq_-DybAPF8ug&usqp=CAU");
        return "about";
    }
}



