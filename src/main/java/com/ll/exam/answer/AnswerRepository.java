package com.ll.exam.answer;

import com.ll.exam.answer.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {


}
//truncate question 실행되게 해라