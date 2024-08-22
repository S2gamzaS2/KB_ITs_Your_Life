package org.scoula.frontcontroller;

import org.scoula.frontcontroller.command.Command;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//@WebServlet 어노테이션 X - 부모라서~!
//매번 이 클래스를 상속 받으면 됨니도~
public class DispatcherServlet extends HttpServlet {
    //요청별로 Map을 가짐
    Map<String, Command> getMap;
    Map<String, Command> postMap;

    //접두어,접미어
    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";

    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();
        createMap(getMap, postMap);
    }

    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {

    }


    //식별자 추출
    private String getCommandName(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        return requestURI.substring(contextPath.length());
    }

    private Command getCommand(HttpServletRequest request) {
        String commandName = getCommandName(request);

        Command command;
        if(request.getMethod().equalsIgnoreCase("GET")) { //대소문자 구분없이 비교해라
            command = getMap.get(commandName);
        } else {
            command = postMap.get(commandName);
        } //Map에 없으면 404에러

        return command;
    }

    public void execute(Command command, HttpServletRequest request, HttpServletResponse response)
            throws  IOException, ServletException {
        String viewName = command.execute(request, response);

        if(viewName.startsWith("redirect:")) {
            response.sendRedirect(viewName.substring("redirect:".length()));
        } else {
            String view = prefix + viewName + suffix;
            request.getRequestDispatcher(view).forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Command command = getCommand(request);
        if(command != null) {
            execute(command, request, response);
        } else { //404에러 처리
            String view = prefix + "404" + suffix;
            request.getRequestDispatcher(view).forward(request, response);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}