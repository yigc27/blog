package com.internousdev.blog.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.blog.dao.UserConfigDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeLoginIdCompleteAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String newLoginId;
	private String password;
	private String message;
	private UserConfigDAO userConfigDAO = new UserConfigDAO();

	public String execute(){
		String noId = "新しいログインIDが入力されていません。";
		String wrongPass = "パスワードが違います。";
		message = newLoginId.isEmpty() ?

				//ログインIDが未入力の場合
				!(password.equals(session.get("login_pass").toString())) ?
						//ログインIDが未入力かつパスワードが違う場合
						noId + "<br>" + wrongPass
						//ログインIDが未入力でパスワードが正しい場合
						: noId

				//ログインIDが入力されている場合
				: !(password.equals(session.get("login_pass").toString())) ?
						//ログインIDが入力されていてパスワードが違う場合
						wrongPass
						//ログインIDもパスワードも正常な場合
						: "";

		if(message.isEmpty()){
			userConfigDAO.changeLoginId(newLoginId, (Integer)session.get("id"));
			message = "変更しました。";
			session.put("login_id", newLoginId);
		}
		return SUCCESS;
	}

	public void setNewLoginId(String newLoginId){
		this.newLoginId = newLoginId;
	}

	public void setPassword(String password){
		this.password = password;
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