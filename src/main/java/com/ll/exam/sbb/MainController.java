package com.ll.exam.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class MainController {
    private int increaseNo = -1;

    @RequestMapping("/sbb")
        // 아래 함수의 리턴값을 그대로 브라우저에 표시
        // 아래 함수의 리턴값을 문자열화 해서 브라우저 응답의 바디에 담는다.
        @ResponseBody
        public String index() {
            // 서버에서 출력
            System.out.println("Hello");
            // 먼 미래에 브라우저에서 보여짐
            return "안녕하세요.";
        }
        @RequestMapping("/")
        public String root(){
        return "redirect:/question/list"; //완전히 새로운 url로 요청이 된다.
       // return "forward:/question/list";  는 기존 요청 값들이 유지된 상태로 전환된다
        }

    }


