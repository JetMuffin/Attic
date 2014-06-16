package attic.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet{
	public void init(ServletConfig config) throws ServletException
    { 
		super.init(config);
    }
    public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
    		HttpSession session=request.getSession(true);
        	session.removeAttribute("admin"); 
        	session.invalidate(); 
            response.sendRedirect("../login.jsp");
    }
}
