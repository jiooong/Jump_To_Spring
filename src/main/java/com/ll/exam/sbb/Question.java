package com.ll.exam.sbb;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    @Id //id 속성을 기본키로 지정한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 속성에 값을 세팅하지 않아도 1씩 자동 증가 저장
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT") //글자 수 제한할 수 없는 경우
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}