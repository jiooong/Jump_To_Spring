package com.ll.exam.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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


    @GetMapping("/plus")
    @ResponseBody
    public int showPage1Get(int a, int b) { //자바에서 브라우저로 전송할땐 어짜피 문장형태이기때문ㄷ에 자료형을int로해도된다
       return a+b;

    }
    @GetMapping("/minus")
    @ResponseBody
    public int showPage2Get(int a, int b) { //자바에서 브라우저로 전송할땐 어짜피 문장형태이기때문ㄷ에 자료형을int로해도된다
        return a-b;

    }
    @GetMapping("/increase")
    @ResponseBody
    public int showPage3Get(int a, int b) { //자바에서 브라우저로 전송할땐 어짜피 문장형태이기때문ㄷ에 자료형을int로해도된다
        return a+b;

    }
    @GetMapping("/gugudan")
    @ResponseBody
    public String showGugudan(Integer dan, Integer limit) {
        if (limit == null) {
            limit = 9;
        }

        if (dan == null) {
            dan = 9;
        }

        Integer finalDan = dan; //자바에서 프로그램을 실행시켰는데 finalDan = 5 이런식으로 재선언되지 않는경우 간이 final로 간주한다
        return IntStream.rangeClosed(1, limit)
                .mapToObj(i -> "%d * %d = %d".formatted(finalDan, i, finalDan * i))
                .collect(Collectors.joining("<br>\n"));
    }
    @GetMapping("/mbti/{name}")
    @ResponseBody
    public String showMbti(@PathVariable String name) {
        return switch (name) {
            case "홍길동" -> "INFP";
            case "홍길순" -> "INFJ";
            case "임꺽정" -> "ENFP";
            case "이지원" -> "ENFP";
            default -> "모름";
        };
    }


    @GetMapping("/saveSession/{name}/{value}")
    @ResponseBody
    public String saveSession(@PathVariable String name, @PathVariable String value, HttpServletRequest req) {
        HttpSession session = req.getSession();

        session.setAttribute(name, value);

        return "세션변수 %s의 값이 %s(으)로 설정되었습니다.".formatted(name, value);
    }

    @GetMapping("/getSession/{name}")
    @ResponseBody
    public String getSession(@PathVariable String name, HttpSession session) {
        String value = (String) session.getAttribute(name); //session.getAttribute는 객체로 이루어져 있어서 casting을 진행해야 한다.

        return "세션변수 %s의 값이 %s 입니다.".formatted(name, value);
    }

}
