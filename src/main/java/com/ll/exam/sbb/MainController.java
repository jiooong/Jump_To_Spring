package com.ll.exam.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //서버에 전달된 클라이언트의 요청을 처리하는 자바 클래스
public class MainController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello";
    }

    @RequestMapping("/sbb")
    @ResponseBody
    public String sbb(){
        return "index";
    }
}