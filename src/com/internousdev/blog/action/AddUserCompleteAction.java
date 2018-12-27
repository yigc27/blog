package com.internousdev.blog.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.blog.dao.UserConfigDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AddUserCompleteAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private UserConfigDAO userConfigDAO = new UserConfigDAO();
	private String name;
	private String login_id;
	private String login_pass;
	private boolean admin;
	private String message;
	public String execute(){
		String result = ERROR;
		message = name.isEmpty() ? "名前を入力してください。" : "";
		message = login_id.isEmpty() ? message.isEmpty() ? "ログインIDを入力してください。" : message.concat("<br>ログインIDを入力してください。") : message;
		message = login_pass.isEmpty() ? message.isEmpty() ? "パスワードを入力してください。" : message.concat("<br>パスワードを入力してください。"): message;
		if(message.isEmpty()){
			userConfigDAO.addUser(name, login_id, login_pass, admin);
			result = SUCCESS;
		}
		return result;
	}

	public String getMessage(){
		return message;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getLogin_id(){
		return login_id;
	}

	public void setLogin_id(String login_id){
		this.login_id = login_id;
	}

	public String getLogin_pass(){
		return login_pass;
	}

	public void setLogin_pass(String login_pass){
		this.login_pass = login_pass;
	}

	public boolean getAdmin(){
		return admin;
	}

	public void setAdmin(boolean admin){
		this.admin = admin;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
