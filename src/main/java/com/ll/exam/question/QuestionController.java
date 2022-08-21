package com.ll.exam.question;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor //questionRepository 속성을 포함하는 생성자를 생성 , final이 붙은 속성을 포함하는 생성자를 자동으로 생성하는 역할을 한다.
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @RequestMapping("/question/list")
    public String list(Model model) { //컨트롤러 메서드의 매개변수로 지정하면 스프링부트가 자동으로 Model객체를 생성한다.
        List<Question> questionList=this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @RequestMapping(value="/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){ //Model객체는 자바 클래스와 템플릿 간의 연결고리 역할
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
}
