package com.fx.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fx.db.BaseDao;

public class MyTest{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(isHave("fx","123"));;
	}
	
//	public static boolean isHave(String name,String pwd){
//		boolean flag = false ;
//		StringBuffer sql = new StringBuffer("select * from login where name = ? and password = ? ");
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null ;
//		con = getConnection();
//		try {
//			ps = con.prepareStatement(sql.toString());
//			ps.setString(1, name);
//			ps.setString(2, pwd);
//			rs = ps.executeQuery();
//			if(rs.next()){
//				flag = true ;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			closeConnect(rs, ps, con);
//		}
//		
//		return flag ;
//	}

}
