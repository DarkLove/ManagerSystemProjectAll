package com.fx.style;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fx.db.BaseDao;

public class LeaveServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String userID = request.getParameter("userId");
		String month = request.getParameter("month");
		String date = request.getParameter("date");
		String year = request.getParameter("year");
		String reason = request.getParameter("reason");
		
		BaseDao.getDao().putLeave(userID, month, date, year, reason);
		out.print("{\"succeed\":\"yes\"}");
		
		out.flush();
		out.close();
	}

}
