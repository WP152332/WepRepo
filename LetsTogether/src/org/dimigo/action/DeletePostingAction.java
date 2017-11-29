package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.PostService;
import org.dimigo.vo.PostVO;

public class DeletePostingAction implements IAction {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("utf-8");
			String pk = request.getParameter("pk");

			PostVO U = new PostVO();
			U.setPk(Integer.parseInt(pk));
			PostService ps = new PostService();
			ps.deletePosting(U);

			RequestDispatcher rd = request.getRequestDispatcher("/post.do");
			rd.forward(request, response);
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/post.do");
			rd.forward(request, response);
		}
	}
}
