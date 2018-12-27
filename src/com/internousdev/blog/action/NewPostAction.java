package com.internousdev.blog.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.blog.dao.CategoryDAO;
import com.internousdev.blog.dto.CategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class NewPostAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private CategoryDAO dao = new CategoryDAO();
	private List<CategoryDTO> categoryList = dao.getCategoryList();
	public String execute(){
		session.remove("postid");
		session.remove("title");
		session.remove("category");
		session.remove("text");
		session.remove("publish");
		return SUCCESS;
	}
	public List<CategoryDTO> getCategoryList(){
		return categoryList;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
