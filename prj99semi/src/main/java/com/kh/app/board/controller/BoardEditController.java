package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;

@WebServlet("/board/edit")
public class BoardEditController extends HttpServlet {

	//수정하기 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String no = req.getParameter("no");
			
			BoardService bs = new BoardService();
			boolean isSelf = true;
			BoardVo vo = bs.getBoardByNo(no , isSelf);
			List<CategoryVo> categoryVoList = bs.getCategoryVoList();
			
			req.setAttribute("categoryVoList", categoryVoList);
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
	//수정하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 데꺼
			String no = req.getParameter("no");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String categoryNo = req.getParameter("categoryNo");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setCategoryNo(categoryNo);
			
			// 복작
			BoardService bs = new BoardService();
			int result = bs.edit(vo);
			if(result != 1) {
				throw new Exception("게시글 수정 실패 ...");
			}
			
			// 결과
			resp.sendRedirect("/app/board/detail?no=" + no);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}//method
	
}//class


















