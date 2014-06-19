package attic.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import attic.web.model.Subject;

public class SubjDaoImpl implements SubjDao{
	 private static Connection conn = null;  
	 private Statement stmt = null;  
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
	 
	 public ArrayList<Subject> getAllSubj(){
		 ArrayList<Subject> SubjList=new ArrayList<Subject>();
		 String sql = "select * from att_prac";
		 try {  
	            // 创建
	        	stmt = conn.createStatement();   
	            rs = stmt.executeQuery(sql);  
	            while(rs.next()) {  
	            	Subject subj=new Subject();
	            	subj.setName(rs.getString(2));
	            	subj.setUnitnum(Integer.parseInt(rs.getString(3)));
	            	subj.setTitle(rs.getString(4));
	            	subj.setUnit(Integer.parseInt(rs.getString(5)));
	            	subj.setQuesnum(Integer.parseInt(rs.getString(6)));
	            	subj.setIsnav(Integer.parseInt(rs.getString(7)));
	            	SubjList.add(subj);
	            }  
	            release(rs, stmt);  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        release(rs, stmt);  
	        // 修改返回值变量  
	        return SubjList;  
	 }
}
