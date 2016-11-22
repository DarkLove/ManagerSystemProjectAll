package com.fx.style;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ui.UI;

import com.fx.db.BaseDao;

public class TaskServlet extends HttpServlet {

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
		String taskTitle = UI.response(request, "taskTitle");
		String state = request.getParameter("state");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String issueMan = UI.response(request, "issueMan");//request.getParameter("issueMan");
		String taskContent = UI.response(request, "taskContent");
		String executeId = request.getParameter("executeId");
		String executeName = UI.response(request, "executeName");
		System.out.println();
		System.out.println(taskTitle+"  "+startTime+"  "+taskContent);
		try{
			BaseDao.getDao().putTask(userId, taskTitle, state, startTime, endTime, issueMan, taskContent,executeId,executeName);
			out.print("{\"succeed\":\"yes\"}");
		}catch(Exception e){
			out.print("{\"succeed\":\"no\"}");
		}
		out.flush();
		out.close();
	}

}
