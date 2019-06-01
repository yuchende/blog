package edu.xaut.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ArticleAction extends ActionSupport {
	
	String name;
	String varity;
	String article;
	String describe;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getVarity() {
		return varity;
	}


	public void setVarity(String varity) {
		this.varity = varity;
	}


	public String getArticle() {
		return article;
	}


	public void setArticle(String article) {
		this.article = article;
	}


	public String getDescribe() {
		return describe;
	}


	public void setDescribe(String describe) {
		this.describe = describe;
	}


	public String saveArti() {
		
		System.out.println(article);
		return SUCCESS;
	}
}
