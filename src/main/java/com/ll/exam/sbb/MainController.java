package com.ll.exam.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //서버에 전달된 클라이언트의 요청을 처리하는 자바 클래스
public class MainController {

    @RequestMapping("/")
    public String root(){
        return "redirect:/question/list";
    }
    //redirect url은 완전히 새로운 url로 요청. forward url은 기존 요청 값들이 유지된 상태로 전환

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