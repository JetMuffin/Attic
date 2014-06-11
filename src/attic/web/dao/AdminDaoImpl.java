package attic.web.dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException; 
import java.io.*;

import attic.web.model.Admin;

public class AdminDaoImpl implements AdminDao  {
	
	 private static Connection conn = null;  
	 private PreparedStatement pstmt = null;  
	 private ResultSet rs = null;  
	 private static final String URL = "jdbc:mysql://localhost:3306/attic";
	    
	 static {  
	        try {  
	            Class.forName("com.mysql.jdbc.Driver");  
	            try {  
	                conn = DriverManager.getConnection(URL,"root","");  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	        } catch (ClassNotFoundException e) {  
	            e.printStackTrace();  
	        }  
	  
	    }
	 
	 private void release(ResultSet rs, PreparedStatement pstmt) {  
	        if (rs != null) {  
	            try {  
	                rs.close();  
	            } catch (SQLException e) {   
	                e.printStackTrace();  
	            }  
	        }  
	        if (pstmt != null) {  
	            try {  
	                pstmt.close();  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	  }  
	 
	 public Admin select(Admin entity) {   
	        // 声明sql语句  
	        String sql = "select * from at_admin where uid=? and password=?";  
	        try {  
	            // 创建
	        	pstmt = conn.prepareStatement(sql);  
	            // 为占位符赋值  
	            int index = 1;  
	            pstmt.setObject(index++, entity.getUid());  
	            pstmt.setObject(index++, entity.getPassword());  
	            // 执行更新  
	            rs = pstmt.executeQuery();  
	            if (rs.next()) {  
	            	String realname=rs.getString(4);
	            	String status_str=rs.getString(5);
	            	int status=Integer.parseInt(status_str);
	                entity.setRealname(realname);
	                entity.setStatus(status);
	            }  
	            else{
	            	entity=null;
	            }
	            release(rs, pstmt);  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        release(rs, pstmt);  
	        // 修改返回值变量  
	        return entity;  
	    }  
	 
	  public boolean insert(Admin entity) {  
	        boolean flag = false;  
	        String sql = "insert into at_admin(uid,pass) values(?,?)";  
	        try {  
	            pstmt = conn.prepareStatement(sql);  
	            int index = 1;  
	            pstmt.setObject(index++, entity.getUid());  
	            pstmt.setObject(index++, entity.getPassword());  
	            int i = pstmt.executeUpdate();  
	            if (i > 0) {  
	                flag = true;  
	            }  
	        } catch (SQLException e) {    
	            e.printStackTrace();  
	        }  
	        release(rs, pstmt);  
	        return flag;  
	    }     
}
