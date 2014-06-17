package attic.web.servlet;

import java.io.IOException;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;

import attic.web.dao.*;
import attic.web.model.*;

public class Register extends HttpServlet {
	private UserDao userDao = new UserDaoImpl(); 
    private StuDao stuDao = new StuDaoImpl();
    private User entity = new User();  
    private Student stu = new Student();
    
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setCharacterEncoding("utf-8");  
	      request.setCharacterEncoding("utf-8");  
	      if(insert(request,response))
	      {
	    	  stu.setUid(entity.getUid());
	    	  stu.setName(entity.getName());
	    	  stuDao.insert(stu);
	    	  response.sendRedirect("login.jsp");
	      }
	      else 
	    	  response.sendRedirect("register.jsp");
	}
	
    public boolean insert(HttpServletRequest request, HttpServletResponse response) {  
    	HttpSession session=request.getSession(true);
    	String uid = request.getParameter("uid");  
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        entity.setUid(uid);  
        entity.setPassword(password);  
        entity.setName(firstname+lastname);
        entity.setAuthority(1);
        boolean flag = userDao.insert(entity);  
        if (flag) {  
            System.out.println("×¢²á³É¹¦");
            session.setAttribute("msg", "×¢²á³É¹¦£¬ÇëµÇÂ¼");             
        } else {  
            System.out.println("×¢²áÊ§°Ü");
            session.setAttribute("msg", "×¢²áÊ§°Ü");  
        } 
        return flag;
    }

}
