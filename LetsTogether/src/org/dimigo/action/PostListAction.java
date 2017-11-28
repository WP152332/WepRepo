package org.dimigo.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.PostService;
import org.dimigo.vo.PostVO;
import org.dimigo.vo.UserVO;

public class PostListAction implements IAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			PostService ps = new PostService();
			List<PostVO> l = ps.searchPostList();
			UserVO s = (UserVO)request.getSession().getAttribute("U");
			
			request.setAttribute("u", s);
			request.setAttribute("post", l);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/post.jsp");
			rd.forward(request, response);	
		} catch(Exception e) {
			e.getStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/errorpage.jsp");
			rd.forward(request, response);
		}
	}
}
