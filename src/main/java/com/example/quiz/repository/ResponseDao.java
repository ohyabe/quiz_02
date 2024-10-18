package com.example.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quiz.entity.Response;

// 和表做連結，介面繼承class表的資料，interface > extends ( class > implements )
// 比對【問題填寫編號】和【手機號碼】是否填寫過
public interface ResponseDao extends JpaRepository<Response, Integer> {
	public boolean existsByQuizIdAndPhone(int quizId, String phone);
	
	public List<Response> findByQuizId(int quizId);

}
