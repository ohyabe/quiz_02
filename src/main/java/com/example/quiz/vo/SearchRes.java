package com.example.quiz.vo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;

import com.example.quiz.entity.Quiz;

public class SearchRes extends BasicRes {

	// 以下為 BasicRes 的屬性
	// private int statusCode;
	// private String message;

	private List<Quiz> quizList;
	// Quiz 問卷的問題
	// 以下為 List<Quiz> 的屬性
//	private int id;
//	private String name;
//	private String description;
//	private LocalDate startDate;
//	private LocalDate endDate;
//	private String questions;// 所有問題，做成List
//	private boolean published;// 確認按鈕，要不要發布

	public SearchRes() {
		super();
	}

// 合併
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
