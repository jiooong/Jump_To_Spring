package com.ll.exam.answer;


import java.time.LocalDateTime;

import javax.persistence.*;

import com.ll.exam.question.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne //N:1관계
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)) // 제약사항없음
    private Question question;
}