package com.example.quiz.constants;

public enum OptionType {
	SINGLE_CHOICE("���"), //
	MULTIPLE_CHOICE("�h��"),//
	TEXT("��r");

	private String type;

	private OptionType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}