package com.kh.app.member.dao;

import static com.kh.app.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.member.vo.MemberVo;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) throws Exception {
		//SQL
		String sql = "INSERT INTO MEMBER(NO, ID, PWD, NICK, PROFILE) VALUES(SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		pstmt.setString(4, vo.getProfile());
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	}

	public MemberVo login(Connection conn, MemberVo vo) throws Exception {
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo loginMemberVo = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String delYn = rs.getString("DEL_YN");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String profile = rs.getString("PROFILE");
			
			loginMemberVo = new MemberVo();
			loginMemberVo.setNo(no);
			loginMemberVo.setId(id);
			loginMemberVo.setPwd(pwd);
			loginMemberVo.setNick(nick);
			loginMemberVo.setDelYn(delYn);
			loginMemberVo.setEnrollDate(enrollDate);
			loginMemberVo.setModifyDate(modifyDate);
			loginMemberVo.setProfile(profile);
		}
		close(rs);
		close(pstmt);
		return loginMemberVo;
	}

	public int edit(Connection conn, MemberVo vo) throws Exception {
		// SQL
		String sql = "UPDATE MEMBER SET PWD = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPwd());
		pstmt.setString(2, vo.getNo());
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	}

	public int quit(Connection conn, String no) throws Exception {
		//SQL
		String sql = "UPDATE MEMBER SET DEL_YN = 'Y' WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	}

	public int checkIdDup(Connection conn, String id) throws Exception {
		//SQL
		String sql = "SELECT COUNT(*) AS CNT FROM MEMBER WHERE ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		int cnt = 1;
		if(rs.next()) {
			cnt = rs.getInt("CNT");
		}
		
		close(rs);
		close(pstmt);
		
		return cnt;
	}

}//class










































