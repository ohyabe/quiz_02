package com.example.quiz.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

// 用於搜尋，只有要取值，只有 get 方法
public class SearchReq {

	private String name;

	@JsonProperty("start_date")
	private LocalDate startDate;

	@JsonProperty("end_date")
	private LocalDate endDate;

	public String getName() {
		return name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

}
