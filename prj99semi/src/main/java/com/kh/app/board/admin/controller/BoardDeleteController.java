package com.kh.app.board.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;

@WebServlet("/board/admin/delete")
public class BoardDeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			//data
			String[] noArr = req.getParameterValues("no");
			
			//service
			BoardService bs = new BoardService();
			int result = bs.delete(noArr);
			
			//result
			if(result < 1) {
				throw new Exception();
			}
			req.getSession().setAttribute("alertMsg", "게시글 " + noArr.length + "개 삭제 성공");
			resp.sendRedirect("/app/board/list");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}//method
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}







