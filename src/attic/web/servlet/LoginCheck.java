package attic.web.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attic.web.model.User;

/**
 * @µÇÂ¼À¹½ØÆ÷
 */
@WebFilter("/LoginCheck")
public class LoginCheck implements Filter {

    public LoginCheck() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletResponse hresponse = (HttpServletResponse) response;    
         HttpServletRequest hrequest=(HttpServletRequest) request;  
		HttpSession session=hrequest.getSession(true);
		User user = (User)session.getAttribute("user"); 
	    response.setCharacterEncoding("utf-8");  
	    request.setCharacterEncoding("utf-8");
		if(user==null)
		{
			session.setAttribute("msg","ÇëÏÈµÇÂ¼£¡");
			hresponse.sendRedirect("../../login.jsp");
		}
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
