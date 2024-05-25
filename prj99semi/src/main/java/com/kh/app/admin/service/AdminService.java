package com.kh.app.admin.service;

import java.sql.Connection;

import com.kh.app.admin.dao.AdminDao;
import com.kh.app.admin.vo.AdminVo;
import com.kh.app.db.JDBCTemplate;

public class AdminService {
	
	private final AdminDao dao;
	
	public AdminService() {
		this.dao = new AdminDao();
	}

	public AdminVo login(AdminVo vo) throws Exception {
		//biz
		
		//dao
		Connection conn = JDBCTemplate.getConnection();
		AdminVo loginAdminVo = dao.getAdminVo(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return loginAdminVo;
	}//method

}//class






































