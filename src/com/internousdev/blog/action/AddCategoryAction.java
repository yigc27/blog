package com.internousdev.blog.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.blog.dao.CategoryDAO;
import com.internousdev.blog.dto.CategoryDTO;
import com.opensymphony.xwork2.ActionSupport;
public class AddCategoryAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String name;
	private String message;
	private CategoryDAO categoryDAO = new CategoryDAO();
	private List<CategoryDTO> categoryList;

	public String execute(){
		categoryDAO.addCategory(name);
		message = "追加が完了しました";
		categoryList = categoryDAO.getCategoryList();
		return SUCCESS;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getMessage(){
		return message;
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
