package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.UserService;
import org.dimigo.vo.UserVO;

public class MyPageAction implements IAction {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("utf-8");
			UserVO s = (UserVO)request.getSession().getAttribute("U");
			String nowpw = request.getParameter("nowpwd");
			String pw = request.getParameter("pwd");
			String name = request.getParameter("name");
			String intro = request.getParameter("intro");
			String etc = request.getParameter("etc");
			
			if(!nowpw.equals(s.getPwd())) throw new Exception("현재 비밀번호가 옳지 않아 오류가 발생했습니다");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			UserVO U = new UserVO();
			U.setId(s.getId());
			if(name != null && name.trim() != "") U.setName(name);
			else U.setName(s.getName());
			if(pw != null && pw.trim() != "") U.setPwd(pw);
			else U.setPwd(s.getPwd());
			if (intro.equals("null")) U.setIntro(null);
			else if(intro != null && intro.trim() != "") U.setIntro(intro);
			else U.setIntro(s.getIntro());
			if (etc.equals("null")) U.setEtc(null);
			else if(etc != null && etc.trim() != "") U.setEtc(etc);
			else U.setEtc(s.getEtc());
			UserService us = new UserService();
			us.change(U);
			
			HttpSession session = request.getSession();
			session.setAttribute("U", U);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/mypage.jsp");
			rd.forward(request, response);
		}
	}
}
