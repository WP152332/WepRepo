package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.PostService;
import org.dimigo.vo.PostVO;

public class ViewAction3 implements IAction {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("utf-8");
			String pk = request.getParameter("pk");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");

			PostService ps = new PostService();
			
			PostVO p = new PostVO();
			p = ps.searchPostByPk(pk);
			
			request.setAttribute("title", p.getTitle());
			request.setAttribute("posting", p.getPosting());
			
			RequestDispatcher rd = request.getRequestDispatcher("/admissionlist.do");
			rd.forward(request, response);
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/admissionlist.do");
			rd.forward(request, response);
		}
	}
}
