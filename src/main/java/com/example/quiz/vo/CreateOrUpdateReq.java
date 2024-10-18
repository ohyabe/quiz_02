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
	// �H�W�|���ݩʬO�ݨ��Ѽ�

	@JsonProperty("question_list")
	private List<Question> questionList;

//  �H�U�O List<Question> questionList �]�t�� Quiz �ݩ�
//	@JsonProperty("question_id")
//	private int questionId;
//
//	private String content;
//
//	private String type;
//
//	@JsonProperty("is_necessary")
//	private boolean necessary; // �p�gb ��boolean�A�w�]�� false�A�]���Ofalse�A��ܦ����e�ȡA�ҥH�����ˬd
//	// �H�W�|���ݩʬO���D�Ѽ�

	@JsonProperty("is_published") // �ǦC��
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
