package com.internousdev.blog.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.blog.dao.CategoryDAO;
import com.internousdev.blog.dto.CategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCategoryAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private CategoryDAO categoryDAO = new CategoryDAO();
	private String message;
	private List<CategoryDTO> categoryList = null;
	private int id;

	public String execute(){
		categoryDAO.deleteCategory(id);
		categoryList = categoryDAO.getCategoryList();
		message = "削除しました";
		return SUCCESS;
	}

	public void setId(int id){
		this.id = id;
	}

	public List<CategoryDTO> getCategoryList(){
		return categoryList;
	}

	public String getMessage(){
		return message;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
