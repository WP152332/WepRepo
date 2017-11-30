package org.dimigo.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.UserService;
import org.dimigo.vo.UserVO;

public class ListAction implements IAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("utf-8");
			UserService us = new UserService();
			List<UserVO> l = us.searchUserList();
			request.setAttribute("list", l);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/list.jsp");
			rd.forward(request, response);	
		} catch(Exception e) {
			e.getStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/errorpage.jsp");
			rd.forward(request, response);
		}
	}
}
