package edu.xaut.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Article {
	int id;
	String title;
	String varity;
	String content;
	String mark;
	int userID;
	Date writeTime;
	
	
	public Date getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}
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
		return "Article [id=" + id + ", title=" + title + ", varity=" + varity + ", content=" + ", mark="
				+ mark + ", userID=" + userID + "]";
	}
	public ArticleVarity findVarity(List<Article> list,String varity) {
		ArticleVarity av=new ArticleVarity();
		av.setVarity(varity);
		av.setSet(new ArrayList<ArticleDes>());
		for(Article at:list) {
			if(at.getVarity().equals(varity)) {
				ArticleDes ad=new ArticleDes();
				ad.setId(at.getId());
				ad.setMark(at.getMark());
				ad.setTitle(at.getTitle());
				av.getSet().add(ad);
			}
		}
		return  av;
	}
	
	
}
