package attic.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import attic.web.model.Node;

public class NodeDaoImpl implements NodeDao{
	
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
	 
	 public ArrayList<Node> getAllNav(){
		 ArrayList<Node> nav=new ArrayList<Node>();
		 String sql = "select * from at_nav_node";
		 try {  
	            // 创建
	        	stmt = conn.createStatement();   
	            rs = stmt.executeQuery(sql);  
	            while(rs.next()) {  
	            	Node navelem=new Node();
	            	navelem.setId(Integer.parseInt(rs.getString(1)));
	            	navelem.setName(rs.getString(2));
	            	navelem.setTitle(rs.getString(3));
	            	navelem.setPid(Integer.parseInt(rs.getString(4)));
	            	navelem.setIcon(rs.getString(6));
	            	nav.add(navelem);
	            }  
	            release(rs, stmt);  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        release(rs, stmt);  
	        // 修改返回值变量  
	        return nav;  
	 }
	 
}
