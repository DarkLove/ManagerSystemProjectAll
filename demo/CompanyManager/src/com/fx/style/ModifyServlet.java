package com.fx.style;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fx.db.BaseDao;

public class ModifyServlet extends HttpServlet {

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
//http://127.0.0.1:8080/CompanyManager/modify.do?name=������&sex=1&age=20&phoneNumber=15937365488&post=���۾���&section=���۲�&pay=9999&hiredate=2015-8-7&share=1&group_leaderId=1&permiss=1&userId=2
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		List<String> list = new ArrayList<String>();
		list.add(request.getParameter("name"));
		list.add(request.getParameter("sex"));
		list.add(request.getParameter("age"));
		list.add(request.getParameter("phoneNumber"));
		list.add(request.getParameter("post"));
		list.add(request.getParameter("section"));
		list.add(request.getParameter("pay"));
		list.add(request.getParameter("hiredate"));
		list.add(request.getParameter("share"));
		list.add(request.getParameter("group_leaderId"));
		Object[] obj = list.toArray(new String[0]);
		String userId = request.getParameter("userId");
//		update info set name='����w' , sex = 100 ,age = 11, phoneNumber = '15777728399' , post = '�Ƽܹ�' , section = '������' , pay = '9999' , hiredate = '1995-4-5' , share = '0.06%'  where userId = 1;
		String sql = "update info set name=? , sex = ? ,age = ?, phoneNumber = ? , post = ? , section = ? , pay = ? , hiredate = ? , share = ? ,group_leaderId = ?  where userId = "+userId ; 
		boolean flag = BaseDao.getDao().updataFunction(sql, obj) ;
		if(flag){
			out.print("{\"succeed\":\"yes\"}");
		}else{
			out.print("{\"succeed\":\"no\"}");
		}
		out.flush();
		out.close();
	}

}
