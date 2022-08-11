package com.ll.exam.sbb;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface QuestionRepository extends JpaRepository<Question, Integer> { //생성된 DB 테이블에 접근하는 메서드들을 사용하기 위한 인터페이스, CRUD 정의 하는 계층

    Question findBySubject(String subject);


    @Transactional
    @Modifying
    @Query(value = "truncate question", nativeQuery = true)
    void truncate();


}
