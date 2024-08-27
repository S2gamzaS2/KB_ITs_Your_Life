package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


}
