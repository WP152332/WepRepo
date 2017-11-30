package org.dimigo.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.PostService;
import org.dimigo.util.CommonUtill;
import org.dimigo.vo.PostVO;
import org.dimigo.vo.UserVO;

public class PostingAction implements IAction {
	
	private void validate(PostVO U) throws Exception {
		if(CommonUtill.isEmpty(U.getPosting())) throw new Exception("글을 입력하세요");
		if(CommonUtill.isEmpty(U.getTitle())) throw new Exception("제목을 입력하세요");
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			UserVO s = (UserVO)request.getSession().getAttribute("U");
			String post = request.getParameter("post");
			String title = request.getParameter("title");
			
			SimpleDateFormat formatter = new SimpleDateFormat ("yyyy.MM.dd", Locale.KOREA);
			Date currentTime = new Date ();
			String date = formatter.format ( currentTime );
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");

			PostVO U = new PostVO();
			U.setId(s.getId());
			U.setTitle(title);
			U.setPosting(post);
			U.setDate(date);
			validate(U);
			PostService ps = new PostService();
			ps.posting(U);

			RequestDispatcher rd = request.getRequestDispatcher("/post.do");
			rd.forward(request, response);
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/posting.jsp");
			rd.forward(request, response);
		}
	}
}
