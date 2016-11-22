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

public class SelectPerformerDownAllPersonServlet extends HttpServlet {

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
		String section = BaseDao.getDao().getSection(userId);
		String sql = " SELECT i.*,p.* FROM `info` AS i,`permission` AS p WHERE  p.permiss =2 and i.section = '"+section +"' and userId = id";
		List<InfoBean> beans =  BaseDao.getDao().getAllPerfmerDownPerson(sql);
		String list= JSON.toJSONString(beans);
		out.print(list);
		out.flush();
		out.close();
		
	}

}
