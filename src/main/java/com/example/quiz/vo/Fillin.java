package com.example.quiz.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

// 一個 Fillin 就是一個題目，一張裡面會有多個屬性
// 用於填寫，只有要取值，只有 get 方法
public class Fillin {

	// question id
	@JsonProperty("question_id")
	private int qId;

	private String question;
	// 多選選項是用(；)串接
	private String options;
	// 回答
	private String answer;
	// 題目類型
	private String type;
	// 是否必填
	private boolean necessary;

	public Fillin() {
		super();
	}

	public Fillin(int qId, String question, String options, String answer, String type, boolean necessary) {
		super();
		this.qId = qId;
		this.question = question;
		this.options = options;
		this.answer = answer;
		this.type = type;
		this.necessary = necessary;
	}

	public Fillin(int qId, String question, String answer, String type, boolean necessary) {
		super();
		this.qId = qId;
		this.question = question;
		this.answer = answer;
		this.type = type;
		this.necessary = necessary;
	}

	// 因為有 20 行的建構方法，所以不用 set 方法
	public Fillin(int qId, String answer, String type, boolean necessary) {
		super();
		this.qId = qId;
		this.answer = answer;
		this.type = type;
		this.necessary = necessary;
	}

	public int getqId() {
		return qId;
	}

	public String getQuestion() {
		return question;
	}

	public String getOptions() {
		return options;
	}

	public String getAnswer() {
		return answer;
	}

	public String getType() {
		return type;
	}

	public boolean isNecessary() {
		return necessary;
	}

}
