package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.ApplyService;
import org.dimigo.service.PostService;
import org.dimigo.vo.ApplyVO;
import org.dimigo.vo.UserVO;

public class ApplyAction implements IAction {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			UserVO s = (UserVO)request.getSession().getAttribute("U");
			if(s == null) throw new Exception("로그인 이후 이용하여 주세요.");
			String pk = request.getParameter("pk");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");

			ApplyVO U = new ApplyVO();
			
			PostService ps = new PostService();
			U.setGetapplyid(ps.searchPostByPk(pk).getId());
			U.setDoapplyid(s.getId());
			U.setPk(Integer.parseInt(pk));
			U.setTitle(ps.searchPostByPk(pk).getTitle());
			U.setPost(ps.searchPostByPk(pk).getPosting());
			ApplyService aps = new ApplyService();
			aps.doapply(U);
			
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
