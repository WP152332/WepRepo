package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtill;
import org.dimigo.vo.UserVO;

public class SignoutAction implements IAction {
	
	private void validate(UserVO U) throws Exception {
		if(CommonUtill.isEmpty(U.getId())) throw new Exception("아이디를 입력하세요");
		if(CommonUtill.isEmpty(U.getPwd())) throw new Exception("비밀번호를 입력하세요");
		if(CommonUtill.isEmpty(U.getName())) throw new Exception("이름을 입력하세요");
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("utf-8");
			UserVO s = (UserVO)request.getSession().getAttribute("U");
			String id = request.getParameter("id");
			String pw = request.getParameter("pwd");
			String name = request.getParameter("name");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			
			if(!(s.getId().equals(id) && s.getName().equals(name) && s.getPwd().equals(pw))) throw new Exception("회원 정보와 입력 내용이 일치하지 않습니다.");
			
			UserVO U = new UserVO();
			U.setId(id);
			U.setName(name);
			U.setPwd(pw);
			
			validate(U);
			UserService us = new UserService();
			us.signout(U);
			HttpSession session = request.getSession();
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/signout.jsp");
			rd.forward(request, response);
		}
	}
}
