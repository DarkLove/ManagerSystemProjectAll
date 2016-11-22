package com.fx.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.style.bean.InfoBean;
import com.style.bean.LoginBean;
import com.style.bean.TInform;
import com.style.bean.TaskBean;
/**
 * 
 * @author Administrator   fuxing
 *
 */
public class BaseDao {
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://127.0.0.1:3306/company_manager_stytem?characterEncoding=utf-8";
	private final static String PWD = "root";
	private final static String USER = "root";
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static private BaseDao dao ;
	private BaseDao() {
		super();
	}
	public static BaseDao getDao(){
		if(dao != null){
			return dao ;
		}else{
			return new BaseDao() ;
		}
	}
	//获取链接
	public Connection getConnection(){
		Connection conn = null ;
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//增删改
	public  boolean updataFunction(String sql,Object... arr){
		boolean flag = false ;
		Connection conn = getConnection();
		PreparedStatement ps = null ;
		 int k = 0 ;
		try {
			 ps = conn.prepareStatement(sql);
			 if(arr!=null){
				 for (int i = 0; i < arr.length; i++) {
					ps.setObject(i+1, arr[i]);
				}
			 }
			 k = ps.executeUpdate();
			 if(k!=0){
				 flag = true ; 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(null, ps, conn);
		}
		return flag ;
	}
	
	public LoginBean isHave(String name,String pwd){
		LoginBean bean = null;
		StringBuffer sql = new StringBuffer("select * from login where name = ? and password = ? ");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null ;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()){
				bean = new LoginBean() ;
				bean.setName(rs.getString("name"));
				bean.setLimits(rs.getInt("limits"));
				bean.setUserId(rs.getInt("userId"));
			}else{
				bean = null ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(rs, ps, con);
		}
		
	  return bean ;
	}
	
	
	
	public InfoBean getOneselfInfo(String userID){
		InfoBean bean = null;
		StringBuffer sql = new StringBuffer("select * from info where userId = ?");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null ;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, userID);
			rs = ps.executeQuery();
			if(rs.next()){
				bean = new InfoBean() ;
				bean.setName(rs.getString("name"));
				bean.setUserId(rs.getInt("userId"));
				bean.setSex(rs.getInt("sex"));
				bean.setAge(rs.getInt("age"));
				bean.setPhoneNumber(rs.getString("phoneNumber"));
				bean.setPost(rs.getString("post"));
				bean.setSection(rs.getString("section"));
				bean.setPay(rs.getString("pay"));
				bean.setHiredate(rs.getString("hiredate"));
				bean.setShare(rs.getString("share"));
				bean.setGroup_leaderId(rs.getInt("group_leaderId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(rs, ps, con);
		}
		
	  return bean ;
	}
	
	public boolean updataPassword2(String userId,String newPassword){
		StringBuffer sql = new StringBuffer("update login set password = ? where userId = ?");
		Connection con = null;
		PreparedStatement ps = null;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, newPassword);
			ps.setString(2, userId);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(null, ps, con);
		}
		
	  return false ;
	}
	
	public boolean updataPassword(String userId,String oldPassword){
		StringBuffer sql = new StringBuffer("select * from login where userId = ?");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null ;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, userId);
			rs = ps.executeQuery();
			if(rs.next()){
				if(rs.getString("password").equals(oldPassword))
					return true ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(rs, ps, con);
		}
		
	  return false ;
	}
	public List<TInform> getAllInform(int page ,int size){
		TInform bean = null;
		List<TInform> list = new ArrayList<TInform>();
		StringBuffer sql = new StringBuffer("select * from t_inform limit ?,?");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null ;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, page*size);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			while(rs.next()){
				bean = new TInform() ;
				bean.setContent(rs.getString("content"));
				bean.setId(rs.getInt("id"));
				bean.setTime(rs.getString("time"));
				bean.setUserId(rs.getInt("userId"));
				bean.setTitle(rs.getString("title"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(rs, ps, con);
		}
		
	  return list ;
	}
	
	
	public int getLastId(){
		int id = -1; 
		StringBuffer sql = new StringBuffer("select * from info ");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null ;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while(rs.next()){
				id = rs.getInt("userId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(rs, ps, con);
		}
		
	  return id ;
	}
	
	
	public String getSection(String userID){
		String str = null; 
		StringBuffer sql = new StringBuffer("select * from info where userId = ?");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null ;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, userID);
			rs = ps.executeQuery();
			while(rs.next()){
				str = rs.getString("section");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(rs, ps, con);
		}
		
	  return str ;
	}
	
	public List<InfoBean> vagueSelection(String name,String phone,String post,String section){
		List<InfoBean> list = new ArrayList<InfoBean>();
		StringBuffer buffer = new StringBuffer("select * from info where 1=1 ");
		if (name != null) {
			buffer.append(" and name like '%"+name+"%' ");
		}
		if (phone != null) {
			buffer.append(" and phoneNumber like '%"+phone+"%' ");
		}
		if (post != null) {
			buffer.append(" and post like '%"+post+"%' ");
		}
		if (section != null) {
			buffer.append(" and section like '%"+section+"%' ");
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null ;
		con = getConnection();
		try {
			ps = con.prepareStatement(buffer.toString());
			rs = ps.executeQuery();
			InfoBean bean ;
			while(rs.next()){
				bean = new InfoBean() ;
				bean.setName(rs.getString("name"));
				bean.setUserId(rs.getInt("userId"));
				bean.setSex(rs.getInt("sex"));
				bean.setAge(rs.getInt("age"));
				bean.setPhoneNumber(rs.getString("phoneNumber"));
				bean.setPost(rs.getString("post"));
				bean.setSection(rs.getString("section"));
				bean.setPay(rs.getString("pay"));
				bean.setHiredate(rs.getString("hiredate"));
				bean.setShare(rs.getString("share"));
				bean.setGroup_leaderId(rs.getInt("group_leaderId"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(rs, ps, con);
		}
		return list ;
	}
	
	
	public List<InfoBean> getAllPerfmerDownPerson(String sql){
		List<InfoBean> list = new ArrayList<InfoBean>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null ;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			InfoBean bean ;
			while(rs.next()){
				bean = new InfoBean() ;
				bean.setName(rs.getString("name"));
				bean.setUserId(rs.getInt("userId"));
				bean.setSex(rs.getInt("sex"));
				bean.setAge(rs.getInt("age"));
				bean.setPhoneNumber(rs.getString("phoneNumber"));
				bean.setPost(rs.getString("post"));
				bean.setSection(rs.getString("section"));
				bean.setPay(rs.getString("pay"));
				bean.setHiredate(rs.getString("hiredate"));
				bean.setShare(rs.getString("share"));
				bean.setGroup_leaderId(rs.getInt("group_leaderId"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(rs, ps, con);
		}
		return list ;
	}
	
	
	public String putLeave(String userID,String month,String date,String year,String reason){
		String str = null; 
		StringBuffer sql = new StringBuffer("insert into `leave`(`userid`,`month01`,`date01`,`year01`,`reason01`) values (?,?,?,?,?)  ");
		Connection con = null;
		PreparedStatement ps = null;
		con = getConnection();
		
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, Integer.parseInt(userID));
			ps.setString(2, month);
			ps.setString(3, date);
			ps.setString(4, year);
			ps.setString(5, reason);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(null, ps, con);
		}
		
	  return str ;
	}
	
	public void putTask(String userId,String taskTitle,String state,String startTime,String endTime,String issueMan, String taskContent,String executeId , String executeName){
		StringBuffer sql = new StringBuffer("insert into `t_task`(`userId`,`taskTitle`,`state`,`startTime`,`endTime`,`issueMan`,`taskContent`,`executeId`,`executeName`) values (?,?,?,?,?,?,?,?,?)  ");
		Connection con = null;
		PreparedStatement ps = null;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, Integer.parseInt(userId));
			ps.setString(2, taskTitle);
			ps.setString(3, state);
			ps.setString(4, startTime);
			ps.setString(5, endTime);
			ps.setString(6, issueMan);
			ps.setString(7, taskContent);
			ps.setString(8, executeId);
			ps.setString(9, executeName);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(null, ps, con);
		}
		
	}
	
	public List<TaskBean> getAllTask(String userID,int page,int size,String state){
		List<TaskBean> list = new ArrayList<TaskBean>();
		TaskBean task = null ; 
		Integer i = 1;
		Map<Integer , Integer> map = new HashMap<Integer , Integer>();
		StringBuffer sql = new StringBuffer("select * from t_task where 1=1 ") ;
		if(userID != null ){
			 sql = sql.append(" and userId = ? ");
			 map.put(i++, Integer.parseInt(userID));
		}
		System.out.println(!state.equals(""));
		if(state != null && !state.equals("")){
			sql.append(" and state = ? ") ;
			map.put(i++, Integer.parseInt(state));
		}
		
		sql = sql.append(" limit ?,?") ;
		map.put(i++, page*size);
		map.put(i++, size);
		System.out.println(sql.toString());
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null ;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql.toString());
		    for (Integer key : map.keySet()) {
			   ps.setInt(key, map.get(key));
			  }
		
			rs = ps.executeQuery();
			while(rs.next()){
				task = new TaskBean();
				task.setId(rs.getString("id"));
				task.setUserId(rs.getString("userId"));
				task.setTaskTitle(rs.getString("taskTitle"));
				task.setState(rs.getString("state"));
				task.setStartTime(rs.getString("startTime"));
				task.setEndTime(rs.getString("endTime"));
				task.setIssueMan(rs.getString("issueMan"));
				task.setTaskContent(rs.getString("taskContent"));
				
				list.add(task);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(rs, ps, con);
			map.clear();
			map = null ;
		}
		
	  return list ;
	}
	
	public boolean updataTaskState(String id){
		StringBuffer sql = new StringBuffer("update t_task set state = ? where id = ?");
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0 ;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, "1");
			ps.setString(2, id);
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(null, ps, con);
		}
		if(i > 0 ){
			return true ;
		}
		
	  return false ;
	}
	
	public boolean updataInfo(String name,String sex,String age,String phoneNumber,String post,String pay ,String id){
		boolean flag = false ;
		int i = 1 ;
		StringBuffer sql = new StringBuffer("update info ");
		Map<Integer,String> map = new HashMap<Integer,String>();
		if(name!=null){
			map.put(i++, name);
			sql.append(" set name = ? ,");
			flag = true ;
		}
		if(sex!=null){
			map.put(i++, sex);
			if (flag) {
				sql.append(" sex = ? ,");
			}else{
				sql.append(" set sex = ? ,");
			}
			flag = true ;
		}
		if(age!=null){
			map.put(i++, age);
			if (flag) {
				sql.append(" age = ? ,");
			}else{
				sql.append(" set age = ? ,");
			}
			flag = true ;
		}
		if(phoneNumber!=null){
			map.put(i++, phoneNumber);
			if (flag) {
				sql.append(" phoneNumber = ? ,");
			}else{
				sql.append(" set phoneNumber = ? ,");
			}
			flag = true ;
		}
		if(post!=null){
			map.put(i++, post);
			if (flag) {
				sql.append(" post = ? ,");
			}else{
				sql.append(" set post = ? ,");
			}
			flag = true ;
		}
		
		if(pay!=null){
			map.put(i++, pay);
			if (flag) {
				sql.append(" pay = ? ,");
			}else{
				sql.append(" set pay = ? ,");
			}
			flag = true ;
		}
		String hql = sql.toString();
		hql = hql.substring(0,sql.length()-1);
		hql = hql+" where userId = ?";
		map.put(i++, id);
		System.out.println(hql);
		Connection con = null;
		PreparedStatement ps = null;
		con = getConnection();
		try {
			 ps = con.prepareStatement(hql);
			 for (Integer key : map.keySet()) {
				 ps.setString(key, map.get(key));
				 System.out.println(key+"  "+map.get(key));
			  }
			 i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnect(null, ps, con);
		}
		if(i > 0 ){
			return true ;
		}
		
	  return false ;
	}
	
	
	
	
	public void closeConnect(ResultSet set ,Statement sta ,Connection conn){
		if(set!=null){
			try {
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sta!=null){
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
