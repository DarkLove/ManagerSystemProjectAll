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
import com.style.bean.TInform;

public class SelectAllInformServlet extends HttpServlet {

	
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
		int page =Integer.parseInt(request.getParameter("page")) ;//page从0开始  ++1
		int size =Integer.parseInt(request.getParameter("size")) ;//size不变
		List<TInform> list = BaseDao.getDao().getAllInform(page,size);
		String jsonArr = JSON.toJSONString(list);
		out.print(jsonArr);
		out.flush();
		out.close();
	}

}
