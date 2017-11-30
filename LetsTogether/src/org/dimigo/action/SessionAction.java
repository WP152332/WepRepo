package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionAction implements IAction {
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		if(req.getSession().getAttribute("U") == null) {
			res.sendRedirect("jsp/login.jsp");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("jsp/sessionInfo.jsp");
			rd.forward(req, res);
		}
	}
}
