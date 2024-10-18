package com.example.quiz.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

//按前往可查看填寫完後的資料
public class Feedback {
	// 姓名
	private String userName;
	// 填寫日期、時間
	private LocalDateTime fillinDateTime;
	// 後臺內頁3
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
