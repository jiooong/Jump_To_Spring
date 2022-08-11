package com.ll.exam.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {


}
//truncate question 실행되게 해라