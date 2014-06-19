package attic.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

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





import attic.web.dao.SubjDao;
import attic.web.dao.SubjDaoImpl;
import attic.web.model.Subject;

/**
 * Servlet Filter implementation class SubjectSet
 */
@WebFilter("/SubjectSet")
public class SubjectSet implements Filter {
	private SubjDao subjDao = new SubjDaoImpl(); 
	private ArrayList<Subject> SUBJ_KEY = new ArrayList();
	
    public SubjectSet() {
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse hresponse = (HttpServletResponse) response;    
        HttpServletRequest hrequest=(HttpServletRequest) request;  
		HttpSession session=hrequest.getSession(true);
		
		SUBJ_KEY=subjDao.getAllSubj(); //获取全部科目
		session.setAttribute("subj",SUBJ_KEY);
		session.setAttribute("subj_unit",SUBJ_KEY);
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
