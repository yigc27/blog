package com.internousdev.blog.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.blog.dto.CategoryDTO;
import com.internousdev.blog.util.DBConnector;

public class CategoryDAO {
	private List<CategoryDTO> categoryList = new ArrayList<CategoryDTO>();
	private DBConnector dbc = new DBConnector();
	public List<CategoryDTO> getCategoryList(){
		String sql = "SELECT * FROM categorys ORDER BY id ASC";
		Connection con = null;
		try{
			con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CategoryDTO dto = new CategoryDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				categoryList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(!(con == null)){con.close();}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return categoryList;
	}

	public void deleteCategory(int id){
		String sql = "DELETE FROM categorys WHERE id = ?";
		String sql2 = "UPDATE entries SET category = 1 WHERE category = ?";
		Connection con = null;
		try{
			con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement(sql2);
			ps.setInt(1, id);
			ps.executeUpdate();
			PreparedStatement ps2 = con.prepareStatement(sql);
			ps2.setInt(1, id);
			ps2.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){}
		}
	}

	public void addCategory(String name){
		String sql = "INSERT INTO categorys(name) values(?)";
		Connection con = null;
		try{
			con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
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
