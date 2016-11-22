package ui;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class UI {
	static public String response(HttpServletRequest request,String req){
		String req2 = null;
		try {
			req2 = new String(request.getParameter(req).getBytes("iso-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  req2 ;
	}
}
