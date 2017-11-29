package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.ApplyService;
import org.dimigo.service.PostService;
import org.dimigo.vo.ApplyVO;
import org.dimigo.vo.UserVO;

public class AdmissionAction2 implements IAction {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("utf-8");
			UserVO s = (UserVO)request.getSession().getAttribute("U");
			if(s == null) throw new Exception("로그인 이후 이용하여 주세요.");
			String pk = request.getParameter("pk");
			String dai = request.getParameter("doapplyid");
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");

			ApplyVO U = new ApplyVO();
			
			PostService ps = new PostService();
			U.setGetapplyid(ps.searchPostByPk(pk).getId());
			U.setDoapplyid(dai);
			U.setPk(Integer.parseInt(pk));
			U.setTitle(ps.searchPostByPk(pk).getTitle());
			U.setPost(ps.searchPostByPk(pk).getPosting());
			U.setResult(2);
			
			ApplyService aps = new ApplyService();
			
			aps.searchApplyAndUpdate(U);
			
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
