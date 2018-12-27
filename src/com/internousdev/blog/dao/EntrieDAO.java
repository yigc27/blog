package com.internousdev.blog.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.blog.dto.EntrieDTO;
import com.internousdev.blog.util.DBConnector;

public class EntrieDAO {
	private List<EntrieDTO> entrieList = new ArrayList<EntrieDTO>();
	private DBConnector dbc = new DBConnector();
	public List<EntrieDTO> getEntrieList(){
		Connection con = null;
		String sql = "SELECT * FROM entries ent LEFT JOIN author_infomation ai ON ent.author_id = ai.id LEFT JOIN categorys cat ON ent.category = cat.id WHERE ent.publish = true ORDER BY post_date DESC";
		try{
			con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				EntrieDTO dto = new EntrieDTO();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setText(rs.getString("text").replaceAll("\\n", "<br>"));
				dto.setAuthor(rs.getString("ai.name"));
				dto.setAuthor_id(rs.getInt("author_id"));
				dto.setCategory(rs.getString("cat.name"));
				dto.setCategory_id(rs.getInt("category"));
				dto.setPost_date(rs.getDate("post_date"));
				dto.setUpdate_date(rs.getDate("update_date"));
				entrieList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return entrieList;
	}

	public List<EntrieDTO> getAllEntrieList(){
		Connection con = null;
		String sql = "SELECT * FROM entries ent LEFT JOIN author_infomation ai ON ent.author_id = ai.id LEFT JOIN categorys cat ON ent.category = cat.id ORDER BY post_date DESC";
		try{
			con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				EntrieDTO dto = new EntrieDTO();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setText(rs.getString("text"));
				dto.setAuthor(rs.getString("ai.name"));
				dto.setCategory(rs.getString("cat.name"));
				dto.setPost_date(rs.getDate("post_date"));
				dto.setAuthor_id(rs.getInt("author_id"));
				dto.setCategory_id(rs.getInt("category"));
				dto.setPublish(rs.getBoolean("publish"));
				dto.setUpdate_date(rs.getDate("update_date"));

				entrieList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return entrieList;
	}

	public List<EntrieDTO> getMyEntrieList(int author_id){
		Connection con = null;
		String sql = "SELECT * FROM entries ent LEFT JOIN author_infomation ai ON ent.author_id = ai.id LEFT JOIN categorys cat ON ent.category = cat.id WHERE ent.author_id = ? ORDER BY post_date DESC";
		try{
			con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, author_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				EntrieDTO dto = new EntrieDTO();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setText(rs.getString("text"));
				dto.setAuthor(rs.getString("ai.name"));
				dto.setCategory(rs.getString("cat.name"));
				dto.setPost_date(rs.getDate("post_date"));
				dto.setAuthor_id(rs.getInt("author_id"));
				dto.setCategory_id(rs.getInt("category"));
				dto.setPublish(rs.getBoolean("publish"));
				dto.setUpdate_date(rs.getDate("update_date"));
				entrieList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return entrieList;
	}

	public EntrieDTO getEntrie(int postid){
		EntrieDTO dto = new EntrieDTO();
		Connection con = null;
		String sql = "SELECT * FROM entries WHERE id = ?";
		try{
			con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, postid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getInt("id"));
				dto.setText(rs.getString("text"));
				dto.setAuthor_id(rs.getInt("author_id"));
				dto.setCategory_id(rs.getInt("category"));
				dto.setPost_date(rs.getDate("post_date"));
				dto.setPublish(rs.getBoolean("publish"));
				dto.setUpdate_date(rs.getDate("update_date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){}
		}
		return dto;
	}
	public void deleteEntrie(int postid){
		Connection con = null;
		String sql = "DELETE FROM entries WHERE id= ?";
		try{
			con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, postid);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){}
		}
	}
	public List<EntrieDTO> getEntrieListOnCategory(String category){
		Connection con = null;
		String sql = "SELECT * FROM entries ent LEFT JOIN author_infomation ai ON ent.author_id = ai.id LEFT JOIN categorys cat ON ent.category = cat.id WHERE ent.publish = true AND ent.category = ? ORDER BY post_date DESC";
		try{
			con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				EntrieDTO dto = new EntrieDTO();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setText(rs.getString("text").replaceAll("\\n", "<br>"));
				dto.setAuthor(rs.getString("ai.name"));
				dto.setAuthor_id(rs.getInt("author_id"));
				dto.setCategory(rs.getString("cat.name"));
				dto.setCategory_id(rs.getInt("category"));
				dto.setPost_date(rs.getDate("post_date"));
				dto.setUpdate_date(rs.getDate("update_date"));
				entrieList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return entrieList;
	}

}
