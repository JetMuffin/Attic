package attic.web.servlet;

import java.io.IOException;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;

import attic.web.dao.AdminDao;
import attic.web.dao.AdminDaoImpl;
import attic.web.model.Admin;

public class Login extends HttpServlet {
	private AdminDao adminDao = new AdminDaoImpl(); 
       

    public Login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setCharacterEncoding("utf-8");  
	      request.setCharacterEncoding("utf-8");  

	      if(select(request,response))
	    	  response.sendRedirect("index/index.jsp");
	      else 
	    	  response.sendRedirect("../login.jsp");
	}
	
    public boolean select(HttpServletRequest request, HttpServletResponse response) {  
        String uid = request.getParameter("uid");  
        String password = request.getParameter("password"); 
        boolean flag;
        Admin entity = new Admin();  
	    HttpSession session=request.getSession(true);
        entity.setUid(uid);  
        entity.setPassword(password);  
        entity = adminDao.select(entity);  
        if (entity!=null) {   
        	flag=true;
            session.setAttribute("admin", entity);  
            session.setAttribute("msg", "登录成功");  
        } else { 
        	flag=false;
        	session.setAttribute("msg","您输入的用户名不存在，或密码不正确，请重新输入！");
        }
        return flag;
    }  

}
