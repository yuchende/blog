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

import com.opensymphony.xwork2.ActionSupport;

import edu.xaut.bean.Collec;
import edu.xaut.bean.CollecV1;
import edu.xaut.bean.insidedo;
import edu.xaut.service.CollecService;

@Controller
@Scope("prototype")
public class CollecAction extends ActionSupport {
	@SuppressWarnings("restriction")
	@Resource
	private CollecService collecService;

	private List<CollecV1> res;
	private int userID;
	
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

	public String findCollec() {
		List<Collec> list = collecService.findCollecByID(1);
		res = new ArrayList<CollecV1>();
		System.out.println(list.size());
		System.out.println("-----[-//解析开始------");
		int[] visited = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			visited[i] = 0;
		}
		for (int i = 0; i < list.size(); i++) {
			String varity = ((Collec) list.get(i)).getVarity();
			if (visited[i] == 0) {// 当前种类未被访问过
				System.out.println("=" + varity);
				CollecV1 cole = new CollecV1();
				cole.setVarity(varity);
				cole.setSet(new ArrayList<insidedo>());
				for (int j = 0; j < list.size(); j++) {
					if (visited[j] == 0) {// 当前种类未被访问过
						if (varity.equals(((Collec) list.get(j)).getVarity())) {
							visited[j] = 1;
							System.out.print(":::" + ((Collec) list.get(j)).getTitle());
							cole.getSet().add(new insidedo(((Collec) list.get(j)).getTitle(), ((Collec) list.get(j)).getUrl()));
							
						}

					}

				}
				res.add(cole);
				System.out.println();
			}

		}

		
	
		  System.out.println(res);
		  
		  for(CollecV1 co: res) {
			  System.out.println("1");
			  
			  
			  System.out.println(co.getVarity()+" "); 
		  for(insidedo in:co.getSet()) {
			  	System.out.print(in.getTitle()+" | "); 
		  }

		  }
		  
		 
		return SUCCESS;
	}

}
