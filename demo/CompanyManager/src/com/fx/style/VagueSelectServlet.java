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
import com.style.bean.InfoBean;

public class VagueSelectServlet extends HttpServlet {

	
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
		
		String name = request.getParameter("name");
		System.out.println(name);
		String phone = request.getParameter("phone"); 
		String post = request.getParameter("post"); //职位
		String section = request.getParameter("section"); //部门
		BaseDao dao = BaseDao.getDao();
		List<InfoBean> list = dao.vagueSelection(name, phone, post, section);
		String jsonArr = JSON.toJSONString(list);
		out.print(jsonArr);
		out.flush();
		out.close();
	}

}
