package com.internousdev.blog.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.blog.util.DBConnector;

public class UserConfigDAO {
	private DBConnector dbc = new DBConnector();
	private Connection con = null;
	public void changeUserName(String newName,int id){
		con = dbc.getConnection();
		String sql = "UPDATE author_infomation SET name = ? WHERE id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setInt(2, id);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){}
		}
	}

	public void changeLoginId(String newId,int id){
		con = dbc.getConnection();
		String sql = "UPDATE author_infomation SET login_id = ? WHERE id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newId);
			ps.setInt(2, id);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){}
		}
	}

	public void changeLoginPassword(String newPassword,int id){
		con = dbc.getConnection();
		String sql = "UPDATE author_infomation SET login_pass = ? WHERE id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, id);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){}
		}
	}

	public void addUser(String name,String login_id,String login_pass,boolean admin){
		con = dbc.getConnection();
		String sql = "INSERT INTO author_infomation(name,login_id,login_pass,admin) VALUES(?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, login_id);
			ps.setString(3, login_pass);
			ps.setBoolean(4, admin);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){}
		}
	}
}
