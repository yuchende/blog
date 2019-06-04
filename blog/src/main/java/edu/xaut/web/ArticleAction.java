package edu.xaut.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.xaut.bean.Article;
import edu.xaut.bean.ArticleDes;
import edu.xaut.bean.ArticleVarity;
import edu.xaut.service.ArticleService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.*;

@Controller
@Scope("prototype")
public class ArticleAction extends ActionSupport {
	
	@SuppressWarnings("restriction")
	@Resource
	private ArticleService articleService;
	
	int articlesigle;
	String articleVar;
	String name;
	String varity;
	String article;
	String describe;
	List<Article> list;
	List<ArticleVarity> res;
	ArticleVarity   av;
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
	//通过ID来查找，若成功返回至 文章界面
	//参数    文章的
	//返回值  ；一片文章，一个分类对象
	//返回界面： 文章界面
	public String findByID() {
		System.out.println("findbyID");
		//查询文章
		Article art=articleService.findArtiByID(articlesigle, 1);
		article=art.getContent();
		name=art.getTitle();
		describe=art.getMark();
		//从session中获取list
		av=art.findVarity((List<Article>) ActionContext.getContext().getSession().get("list"), articleVar);
		System.out.println("-------articleVar");
		System.out.println(articleVar);
		System.out.println("-------articleVar");
		System.out.println("--------av");
		System.out.println(av.getVarity());
			for(ArticleDes avv:av.getSet() ) {
					System.out.print("["+avv.toString()+"]");
			}
		System.out.println("--------av");
		System.out.println(art.toString());
		return "redirect";
	}
	public String main() {
		list=articleService.findAll(1);
		ActionContext.getContext().getSession().put("list", list);
		//开始解析
		 res=new ArrayList<ArticleVarity>();
		int[] visited=new int[list.size()];
		for(int i=0;i<visited.length;i++) {
			visited[i]=0;
		}
		for(int i=0;i<list.size();i++) {
			String varity1=((Article)list.get(i)).getVarity();
			if(visited[i]==0) {
				ArticleVarity av=new ArticleVarity();
				av.setVarity(varity1);
				av.setSet(new ArrayList<ArticleDes>());
				for(int j=0;j<list.size();j++) {
					if(visited[j]==0) {
						if(varity1.equals(((Article)list.get(j)).getVarity())) {
							visited[j]=1;
							ArticleDes ad=new ArticleDes();
							ad.setId(((Article)list.get(j)).getId());
							ad.setMark(((Article)list.get(j)).getMark());
							ad.setTitle(((Article)list.get(j)).getTitle());
							av.getSet().add(ad);
						}
					}
				}
				res.add(av);
			}
		}
		System.out.println("输出解析结果");
		for(ArticleVarity av:res) {
			System.out.println("["+av.getVarity()+"]");
			for(ArticleDes ad:av.getSet()) {
				System.out.print(ad.getTitle()+"|||");
			}
			System.out.println();
		}
		
		return "mainJSP";
	}
	
	public List<ArticleVarity> getRes() {
		return res;
	}
	public void setRes(List<ArticleVarity> res) {
		this.res = res;
	}
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
	public String getArticleVar() {
		return articleVar;
	}
	public void setArticleVar(String articleVar) {
		this.articleVar = articleVar;
	}
	public ArticleVarity getAv() {
		return av;
	}
	public void setAv(ArticleVarity av) {
		this.av = av;
	}
	

	
}
