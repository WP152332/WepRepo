package org.dimigo.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.ApplyService;
import org.dimigo.vo.ApplyVO;
import org.dimigo.vo.UserVO;

public class AdmissionListAction implements IAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			UserVO s = (UserVO)request.getSession().getAttribute("U");
			ApplyService as = new ApplyService();
			List<ApplyVO> l = as.searchApplyListByGetapplyid(s.getId());
			
			request.setAttribute("u", s);
			request.setAttribute("apply", l);

			RequestDispatcher rd = request.getRequestDispatcher("jsp/admission.jsp");
			rd.forward(request, response);	
		} catch(Exception e) {
			e.getStackTrace();
			request.setAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/admission.jsp");
			rd.forward(request, response);
		}
	}
}
