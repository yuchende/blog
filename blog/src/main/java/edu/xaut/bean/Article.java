package edu.xaut.bean;

public class Article {
	int id;
	String title;
	String varity;
	String content;
	String mark;
	int userID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVarity() {
		return varity;
	}
	public void setVarity(String varity) {
		this.varity = varity;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", varity=" + varity + ", content=" + content + ", mark="
				+ mark + ", userID=" + userID + "]";
	}
	
	
}
