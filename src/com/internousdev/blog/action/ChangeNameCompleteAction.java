package com.internousdev.blog.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.blog.dao.UserConfigDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeNameCompleteAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String nameAfter = "";
	private String password = "";
	private String message = null;
	private UserConfigDAO userConfigDAO = new UserConfigDAO();
	public String execute(){
		String result = SUCCESS;
		if(nameAfter == null || nameAfter.isEmpty() ){
			message = "新しい名前が入力されていません。";
		}
		if(!(password.equals(session.get("login_pass").toString()))){
			message = message == null ? "パスワードが違います。" : message.concat("<br>パスワードが違います。");
		}
		if(!(nameAfter.isEmpty() || nameAfter == null) && password.equals(session.get("login_pass").toString())){
			userConfigDAO.changeUserName(nameAfter, (Integer)session.get("id"));
			session.put("name", nameAfter);
			message = "変更しました";

		}
		return result;
	}

	public void setNameAfter(String nameAfter){
		this.nameAfter = nameAfter;
	}

	public void setPassword(String password){
		this.password = password;
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
