package app.messages;

import java.util.Date;

public class Message_BeforHibernate {
	//새로운 Message 객체에 대해 생성된 id가 없고 값이 null 이 될수 있으므로 Integer 선언
	private Integer id;
	private String text;
	private Date createdDate;
	public Message_BeforHibernate() {
	}
	public Message_BeforHibernate(int id, String text, Date createdDate) {
		this.id = id;
		this.text = text;
		this.createdDate = createdDate;
	}
	public Message_BeforHibernate(int id, String text) {
		this.id = id;
		this.text = text;
	}
	public Message_BeforHibernate(String text) {
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
