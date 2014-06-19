package attic.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import attic.web.model.PracComplt;
import attic.web.model.User;

public class PracCompltDaoImpl implements PracCompltDao{
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
	 
	 public ArrayList<PracComplt> select(String uid) {   
	        // ����sql���  
	        String sql = "select * from att_achieve where uid=?";  
	        ArrayList<PracComplt> pcSet=new ArrayList<PracComplt>();
	        try {  
	            // ����
	        	pstmt = conn.prepareStatement(sql);  
	            // Ϊռλ����ֵ  
	        	pstmt.setObject(1,uid);
	            // ִ�и���  
	            rs = pstmt.executeQuery();  
	            while (rs.next()) { 
	            	PracComplt pc = new PracComplt();
	            	pc.setSubject(rs.getString(2));
	            	pc.setUnit(Integer.parseInt(rs.getString(3)));
	            	pc.setScore(Integer.parseInt(rs.getString(4)));
	            	pcSet.add(pc);
	            }  
	            release(rs, pstmt);  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        release(rs, pstmt);  
	        // �޸ķ���ֵ����  
	        return pcSet;  
	    } 
	 
	 public PracComplt selectUnit(String uid,String subject,int unit) {   
	        // ����sql���  
	        String sql = "select * from att_achieve where uid=? and subject=? and unit=?";  
	        PracComplt pc=new PracComplt();
	        try {  
	            // ����
	        	pstmt = conn.prepareStatement(sql);  
	            // Ϊռλ����ֵ 
	        	int index=1;
	        	pstmt.setObject(index++,uid);
	        	pstmt.setObject(index++,subject);
	        	pstmt.setObject(index++,unit);
	            // ִ�и���  
	            rs = pstmt.executeQuery();  
	            if (rs.next()) { 
	            	pc.setUid(uid);
	            	pc.setSubject(subject);
	            	pc.setUnit(unit);
	            	pc.setScore(Integer.parseInt(rs.getString(4)));
	            }  
	            else{
	            	pc.setUid(uid);
	            	pc.setSubject(subject);
	            	pc.setUnit(unit);
	            	pc.setScore(0);
	            }
	            release(rs, pstmt);  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        release(rs, pstmt);  
	        // �޸ķ���ֵ����  
	        return pc;  
	    } 
	 
	 public int selectCount(String subject)
	 {
		 int count=0;
		 String sql = "select count(*) as scount from att_achieve where subject=?"; 
		  try {  
	            // ����
	        	pstmt = conn.prepareStatement(sql);  
	            // Ϊռλ����ֵ  
	        	pstmt.setObject(1,subject);
	            // ִ�и��� 
	            rs = pstmt.executeQuery();  
	            rs.next();
	            count = rs.getInt("scount");
	            release(rs, pstmt);  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        release(rs, pstmt);  
	        // �޸ķ���ֵ����  
	        return count;  
	 }
	 
	  public boolean insert(PracComplt pc) {  
	        boolean flag = false;  
	        String sql = "insert into att_achieve(subject,unit,score,uid) values(?,?,?,?)";  
	        try {  
	            pstmt = conn.prepareStatement(sql);  
	            int index = 1;  
	            pstmt.setObject(index++, pc.getSubject());  
	            pstmt.setObject(index++, pc.getUnit()); 
	            pstmt.setObject(index++, pc.getScore());
	            pstmt.setObject(index++, pc.getUid()); 
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
