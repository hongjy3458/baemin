package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
	
	//로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	//로그인
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//세션
			HttpSession session = req.getSession();
			
			//데이터 꺼내기
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			
			//복잡한 작업
			MemberService ms = new MemberService();
			MemberVo loginMemberVo = ms.login(vo);
			
			//결과 (화면 == 문자열 내보내기)
			if(loginMemberVo != null) {
				session.setAttribute("alertMsg", "로그인성공 !!!");
				session.setAttribute("loginMemberVo", loginMemberVo);
			}else {
//				req.setAttribute("resultMsg", "로그인실패 ...");
				session.setAttribute("alertMsg", "로그인 실패 ...");
			}
//			req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
			resp.sendRedirect("/app/home");
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-M0002] 로그인 중 에러 발생 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

}//class


























