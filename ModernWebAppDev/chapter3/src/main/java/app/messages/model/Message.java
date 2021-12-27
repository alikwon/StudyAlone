package app.messages.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MESSAGES")
public class Message {
	
	@Id  // -> 기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // -> id값이 생성되는 방법. IDENTITY : AUTO_INCREMENT
	@Column(name="ID", nullable = false) // -> ID 컬럼과 매핑
	private Integer id;
	
	@Column(name = "TEXT", nullable = false, length = 128)
	private String text;
	
	@Column(name = "CREATED_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP) // -> Calendar 또는 Date 타입에 필수적으로 추가. JDBC 가 이해할 수 있는 java.sql.Timestamp 타입의 값과 매핑
	private Date createdDate;
	
	
	public Message() {
	}
	public Message(int id, String text, Date createdDate) {
		this.id = id;
		this.text = text;
		this.createdDate = createdDate;
	}
	public Message(int id, String text) {
		this.id = id;
		this.text = text;
	}
	public Message(String text) {
		this.text = text;
		this.createdDate = new Date();
	}
	public Integer getId() {
		return id;
	}
	public String getText() {
		return text;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
}
