package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			HttpSession session = req.getSession();
			
			//데꺼
			String no = req.getParameter("no");
			String memberNo = ((MemberVo)session.getAttribute("loginMemberVo")).getNo();
			
			BoardVo boardVo = new BoardVo();
			boardVo.setNo(no);
			boardVo.setWriterNo(memberNo);
			
			//서비스
			BoardService bs = new BoardService();
			int result = bs.delete(boardVo);
			
			if(result != 1) {
				throw new Exception("게시글 삭제 실패 ... ㅠㅠ ");
			}
			
			//결과
			session.setAttribute("alertMsg", "게시글 삭제 성공!!!");
			resp.sendRedirect("/app/board/list");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}//method
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}//class
