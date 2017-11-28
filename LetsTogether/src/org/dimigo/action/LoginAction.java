package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtill;
import org.dimigo.vo.UserVO;

public class LoginAction implements IAction {
	
	private void validate(String id, String pwd) throws Exception {
		if(CommonUtill.isEmpty(id)) throw new Exception("아이디는 반드시 입력해야 합니다.");
		if(CommonUtill.isEmpty(pwd)) throw new Exception("비밀번호는 반드시 입력해야 합니다.");
	}
	
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pwd");
			validate(id, pw);
			UserVO User = new UserVO();
			User.setId(id);
			User.setPwd(pw);
			UserService us = new UserService();
			UserVO result = us.login(User);
		
			HttpSession session = request.getSession();
			session.setAttribute("U", result);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);
		}
		catch(Exception e) {
			e.getStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			rd.forward(request, response);
		}
	}
}
