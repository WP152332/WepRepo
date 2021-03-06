package org.dimigo.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.action.AdmissionAction;
import org.dimigo.action.AdmissionAction2;
import org.dimigo.action.AdmissionListAction;
import org.dimigo.action.ApplyAction;
import org.dimigo.action.ApplyListAction;
import org.dimigo.action.DeleteApplyAction;
import org.dimigo.action.DeleteApplyAction2;
import org.dimigo.action.DeletePostingAction;
import org.dimigo.action.IAction;
import org.dimigo.action.ListAction;
import org.dimigo.action.LoginAction;
import org.dimigo.action.LogoutAction;
import org.dimigo.action.MyPageAction;
import org.dimigo.action.PostListAction;
import org.dimigo.action.PostingAction;
import org.dimigo.action.SessionAction;
import org.dimigo.action.SignoutAction;
import org.dimigo.action.SignupAction;
import org.dimigo.action.UpdatePostingAction;
import org.dimigo.action.ViewAction;
import org.dimigo.action.ViewAction2;
import org.dimigo.action.ViewAction3;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, IAction>actions = new HashMap<>();
	public void init() throws ServletException{
		actions.put("login", new LoginAction());
		actions.put("logout", new LogoutAction());
		
		actions.put("session", new SessionAction());
		
		actions.put("signup", new SignupAction());
		actions.put("signout", new SignoutAction());
		
		actions.put("mypage", new MyPageAction());
		
		actions.put("post", new PostListAction());
		actions.put("posting", new PostingAction());
		actions.put("updatepost", new UpdatePostingAction());
		actions.put("deletepost", new DeletePostingAction());
		
		actions.put("view", new ViewAction());
		actions.put("view2", new ViewAction2());
		actions.put("view3", new ViewAction3());
		
		actions.put("apply", new ApplyAction());
		actions.put("applylist", new ApplyListAction());
		actions.put("deleteapply", new DeleteApplyAction());
		actions.put("deleteapply2", new DeleteApplyAction2());

		actions.put("admission", new AdmissionAction());
		actions.put("admission2", new AdmissionAction2());
		actions.put("admissionlist", new AdmissionListAction());
		
		actions.put("list", new ListAction());
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// URI가/WebClass/login.do인경우login만추출
			String uri = request.getRequestURI();
			String actionName = request.getRequestURI().substring(uri.lastIndexOf("/") + 1);
			actionName= actionName.substring(0, actionName.indexOf("."));
			IAction action = actions.get(actionName);
			if (action == null) {
				throw new Exception(actionName + "에 해당하는 Action이 없습니다.");
			}
			// Action의execute() 실행
			action.execute(request, response); 
			} 
		catch(Exception e) { 
			e.getStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/error.jsp");
			rd.forward(request, response);
			System.out.println(e.getMessage());	
		}
	}
}
