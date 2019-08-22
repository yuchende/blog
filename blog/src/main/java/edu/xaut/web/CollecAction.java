package edu.xaut.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.xaut.bean.Article;
import edu.xaut.bean.ArticleDes;
import edu.xaut.bean.ArticleVarity;
import edu.xaut.bean.Collec;
import edu.xaut.bean.CollecV1;
import edu.xaut.bean.User;
import edu.xaut.bean.insidedo;
import edu.xaut.service.ArticleService;
import edu.xaut.service.CollecService;

@Controller
@Scope("prototype")
public class CollecAction extends ActionSupport {
	@SuppressWarnings("restriction")
	@Resource
	private CollecService collecService;
	
	@Resource
	private ArticleService articleService;
	
	private List<CollecV1> res;
	private int userID;
	private List<ArticleVarity> res2;
	private ArticleVarity av;
	private int id;
	private String varity;
	private Article art;
	private String content;
	//更新文章
	public String update() {
		System.out.println("------------update:"+id);
		User user=(User)ActionContext.getContext().getSession().get("user");
		art=collecService.findArtiByID(id, user.getId());
		System.out.println(art);
		content=art.getContent();
		return "success2";
	}
	//删除文章
	public String delete() {
		System.out.println("----------------------当前文章的id为"+id);
		collecService.deleteArticle(id);
		System.out.println("----------------------当前文章的id为"+id);
		System.out.println("----------------------当前文章的id为"+varity);
		
		
		// 这个地方不应该是个这个
		res2=(List<ArticleVarity>) (ActionContext.getContext().getSession().get("a_vi"));
		
		//对res2进行删除
		for(ArticleVarity av:res2) {
			int i=0;
				for(ArticleDes ad:av.getSet()) {
					if(ad.getId()==id) {
						av.getSet().remove(ad);
						i=1;
						break;
					}
				}	
			if(i==1) {
				break;
			}
		}
		ActionContext.getContext().getSession().put("a_vi",res2);	
		ActionContext.getContext().getSession().put("isDeleteSuccess",1);
		return SUCCESS;
	}
	
	//查询文章的种类
	public String findArti() {
		/*
		 * List<Collec> list = collecService.findCollecByID(1); res = new
		 * ArrayList<CollecV1>(); System.out.println(list.size());
		 * System.out.println("-----[-//解析开始------"); int[] visited = new
		 * int[list.size()]; for (int i = 0; i < list.size(); i++) { visited[i] = 0; }
		 * for (int i = 0; i < list.size(); i++) { String varity = ((Collec)
		 * list.get(i)).getVarity(); if (visited[i] == 0) {// 当前种类未被访问过
		 * System.out.println("=" + varity); CollecV1 cole = new CollecV1();
		 * cole.setVarity(varity); cole.setSet(new ArrayList<insidedo>()); for (int j =
		 * 0; j < list.size(); j++) { if (visited[j] == 0) {// 当前种类未被访问过 if
		 * (varity.equals(((Collec) list.get(j)).getVarity())) { visited[j] = 1;
		 * System.out.print(":::" + ((Collec) list.get(j)).getTitle());
		 * cole.getSet().add(new insidedo(((Collec) list.get(j)).getTitle(), ((Collec)
		 * list.get(j)).getUrl())); } } } res.add(cole); System.out.println(); }
		 * 
		 * } System.out.println(res); for(CollecV1 co: res) { System.out.println("1");
		 * System.out.println(co.getVarity()+" "); for(insidedo in:co.getSet()) {
		 * System.out.print(in.getTitle()+" | "); }
		 * 
		 * }
		 */
		/*
		 * res2=(List<ArticleVarity>)
		 * (ActionContext.getContext().getSession().get("a_v"));
		 */
		
		User user=(User)ActionContext.getContext().getSession().get("user");
		if(user.getLevel().equals("1")) {
			ActionContext.getContext().getSession().put("level", "canDiscuss");
			return SUCCESS;
		}
		System.out.println(user.getId());
		List<Article> list=articleService.findAll(user.getId());
		
		if(list.size()==0) {
			return SUCCESS;
		}
		
	
		
		//开始解析
		 res2=new ArrayList<ArticleVarity>();
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
				res2.add(av);
			}
		}
		ActionContext.getContext().getSession().put("a_vi",res2);
		return SUCCESS;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Article getArt() {
		return art;
	}
	public void setArt(Article art) {
		this.art = art;
	}
	public String getVarity() {
		return varity;
	}
	public void setVarity(String varity) {
		this.varity = varity;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public List<ArticleVarity> getRes2() {
		return res2;
	}


	public void setRes2(List<ArticleVarity> res2) {
		this.res2 = res2;
	}


	public int getUserID() {
		return userID;
	}

	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public List<CollecV1> getRes() {
		return res;
	}

	public void setRes(List<CollecV1> res) {
		this.res = res;
	}
	
	public ArticleVarity getAv() {
		return av;
	}

	public void setAv(ArticleVarity av) {
		this.av = av;
	}

}
