package org.example.controller.todo;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.todo.TodoDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/todo/v3")
public class TodoControllerV3 {
    private TodoDtoListV2 todoDtoList;

    @Autowired
    public TodoControllerV3(TodoDtoListV2 todoDtoList) {
        this.todoDtoList = todoDtoList;
    }

    @GetMapping("/show")
    public String todoList(Model model) {
        log.info("==============> TODO 목록 조회 페이지 호출, /todo/v3/show");

        model.addAttribute("todoDtoList", todoDtoList.getList());
        return "todo-show3";
    }

    @GetMapping("/form")
    public String todoForm() {
        log.info("==============> TODO 추가 페이지 호출, /todo/v3/form");

        return "todo-form3";
    }

    @PostMapping("/form/save")
    public String todoSave(
            @RequestParam("todo") String todo,
            Model model) {

        log.info("===========> TODO 추가 Request 호출, /todo/v3/form/save");
        todoDtoList.addList(todo);
        model.addAttribute("todoDtoList", todoDtoList.getList());

        return "todo-show3";
    }

}
