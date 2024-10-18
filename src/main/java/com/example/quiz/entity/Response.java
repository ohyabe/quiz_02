package com.example.quiz.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// 此表示收集答案的資料表(回饋)
@Entity
@Table(name = "response")
public class Response {

	// 流水號不重複，當 Id 可當流水號時，可用AI
	// 因為 PK 是 AI(Auto Incremental)，所以要加上此 Annotation (因為資料庫有勾選AI欄位)
	// strategy: 指的是 AI 的生成策略
	// GenerationType.IDENTITY: 代表 PK 由資料庫來自動增加
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "quiz_id")
	private int quizId;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "age")
	private int age;

	@Column(name = "fillin")
	private String fillin;
	
	// 建構方法將值塞給這個 class，當這些屬性都有值(預設值、固定的值)了就不用再生成建構方法了
	@Column(name = "fillin_date_time")
	private LocalDateTime fillinDateTime = LocalDateTime.now();
	
	public Response() {
		super();
	}

	public Response(int quizId, String name, String phone, String email, int age, String fillin) {
		super();
		this.quizId = quizId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.fillin = fillin;
	}

	public Response(int id, int quizId, String name, String phone, String email, int age, String fillin,
			LocalDateTime fillinDateTime) {
		super();
		this.id = id;
		this.quizId = quizId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.fillin = fillin;
		this.fillinDateTime = fillinDateTime;
	}

	public int getId() {
		return id;
	}

	public int getQuizId() {
		return quizId;
	}

	public String getName() {
		return name;
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

	public String getFillin() {
		return fillin;
	}
	
	public LocalDateTime getFillinDateTime() {
		return fillinDateTime;
	}
	
	
}
