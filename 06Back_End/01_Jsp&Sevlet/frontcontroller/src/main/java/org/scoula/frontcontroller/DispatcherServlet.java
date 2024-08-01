package org.scoula.frontcontroller;

import org.scoula.frontcontroller.command.Command;
import org.scoula.frontcontroller.controller.HomeController;
import org.scoula.frontcontroller.controller.TodoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 부모클래스
// @WevServlet 어노테이션 안붙임 -> 상속 안됨
public class DispatcherServlet extends HttpServlet {
    Map<String, Command> getMap; //GET요청 맵핑 (String: url)
    Map<String, Command> postMap; //POST요청 맵핑

    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";

    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();
        createMap(getMap, postMap);
    }

    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {

    }

    //식별값 추출하기
    private String getCommandName(HttpServletRequest request) {
        String requestURL = request.getRequestURI();
        String contextPath = request.getContextPath();
        return requestURL.substring(contextPath.length());
    }

    private Command getCommand(HttpServletRequest request) {
        String commandName = getCommandName(request);

        Command command;
        if(request.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
        } else {
            command = postMap.get(commandName);
        }

        return command;
    }

    public void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String viewName = command.execute(request, response);

        if(viewName.startsWith("redirect:")) { //redirect처리
            response.sendRedirect(viewName.substring("redirect:".length()));
        } else { //forward처리
            String view = prefix + viewName + suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = getCommand(request);
        if(command != null) {
            execute(command, request, response);
        } else {
            // 404 에러처리
            String view = prefix + "404" + suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
