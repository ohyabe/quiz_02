package com.example.quiz.vo;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOrUpdateReq {
	
	private int id;

	private String name;

	private String description;

	@JsonProperty("start_date")
	private LocalDate startDate;

	@JsonProperty("end_date")
	private LocalDate endDate;
	// 以上四個屬性是問卷參數

	@JsonProperty("question_list")
	private List<Question> questionList;

//  以下是 List<Question> questionList 包含的 Quiz 屬性
//	@JsonProperty("question_id")
//	private int questionId;
//
//	private String content;
//
//	private String type;
//
//	@JsonProperty("is_necessary")
//	private boolean necessary; // 小寫b 的boolean，預設為 false，因為是false，表示有內容值，所以不用檢查
//	// 以上四個屬性是問題參數

	@JsonProperty("is_published") // 序列化
	private boolean published;

	public CreateOrUpdateReq() {
		super();
	}

	public CreateOrUpdateReq(String name, String description, LocalDate startDate, LocalDate endDate,
			List<Question> questionList, boolean published) {
		super();
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.questionList = questionList;
		this.published = published;
	}

	public CreateOrUpdateReq(int id, String name, String description, LocalDate startDate, LocalDate endDate,
			List<Question> questionList, boolean published) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.questionList = questionList;
		this.published = published;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
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

	public List<Question> getQuestionsList() {
		return questionList;
	}

	public boolean isPublished() {
		return published;
	}

}
