package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j;
import org.scoula.ex03.dto.SampleDTO;
import org.scoula.ex03.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/sample") //공통url, 각 메서드마다 mapping하면 /sample/** ~이렇게됨
@Log4j
public class SampleController {

    @RequestMapping("") // url: /sample
    public void basic() {
        log.info("basic....................");
    }

    @RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST}) // url: /sample/basic
    public void basicGet() {
        log.info("basic get................");
    }

    @GetMapping("basicOnlyGet") // url: /sample/basicOnlyGet
    public void basicGet2() {
        log.info("basic get only get................");
    }

    ///////////////////////////

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto){ // DI 요청 (SampleDTO 만들어 달라고 요청 -> DTO 객체 생성)
        log.info("" + dto); // log는 문자열만 받아서 ""로 문자열 처리
        return "ex01";  // view 이름
    }

    @GetMapping("/ex02")
    public String ex02(
            @RequestParam("name") String name,
            @RequestParam("age") int age){
        log.info("name: " + name);
        log.info("age: " + age);

        return "ex02";
    }

    @GetMapping("/ex02List")
    public String ex02List(
            @RequestParam("ids") ArrayList<String> ids) {
        log.info("ids: " + ids);

        return "ex02List";
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info("todo: " + todo);
        return "ex03";
    }

    //* @ModelAttribute
    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page){
        log.info("dto: " + dto);
        //메서드가 실행되면 dto 객체를 자동으로 모델에 추가
        //모델 속성 이름: sampleDTO (앞글자소문자,자동생성) - jsp에서 ${sampleDTO}로 접근

        log.info("page:" + page);

        return "sample/ex04";
    }

    //*void 타입 리턴
    @GetMapping("/ex05") //url=뷰이름 : /sample/ex05
    public void ex05() {
        log.info("/ex05..........");
    }

    //*RedirectAttribute
    @GetMapping("/ex06")
    public String ex06(RedirectAttributes ra) {
        log.info("/ex06..........");
        ra.addAttribute("name", "AAA");
        ra.addAttribute("age", 10);

        return "redirect:/sample/ex06-2";
    }

    //*객체리턴
    @GetMapping("/ex07")
    public @ResponseBody SampleDTO ex07() {
        log.info("/ex07..........");

        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");

        return dto;
    }

}
