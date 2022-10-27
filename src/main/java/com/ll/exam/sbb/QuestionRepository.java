package com.ll.exam.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject); //DI에 의해서 스프링이 자동으로 객체를 생성한다.



}
