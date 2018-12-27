package com.internousdev.blog.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.blog.dao.UserConfigDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeLoginPasswordCompleteAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String newPassword;
	private String newPassword2;
	private String password;
	private String message;
	private UserConfigDAO userConfigDAO = new UserConfigDAO();

	public String execute(){
		boolean a = password.equals(session.get("login_pass").toString());
		boolean b = newPassword.equals(newPassword2);
		String wrongPass = "パスワードが違います。";
		String noMatch = "新しいパスワードが一致しません。";

		message = !a ? !b ? wrongPass + "<br>" + noMatch : wrongPass : !b ? noMatch : "";

		if(message.isEmpty()){
			userConfigDAO.changeLoginPassword(newPassword, (Integer)session.get("id"));
			session.put("login_pass", newPassword);
			message = "変更しました。";
		}
		return SUCCESS;
	}

	public void setNewPassword(String newPassword){
		this.newPassword = newPassword;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public void setNewPassword2(String newPassword2){
		this.newPassword2 = newPassword2;
	}


	public String getMessage(){
		return message;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}