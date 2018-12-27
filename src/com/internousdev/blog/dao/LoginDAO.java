package com.internousdev.blog.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.blog.dto.LoginDTO;
import com.internousdev.blog.util.DBConnector;

public class LoginDAO {
	private DBConnector dbc = new DBConnector();
	public LoginDTO getLoginUserInfo(String login_id,String login_pass){
		Connection con = null;
		LoginDTO dto = null;
		String sql="SELECT * FROM author_infomation WHERE login_id = ? AND login_pass = ?";
		try{
			con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, login_id);
			ps.setString(2, login_pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dto = new LoginDTO();
				dto.setId(rs.getInt("id"));
				dto.setLogin_id(rs.getString("login_id"));
				dto.setLogin_pass(rs.getString("login_pass"));
				dto.setName(rs.getString("name"));
				dto.setAdmin(rs.getBoolean("admin"));
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
		return dto;
	}
}
