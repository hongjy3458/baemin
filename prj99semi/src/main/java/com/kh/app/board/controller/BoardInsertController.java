package com.kh.app.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.AttachmentVo;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.file.FileUpload;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 500 ,
		fileSizeThreshold = 1024 * 1024 * 50
		)
@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet {

	//게시글 작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BoardService bs = new BoardService();
			List<CategoryVo> categoryVoList = bs.getCategoryVoList();
			
			req.setAttribute("categoryVoList", categoryVoList);
			req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
	//게시글 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			
			// 데이터 꺼내기
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String category = req.getParameter("category");
			Collection<Part> parts = req.getParts();
			
			List<Part> fileList = new ArrayList<Part>();
			for (Part part : parts) {
				if(part.getContentType() != null) {
					fileList.add(part);
				}
			}
			
			//서버에 파일 업로드
			List<AttachmentVo> attVoList = new ArrayList<AttachmentVo>();
			for (Part f : fileList) {
				AttachmentVo attVo = FileUpload.saveFile(f);
				attVoList.add(attVo);
			}
			
//			AttachmentVo attVo = null;
//			if( f.getSize() > 0 ) {
//				//서버에 파일 업로드
//				attVo = FileUpload.saveFile(f);
//			}
			
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String writerNo = loginMemberVo.getNo();
			
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setCategoryNo(category);
			vo.setWriterNo(writerNo);
			
			// 서비스 호출
			BoardService bs = new BoardService();
			int result = bs.insert(vo , attVoList);
			
			// 결과
			if(result < 1) {
				throw new Exception("게시글 작성 실패 ...");
			}
			resp.sendRedirect("/app/board/list");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
}//class
















