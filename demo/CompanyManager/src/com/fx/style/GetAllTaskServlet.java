package com.fx.style;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.fx.db.BaseDao;
import com.style.bean.TaskBean;

public class GetAllTaskServlet extends HttpServlet {

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
		String state = request.getParameter("state");
		int page =Integer.parseInt(request.getParameter("page")) ;//page从0开始  ++1
		int size =Integer.parseInt(request.getParameter("size")) ;//size不变
		List<TaskBean> list = BaseDao.getDao().getAllTask(userId,page,size,state);
		String jsonArr = JSON.toJSONString(list);
		System.out.println("state  "+state );
		System.out.println("userId  "+userId );
		System.out.println("page  "+page );
		System.out.println("size  "+size );
		out.print(jsonArr);
		System.out.println(jsonArr.toString());
		out.flush();
		out.close();
	}

}
