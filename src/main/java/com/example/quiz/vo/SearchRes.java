package com.example.quiz.vo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;

import com.example.quiz.entity.Quiz;

public class SearchRes extends BasicRes {

	// �H�U�� BasicRes ���ݩ�
	// private int statusCode;
	// private String message;

	private List<Quiz> quizList;
	// Quiz �ݨ������D
	// �H�U�� List<Quiz> ���ݩ�
//	private int id;
//	private String name;
//	private String description;
//	private LocalDate startDate;
//	private LocalDate endDate;
//	private String questions;// �Ҧ����D�A����List
//	private boolean published;// �T�{���s�A�n���n�o��

	public SearchRes() {
		super();
	}

// �X��
	public SearchRes(int statusCode, String message, List<Quiz> quizList) {
		super(statusCode, message);
		this.quizList = quizList;
	}

	public List<Quiz> getQuizList() {
		return quizList;
	}

	public void setQuizList(List<Quiz> quizList) {
		this.quizList = quizList;
	}
}
