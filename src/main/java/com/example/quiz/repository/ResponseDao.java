package com.example.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quiz.entity.Response;

// �M���s���A�����~��class����ơAinterface > extends ( class > implements )
// ���i���D��g�s���j�M�i������X�j�O�_��g�L
public interface ResponseDao extends JpaRepository<Response, Integer> {
	public boolean existsByQuizIdAndPhone(int quizId, String phone);
	
	public List<Response> findByQuizId(int quizId);

}
