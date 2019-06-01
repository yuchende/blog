package edu.xaut.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.xaut.bean.Article;
import edu.xaut.service.ArticleService;

import javax.annotation.*;

@Controller
@Scope("prototype")
public class ArticleAction extends ActionSupport {
	
	@SuppressWarnings("restriction")
	@Resource
	private ArticleService articleService;
	
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
		if(name!=null) {
			Article art=new Article();
			art.setTitle(name);
			art.setVarity(varity);
			art.setContent(article);
			art.setMark(describe);
			art.setUserID(1);
			articleService.save(art);
			System.out.println(art.toString());
			
			return "redirect";
		}else {
			return SUCCESS;
		}
		
		
	}
}
