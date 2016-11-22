package com.fx.style;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fx.db.BaseDao;

public class DeleteServlet extends HttpServlet {


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
		String userId = request.getParameter("userId");
		PrintWriter out = response.getWriter();
		String sql = "DELETE FROM  info WHERE userId = ?" ;
		String sql2 = "DELETE FROM  t_award WHERE userId = ?" ;
		String sql3 = "DELETE FROM  permission  WHERE id = ?" ;
		String sql4 = "DELETE FROM  login  WHERE userId = ?" ;
		BaseDao.getDao().updataFunction(sql, userId) ;
		BaseDao.getDao().updataFunction(sql2, userId) ;
		BaseDao.getDao().updataFunction(sql3, userId) ;
		BaseDao.getDao().updataFunction(sql4, userId) ;
		out.print("{\"succeed\":\"yes\"}");
		out.flush();
		out.close();
	}

}
