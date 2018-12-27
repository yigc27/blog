package com.internousdev.blog.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.blog.dao.CategoryDAO;
import com.internousdev.blog.dao.PostDAO;
import com.internousdev.blog.dto.CategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String title;
	private String text;
	private int category;
	private boolean publish;
	private String message;
	private PostDAO dao = new PostDAO();
	private CategoryDAO categoryDAO = new CategoryDAO();
	private List<CategoryDTO> categoryList = categoryDAO.getCategoryList();
	public String execute(){
		if(session.get("postid") == null){
			dao.newPost(title, text, (Integer) session.get("id"), category, publish);
		}else{
			dao.updatePost((Integer) session.get("postid"), title, category, text, publish);
		}
		session.put("title", title);
		session.put("text", text);
		session.put("category", category);
		session.put("publish", publish);
		message = "投稿しました";
		return SUCCESS;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public void setText(String text){
		this.text = text;
	}

	public void setCategory(int category){
		this.category = category;
	}

	public void setPublish(boolean publish){
		this.publish = publish;
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
