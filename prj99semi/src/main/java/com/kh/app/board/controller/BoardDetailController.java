package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.AttachmentVo;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//데꺼
			String no = req.getParameter("no");
			String writerNo = req.getParameter("writerNo");
			if(no == null || no.length() == 0) {
				throw new Exception("조회할 게시글 번호를 입력하세요");
			}
			
			//복작
			BoardService bs = new BoardService();
			MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");
			boolean isSelf = loginMemberVo == null ? false : loginMemberVo.getNo().equals( writerNo );
			BoardVo vo = bs.getBoardByNo(no , isSelf);
			
			List<AttachmentVo> attVoList = bs.getAttachment(no);
			
			if(vo == null) {
				throw new Exception("게시글 조회 실패 ...");
			}
			
			//결과
			req.setAttribute("vo", vo);
			req.setAttribute("attVoList", attVoList);
			req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}//method
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}//class
