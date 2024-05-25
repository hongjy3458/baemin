package com.kh.app.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.admin.vo.AdminVo;
import com.kh.app.db.JDBCTemplate;

public class AdminDao {

	public AdminVo getAdminVo(Connection conn, AdminVo vo) throws Exception {
		//SQL
		String sql = "SELECT NO,ID,PWD,NICK FROM ADMIN WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		AdminVo loginAdminVo = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			
			loginAdminVo = new AdminVo();
			loginAdminVo.setNo(no);
			loginAdminVo.setId(id);
			loginAdminVo.setPwd(pwd);
			loginAdminVo.setNick(nick);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginAdminVo;
	}//method

}//class






































