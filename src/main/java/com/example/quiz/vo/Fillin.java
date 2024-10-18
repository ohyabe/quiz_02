package com.example.quiz.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

// �@�� Fillin �N�O�@���D�ءA�@�i�̭��|���h���ݩ�
// �Ω��g�A�u���n���ȡA�u�� get ��k
public class Fillin {

	// question id
	@JsonProperty("question_id")
	private int qId;

	private String question;
	// �h��ﶵ�O��(�F)�걵
	private String options;
	// �^��
	private String answer;
	// �D������
	private String type;
	// �O�_����
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

	// �]���� 20 �檺�غc��k�A�ҥH���� set ��k
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
