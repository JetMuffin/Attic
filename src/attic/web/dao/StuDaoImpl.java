package attic.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import attic.web.model.Student;
import attic.web.model.User;

public class StuDaoImpl implements StuDao{
	 private static Connection conn = null;  
	 private PreparedStatement pstmt = null;  
	 private ResultSet rs = null;  
	 private static final String URL = "jdbc:mysql://localhost:3306/attic?useUnicode=true&characterEncoding=UTF-8";
	 
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
	 
	 public Student select(Student stu) {   
	        // 声明sql语句  
	        String sql = "select * from att_user_stu where uid=?";  
	        try {  
	            // 创建
	        	pstmt = conn.prepareStatement(sql);  
	            // 为占位符赋值  
	            int index = 1;  
	            pstmt.setObject(index++, stu.getUid());   
	            // 执行更新  
	            rs = pstmt.executeQuery();  
	            if (rs.next()) {  
	            	String name=rs.getString(3);
	            	String sex_str=rs.getString(4);
	            	int sex=Integer.parseInt(sex_str);
	            	String school=rs.getString(5);
	            	String major=rs.getString(6);
	            	String grade=rs.getString(7);
	            	String classes=rs.getString(8);
	                stu.setName(name);
	                stu.setSex(sex);
	                stu.setSchool(school);
	                stu.setMajor(major);
	                stu.setGrade(grade);
	                stu.setClasses(classes);
	            }  
	            else{
	            	stu=null;
	            }
	            release(rs, pstmt);  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        release(rs, pstmt);  
	        // 修改返回值变量  
	        return stu;  
	    }  
	 
	  public boolean insert(Student stu) {  
	        boolean flag = false;  
	        String sql = "insert into att_user_stu(uid,name,sex,school,major,grade,class) "
	        		+ "values(?,?,1,'','','','')";  
	        try {  
	            pstmt = conn.prepareStatement(sql);  
	            int index = 1;  
	            pstmt.setObject(index++, stu.getUid());
	            pstmt.setObject(index++, stu.getName());  
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
	  
	  public boolean update(Student stu){
		  boolean flag=false;
		  String sql = "select * from att_user where uid=" + stu.getUid();
		  try {  
	            pstmt = conn.prepareStatement(sql);  
	            rs = pstmt.executeQuery(sql);
	            if(rs.next())
	            {
	            	String updatesql = "update att_user_stu set name='" + stu.getName() + "', sex='"
	            			+ stu.getSex() + "', school='" + stu.getSchool() + "', major='" 
	            			+ stu.getMajor() + "', grade='" + stu.getGrade() + "', class='" 
	            			+ stu.getClasses() +"' where uid='" 
	            			+ stu.getUid() + "'";
		            int i = pstmt.executeUpdate(updatesql);   
	            	if (i > 0) {  
		                flag = true;  
		            }  
	            }   
		  } catch (SQLException e) {    
			  e.printStackTrace();  
	        }
	        release(rs, pstmt);  
	        return flag;  
	  }
	 
}
