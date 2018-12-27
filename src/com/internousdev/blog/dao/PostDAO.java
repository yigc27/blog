package com.internousdev.blog.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.blog.util.DBConnector;
import com.internousdev.blog.util.DateUtil;
public class PostDAO {
	private DBConnector dbc = new DBConnector();
	private Connection con = dbc.getConnection();
	private DateUtil dateUtil = new DateUtil();

	public void newPost(String title,String text,int author_id,int category,boolean publish){
		String sql = "INSERT INTO entries (title,text,author_id,category,publish,post_date,update_date) VALUES(?,?,?,?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, text);
			ps.setInt(3, author_id);
			ps.setInt(4, category);
			ps.setBoolean(5, publish);
			ps.setString(6, dateUtil.getDate());
			ps.setString(7, dateUtil.getDate());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){}
		}
	}


	public void updatePost(Integer postid, String title, int category, String text, boolean publish) {
		String sql = "UPDATE entries SET title = ?, category = ?, text = ?, publish = ? , update_date = ? WHERE id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setInt(2, category);
			ps.setString(3, text);
			ps.setBoolean(4, publish);
			ps.setString(5, dateUtil.getDate());
			ps.setInt(6, postid);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){}
		}
	}
}