package org.example.controller.todo.v2;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.todo.TodoDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class TodoShowControllerV2 {
    private TodoDtoListV2 todoList;

    @Autowired
    public TodoShowControllerV2(TodoDtoListV2 todoDtoList) {
        this.todoList = todoDtoList;
    }

    @GetMapping("/todo/v2/show")
    public String todoShow(Model model) {
        log.info("==============> TODO 목록 조회 페이지 호출, /todo/v2/show");

        model.addAttribute("todoList", todoList.getList());

        return "todo-show2";
    }
}
