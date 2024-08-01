package org.scoula.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // bean으로 등록 됨
@Slf4j //
public class HomeController {

    @GetMapping("/") // getMap("/", ::home) 하라는 뜻~
    public String home() {
        log.info("=================> HomeController /"); // Console 출력
        return "index"; // View의 이름 -> prefix surfix와 결합함~ => /WEB-INF/views/index.jsp
    }
}
