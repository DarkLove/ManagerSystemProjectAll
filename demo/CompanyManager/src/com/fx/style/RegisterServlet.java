package com.fx.style;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ui.UI;

import com.fx.db.BaseDao;

public class RegisterServlet extends HttpServlet {

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
//		http://127.0.0.1:8080/CompanyManager/register.do?name=������&sex=1&age=20&phoneNumber=15937365488&post=���۾���&section=���۲�&pay=9999&hiredate=2015-8-7&share=1&group_leaderId=1&permiss=1
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		List<String> list = new ArrayList<String>();
		list.add(UI.response(request, "name"));
		list.add(request.getParameter("sex"));
		list.add(request.getParameter("age"));
		list.add(request.getParameter("phoneNumber"));
		list.add(UI.response(request, "post"));
		list.add(UI.response(request, "section"));
		list.add(request.getParameter("pay"));
		list.add(UI.response(request, "hiredate"));
		list.add(request.getParameter("share"));
		list.add(request.getParameter("group_leaderId"));
		Object[] obj = list.toArray(new String[0]);
		System.out.println(list.toString());
		System.out.println(request.getParameter("permiss"));
		String sql = "insert into info(name,sex,age,phoneNumber,post,section,pay,hiredate,share,group_leaderId) values(?,?,?,?,?,?,?,?,?,?)";
 		boolean flag = BaseDao.getDao().updataFunction(sql, obj);
 		if(flag){
 			String sql2 = "insert into permission(id,permiss) values(?,?)";
	 		int lastId = BaseDao.getDao().getLastId();
	 		String permiss = request.getParameter("permiss");
	 		flag = BaseDao.getDao().updataFunction(sql2, new Object[]{lastId,permiss});
	 		
	 		String sql3 = "insert into login(userId,name,password,limits) values(?,?,?,?)";
	 		flag = BaseDao.getDao().updataFunction(sql3, new Object[]{lastId,list.get(0),"000000",permiss});
	 		
	 		
 		}
 		if(flag){
 			out.print("{\"succeed\":\"yes\"}");
 		}else{
 			out.print("{\"succeed\":\"no\"}");
 		}
		out.flush();
		out.close();
	}

}
