package com.example.quiz.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

//���e���i�d�ݶ�g���᪺���
public class Feedback {
	// �m�W
	private String userName;
	// ��g����B�ɶ�
	private LocalDateTime fillinDateTime;
	// ��O����3
	private FeedbackDetail feedbackDetail;

	public Feedback() {
		super();
	}

	public Feedback(String userName, LocalDateTime fillinDateTime, FeedbackDetail feedbackDetail) {
		super();
		this.userName = userName;
		this.fillinDateTime = fillinDateTime;
		this.feedbackDetail = feedbackDetail;
	}

	public String getUserName() {
		return userName;
	}

	public LocalDateTime getFillinDateTime() {
		return fillinDateTime;
	}


	public FeedbackDetail getFeedbackDetail() {
		return feedbackDetail;
	}

}
