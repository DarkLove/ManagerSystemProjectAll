package com.fx.style;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fx.db.BaseDao;

public class NodeServlet extends HttpServlet {

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
		String userId = request.getParameter("userId");
		String time = request.getParameter("time");
		String note = new String(request.getParameter("cotent").getBytes("iso-8859-1"),"utf-8");
		String sql = "insert into t_note(userId,note,time) values(?,?,?)";
		boolean flag = BaseDao.getDao().updataFunction(sql, new Object[]{userId,note,time});
		if(flag){
 			out.print("{\"succeed\":\"yes\"}");
 		}else{
 			out.print("{\"succeed\":\"no\"}");
 		}
		
		out.flush();
		out.close();
	}

}
