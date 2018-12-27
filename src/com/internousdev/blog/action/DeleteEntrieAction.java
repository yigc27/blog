package com.internousdev.blog.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.blog.dao.EntrieDAO;
import com.internousdev.blog.dto.EntrieDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteEntrieAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private EntrieDAO entrieDAO = new EntrieDAO();
	private List<EntrieDTO> entrieList = null;
	private int postid;
	private String message;

	public String execute(){
		entrieDAO.deleteEntrie(postid);
		if((Boolean)session.get("admin")){
			entrieList = entrieDAO.getAllEntrieList();
		}else{
			entrieList = entrieDAO.getMyEntrieList((Integer)session.get("id"));
		}
		message="削除しました";
		return SUCCESS;
	}

	public void setPostid(int postid){
		this.postid = postid;
	}

	public String getMessage(){
		return message;
	}

	public List<EntrieDTO> getEntrieList(){
		return entrieList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
