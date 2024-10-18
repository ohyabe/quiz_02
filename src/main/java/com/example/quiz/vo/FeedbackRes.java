package com.example.quiz.vo;

import java.util.List;

public class FeedbackRes extends BasicRes {

	// Feedback 是按前往可查看填寫完後的資料
	private List<Feedback> feedbackList;

	public FeedbackRes() {
		super();
	}
	
	public FeedbackRes(int statusCode, String message) {
		super(statusCode, message);
	}

	public FeedbackRes(int statusCode, String message, List<Feedback> feedbackList) {
		super(statusCode, message);
		this.feedbackList = feedbackList;
	}

	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}

}
