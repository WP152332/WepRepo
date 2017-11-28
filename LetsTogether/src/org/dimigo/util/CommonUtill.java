package org.dimigo.util;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class commonutill
 */
@SuppressWarnings("serial")
@WebServlet("/commonutill")
public class CommonUtill extends HttpServlet{
	public static boolean isEmpty(String c) {
		return (c == null || "".equals(c.trim()));
	}
}
