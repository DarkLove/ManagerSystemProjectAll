package com.fx.style;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fx.db.BaseDao;

public class UpdateTaskStateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
	
		
		boolean boo = BaseDao.getDao().updataTaskState(id);
		if(boo){
			out.print("{\"succeed\":\"yes\"}");
		}else{
			out.print("{\"succeed\":\"no\"}");
		}
		
		out.flush();
		out.close();
	}

}
