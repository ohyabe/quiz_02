package com.example.quiz.vo;

import java.util.List;

public class FeedbackRes extends BasicRes {

	// Feedback �O���e���i�d�ݶ�g���᪺���
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
