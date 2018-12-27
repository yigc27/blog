package com.internousdev.blog.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.blog.dao.CategoryDAO;
import com.internousdev.blog.dao.EntrieDAO;
import com.internousdev.blog.dto.CategoryDTO;
import com.internousdev.blog.dto.EntrieDTO;
import com.opensymphony.xwork2.ActionSupport;
public class CategoryRefineAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String categoryid;
	private CategoryDAO categoryDAO = new CategoryDAO();
	private EntrieDAO entrieDAO = new EntrieDAO();
	private List<CategoryDTO> categoryList = categoryDAO.getCategoryList();
	private List<EntrieDTO> entrieList = null;
	public String execute(){
		entrieList = entrieDAO.getEntrieListOnCategory(categoryid);
		return SUCCESS;
	}

	public void setCategoryid(String categoryid){
		this.categoryid = categoryid;
	}

	public List<CategoryDTO> getCategoryList(){
		return categoryList;
	}

	public List<EntrieDTO> getEntrieList(){
		return entrieList;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
