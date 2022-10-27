package com.ll.exam.sbb.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestionController {

    @RequestMapping("/question/list")
    @ResponseBody
    public String list(){
        return "question list"; // 해당코드는 문자열을 직접 자바 코드로 작성하여 브라우저에 리턴
        //보통 자바 코드를 삽입할 수 있는 HTML형식의 파일인 템플릿 방식을 사용한다
    }

}
