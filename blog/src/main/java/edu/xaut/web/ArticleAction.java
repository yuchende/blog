package edu.xaut.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.xaut.bean.Article;
import edu.xaut.service.ArticleService;

import java.util.List;

import javax.annotation.*;

@Controller
@Scope("prototype")
public class ArticleAction extends ActionSupport {
	
	@SuppressWarnings("restriction")
	@Resource
	private ArticleService articleService;
	
	int articlesigle;
	String name;
	String varity;
	String article;
	String describe;
	List<Article> list;

	public int getArticlesigle() {
		return articlesigle;
	}


	public void setArticlesigle(int articlesigle) {
		this.articlesigle = articlesigle;
	}


	


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
	

	public List<Article> getList() {
		return list;
	}


	public void setList(List<Article> list) {
		this.list = list;
	}


	public String save() {
		if(name!=null) {
			Article art=new Article();
			art.setTitle(name);
			art.setVarity(varity);
			art.setContent(article);
			art.setMark(describe);
			art.setUserID(1);
			articleService.save(art);
			System.out.println("--------------");
			System.out.println(article);
			System.out.println("--------------");
			System.out.println(art.toString());
			list=(List<Article>) ActionContext.getContext().getSession().get("list");
			System.out.println("save");
			return "redirect";
		}else {
			System.out.println("nop");
			return SUCCESS;
		}
		
		
	}
	public String findAll() {
		list=articleService.findAll(1);
		ActionContext.getContext().getSession().put("list", list);
		for(Article ar:list) {
			System.out.println(ar.toString());
		}
		System.out.println("findAll");
		return "redirect";
	}
	public String findByID() {
		System.out.println("findbyID");
		//查询文章
		Article art=articleService.findArtiByID(articlesigle, 1);
		article=art.getContent();
		name=art.getTitle();
		//从session中获取list
		list=(List<Article>) ActionContext.getContext().getSession().get("list");
		System.out.println(art.toString());
		return "redirect";
	}
	public String main() {
		list=articleService.findAll(1);
		ActionContext.getContext().getSession().put("list", list);
		return "mainJSP";
	}
}
