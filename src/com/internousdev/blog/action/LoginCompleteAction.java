package com.internousdev.blog.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.blog.dao.LoginDAO;
import com.internousdev.blog.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginCompleteAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private LoginDAO dao = new LoginDAO();
	private String login_id;
	private String login_pass;
	private String message;

	public String execute(){
		String result = ERROR;
		LoginDTO dto = dao.getLoginUserInfo(login_id, login_pass);
		if(dto != null){
			session.put("id", dto.getId());
			session.put("name",dto.getName());
			session.put("admin", dto.getAdmin());
			session.put("login_id", dto.getLogin_id());
			session.put("login_pass",dto.getLogin_pass());
			result = SUCCESS;
		}else if(session.get("id") != null){
			result = SUCCESS;
		}else{
			message = "ログインに失敗しました。";
		}
		return result;
	}

	public void setLogin_id(String login_id){
		this.login_id = login_id;
	}

	public void setLogin_pass(String login_pass){
		this.login_pass = login_pass;
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
