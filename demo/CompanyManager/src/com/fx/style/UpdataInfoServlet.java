package com.fx.style;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ui.UI;

import com.fx.db.BaseDao;

public class UpdataInfoServlet extends HttpServlet {

	
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
		String id = request.getParameter("userId");
		String name = UI.response(request, "name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String phoneNumber = request.getParameter("phoneNumber");
		String post = UI.response(request, "post");
		String pay = request.getParameter("pay");
		System.out.println("name: "+name+" sex: "+sex+" age： "+ age+" ｐｈ "+ phoneNumber+"  ｐｏ "+ post+"ｐａｙ  "+ pay+"   "+ id);
		boolean flag = BaseDao.getDao().updataInfo(name, sex, age, phoneNumber, post, pay, id);
		if(flag){
			out.print("{\"succeed\":\"yes\"}");
		}else{
			out.print("{\"succeed\":\"no\"}");
		}
//		getBytes("iso-8859-1"),"utf-8")转码
		out.flush();
		out.close();
	}

}
