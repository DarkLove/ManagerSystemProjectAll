package com.fx.style;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ui.UI;

import com.alibaba.fastjson.JSON;
import com.fx.db.BaseDao;
import com.style.bean.LoginBean;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	
	}

	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
		String name = UI.response(request, "name");
		String password = UI.response(request, "password");
		System.out.println(name+"  "+password);
		PrintWriter out = response.getWriter();
		BaseDao dao = BaseDao.getDao();
		LoginBean bean = dao.isHave(name, password) ; 
		if (bean == null) {
			out.print("{\"succeed\":\"no\"}");
			return ;
		}
		String section = dao.getSection(bean.getUserId()+"");
		if(bean != null){
		String json = JSON.toJSONString(bean);
		out.print("{\"succeed\":\"yes\",\"section\":\""+section+"\",\"bean\":"+json+"}");
		}else{
			out.print("{\"succeed\":\"no\"}");
		}
		out.flush();
		out.close();
	}

}
