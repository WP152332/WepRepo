package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtill;
import org.dimigo.vo.UserVO;

public class SignupAction implements IAction {
	
	private void validate(UserVO U) throws Exception {
		if(CommonUtill.isEmpty(U.getId())) throw new Exception("아이디를 입력하세요");
		if(CommonUtill.isEmpty(U.getPwd())) throw new Exception("비밀번호를 입력하세요");
		if(CommonUtill.isEmpty(U.getName())) throw new Exception("이름을 입력하세요");
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pwd");
			String name = request.getParameter("name");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");

			UserVO U = new UserVO();
			U.setId(id);
			U.setName(name);
			U.setPwd(pw);
			
			validate(U);
			UserService us = new UserService();
			us.signup(U);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/signup.jsp");
			rd.forward(request, response);
		}
	}
}
