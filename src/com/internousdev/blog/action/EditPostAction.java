package com.internousdev.blog.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.blog.dao.CategoryDAO;
import com.internousdev.blog.dao.EntrieDAO;
import com.internousdev.blog.dto.CategoryDTO;
import com.internousdev.blog.dto.EntrieDTO;
import com.opensymphony.xwork2.ActionSupport;

public class EditPostAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private int postid;
	private CategoryDAO categoryDAO = new CategoryDAO();
	private List<CategoryDTO> categoryList = categoryDAO.getCategoryList();
	private EntrieDAO entrieDAO = new EntrieDAO();

	public String execute(){
		EntrieDTO dto = entrieDAO.getEntrie(postid);
		session.put("postid", postid);
		session.put("title",dto.getTitle());
		session.put("category", dto.getCategory_id());
		session.put("text", dto.getText());
		session.put("publish", dto.getPublish());
		return SUCCESS;
	}

	public List<CategoryDTO> getCategoryList(){
		return categoryList;
	}

	public void setPostid(int postid){
		this.postid = postid;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
