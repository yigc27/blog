package com.internousdev.blog.dto;

public class LoginDTO {
	private int id;
	private String login_id;
	private String login_pass;
	private String name;
	private boolean admin;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
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

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public boolean getAdmin(){
		return admin;
	}

	public void setAdmin(boolean admin){
		this.admin = admin;
	}
}
