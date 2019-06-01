package edu.xaut.bean;

public class Collec {
	int id;
	String varity;
	String title;
	String url;
	int userID;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVarity() {
		return varity;
	}
	public void setVarity(String varity) {
		this.varity = varity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Collec [id=" + id + ", varity=" + varity + ", title=" + title + ", url=" + url + ", userID=" + userID
				+ "]";
	}
	
	
}
