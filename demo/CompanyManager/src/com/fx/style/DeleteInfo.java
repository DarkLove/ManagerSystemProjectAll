package com.fx.style;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fx.db.BaseDao;

public class DeleteInfo extends HttpServlet {

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
		String userId = request.getParameter("userId");
		System.out.println(userId+"=======================");
		String sql = " DELETE FROM info WHERE userId = ?";
		String sql2 = " DELETE FROM login WHERE userId = ?";
		BaseDao.getDao().updataFunction(sql,userId);
		BaseDao.getDao().updataFunction(sql2,userId);
		out.flush();
		out.close();
	}

}
