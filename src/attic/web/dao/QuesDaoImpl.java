package attic.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import attic.web.model.Question;

public class QuesDaoImpl implements QuesDao{
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
	 
	 private void release(ResultSet rs, Statement stmt) {  
	        if (rs != null) {  
	            try {  
	                rs.close();  
	            } catch (SQLException e) {   
	                e.printStackTrace();  
	            }  
	        }  
	        if (stmt != null) {  
	            try {  
	                stmt.close();  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	  }
	 
	 public ArrayList<Question> select(String subject,int unit) {   
	        // 声明sql语句  
	        String sql = "select * from att_ques where subject=? and unit=?";  
	        ArrayList<Question> queSet=new ArrayList<Question>();
	        try {  
	            // 创建
	        	pstmt = conn.prepareStatement(sql);  
	            // 为占位符赋值  
	            int index = 1;  
	            pstmt.setObject(index++, subject);  
	            pstmt.setObject(index++, unit);  
	            // 执行更新  
	            rs = pstmt.executeQuery();  
	            while (rs.next()) { 
	            	Question ques = new Question();
	            	ques.setId(Integer.parseInt(rs.getString(1)));
	            	ques.setNumber(Integer.parseInt(rs.getString(2)));
	            	ques.setUnit(unit);
	            	ques.setSubject(subject);
	            	ques.setDescription(rs.getString(5));
	            	ques.setOption(rs.getString(6));
	            	ques.setType(Integer.parseInt(rs.getString(7)));
	            	ques.setAnswer(rs.getString(8));
	            	queSet.add(ques);
	            }  
	            release(rs, pstmt);  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        release(rs, pstmt);  
	        // 修改返回值变量  
	        return queSet;  
	    }  
	 
	 public  Question selectById(int id)
	 {
		   // 声明sql语句  
	        String sql = "select * from att_ques where id=?";  
	        Question q = new Question();
	        try {  
	            // 创建
	        	pstmt = conn.prepareStatement(sql);  
	            // 为占位符赋值  
	            pstmt.setObject(1, id);   
	            // 执行更新  
	            rs = pstmt.executeQuery();  
	            if (rs.next()) { 
	            	q.setId(id);
	            	q.setNumber(Integer.parseInt(rs.getString(2)));
	            	q.setUnit(Integer.parseInt(rs.getString(3)));
	            	q.setSubject(rs.getString(4));
	            	q.setDescription(rs.getString(5));
	            	q.setOption(rs.getString(6));
	            	q.setType(Integer.parseInt(rs.getString(7)));
	            	q.setAnswer(rs.getString(8));
	            } 
	            else {
	            	System.out.println("not found!");
	            }
	            release(rs, pstmt);  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        release(rs, pstmt);  
	        // 修改返回值变量  
	        return q;   
	 }
}
