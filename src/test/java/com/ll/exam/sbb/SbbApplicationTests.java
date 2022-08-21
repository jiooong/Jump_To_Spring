package com.ll.exam.sbb;

import com.ll.exam.answer.Answer;
import com.ll.exam.answer.AnswerRepository;
import com.ll.exam.question.Question;
import com.ll.exam.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

	@Autowired // 스프링의 DI기능(스프링이 객체를 대신 생성해서 주입) 으로 questionRepository 객체를 스프링이 자동으로 생성해준다.
	private QuestionRepository questionRepository;

	@Test
	void testJpa0() {
		questionRepository.truncate();
	}
	@Test
	void testJpaa() {
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);  // 첫번째 질문 저장

		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);  // 두번째 질문 저장
	}

	@Test
	void testJpa() {
		List<Question> all = this.questionRepository.findAll();
		assertEquals(4, all.size());

		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}

	@Test
	void testJpa2() {
		Optional<Question> oq = this.questionRepository.findById(1);
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
	}

	@Test
	void testJpa3() {
		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1, q.getId());
	}

	@Test
	void testJpa4() {
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.setSubject("수정된 제목");
		this.questionRepository.save(q);
	}
	@Test
	void testJpa5() {
		assertEquals(2, this.questionRepository.count());
		Optional<Question> oq = this.questionRepository.findById(1); //null point exception 방지할 수 있도록 도와줌
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(1, this.questionRepository.count());
	}

	@Autowired
	private AnswerRepository answerRepository; // AnswerRepository 객체 주입

	@Test
	void testJpa6() {
 	Optional<Question> oq = this.questionRepository.findById(2);
	 assertTrue(oq.isPresent());
	 Question q = oq.get();

		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);
	}
	//답변 데이터 생성하고 저장하기

	@Transactional
	@Test
	void testJpa7(){
		Optional<Question> oq= this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1,answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());

	}


}
// 오전시간 2022-08-16 2-08, 2-09, 2-10 수행하기
//// 컨트롤러는 Repository가 있는지 몰라야 한다.
//// 서비스는 웹브라우저라는것이 이 세상에 존재하는지 몰라야 한다.