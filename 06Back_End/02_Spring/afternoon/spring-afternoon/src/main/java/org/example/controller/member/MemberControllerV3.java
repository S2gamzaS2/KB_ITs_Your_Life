package org.example.controller.member;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.member.MemberDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
@RequestMapping("/member/v3")
public class MemberControllerV3 {
    private MemberDtoListV2 memberList;

    @Autowired
    public MemberControllerV3(MemberDtoListV2 memberDtoList) {

        this.memberList = memberDtoList;
    }

    @GetMapping("/show")
    public String memberList(Model model) {
        log.info("=====================> 회원 목록 조회 페이지 호출, /member/v3/show");

        model.addAttribute("memberList", memberList.getList());
        return "member-show3";
    }

    @GetMapping("/form")
    public String memberForm() {
        log.info("=========> 회원 추가 페이지 호출, member/form");
        return "member-form3";
    }

    @PostMapping(value="/form/save")
    public String memberSave(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            Model model) { //request 지우면 안됨~ 파라미터받아야댐~
        log.info("=====================> 회원 추가 Request 호출, /member/form/save");

        memberList.addList(id, name);

        model.addAttribute("memberList", memberList.getList());
        return "member-show3";
    }
}
