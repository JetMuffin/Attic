package attic.web.servlet;

import java.io.IOException;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

import attic.web.dao.AdminDao;
import attic.web.dao.AdminDaoImpl;
import attic.web.model.Admin;

public class Register extends HttpServlet {
	private AdminDao adminDao = new AdminDaoImpl(); 
    

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
	    	  request.getRequestDispatcher("login.jsp").forward(request, response); 
	      else 
	    	  request.getRequestDispatcher("register.jsp").forward(request, response); 
	}
	
    public boolean insert(HttpServletRequest request, HttpServletResponse response) {  
        String uid = request.getParameter("uid");  
        String password = request.getParameter("password");  
        Admin entity = new Admin();  
        entity.setUid(uid);  
        entity.setPassword(password);  
        boolean flag = adminDao.insert(entity);  
        if (flag) {  
            System.out.println("ע��ɹ�");
            request.setAttribute("msg", "ע��ɹ������¼");  
        } else {  
            System.out.println("ע��ʧ��");
            request.setAttribute("msg", "ע��ʧ��");  
        } 
        return flag;
    }

}
