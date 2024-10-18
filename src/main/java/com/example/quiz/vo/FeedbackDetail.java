package com.example.quiz.vo;

import java.time.LocalDate;
import java.util.List;

// 後臺內頁3 - 一個人的問卷回饋
public class FeedbackDetail {
	// 標題
	private String quizName;
	// 描述、說明
	private String description;
	// 起始日期
	private LocalDate startDate;
	// 結束日期
	private LocalDate endDate;
	// 姓名
	private String userName;
	// 手機
	private String phone;
	// 信箱
	private String email;
	// 年齡
	private int age;

	private List<Fillin> fillinList;

	public FeedbackDetail() {
		super();
	}

	public FeedbackDetail(String quizName, String description, LocalDate startDate, LocalDate endDate, String userName,
			String phone, String email, int age, List<Fillin> fillinList) {
		super();
		this.quizName = quizName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.fillinList = fillinList;
	}

	public String getQuizName() {
		return quizName;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public String getUserName() {
		return userName;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public List<Fillin> getFillinList() {
		return fillinList;
	}

}
