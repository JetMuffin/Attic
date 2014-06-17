package attic.web.servlet;

import java.io.IOException;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;

import attic.web.dao.*;
import attic.web.model.*;


public class Login extends HttpServlet {
	private UserDao userDao = new UserDaoImpl(); 
    private StuDao stuDao = new StuDaoImpl();   
    private User entity = new User();
    private	Student stu = new Student();
    
    public Login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setCharacterEncoding("utf-8");  
	      request.setCharacterEncoding("utf-8");  

	      if(select(request,response)){
	    	  HttpSession session=request.getSession(true);
	    	  if(entity.getAuthority()==1)
	    	  {
	    		  stu.setUid(entity.getUid());
	    		  stu = stuDao.select(stu);
	    		  session.setAttribute("stu", stu);
	    		  response.sendRedirect("moduleIndex");
	    	  } //�û�Ϊѧ��
	    		 
	    	  if(entity.getAuthority()==2)
	    		  response.sendRedirect("moduleIndex");
	    	  //TODO ��ʦ�ӿ�ʵ��
	      }
	      else 
	    	  response.sendRedirect("login.jsp");
	}
	
    public boolean select(HttpServletRequest request, HttpServletResponse response) {  
        String uid = request.getParameter("uid");  
        String password = request.getParameter("password"); 
        boolean flag;
          
	    HttpSession session=request.getSession(true);
        entity.setUid(uid);  
        entity.setPassword(password);  
        entity = userDao.select(entity);
        if (entity!=null) {   
        	flag=true;
            session.setAttribute("user", entity);  
            session.setAttribute("msg", "��¼�ɹ�"); 
        } else { 
        	flag=false;
        	session.setAttribute("msg","��������û��������ڣ������벻��ȷ�����������룡");
        }
        return flag;
    }  

}
