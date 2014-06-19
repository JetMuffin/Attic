package attic.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

import attic.web.dao.PracCompltDao;
import attic.web.dao.PracCompltDaoImpl;
import attic.web.model.PracComplt;
import attic.web.model.User;

/**
 * @获取用户已完成练习
 */
@WebFilter("/GetUserAc")
public class GetUserAc implements Filter {


    public GetUserAc() {

    }


	public void destroy() {
	
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletResponse hresponse = (HttpServletResponse) response;    
         HttpServletRequest hrequest=(HttpServletRequest) request;  
		HttpSession session=hrequest.getSession(true);
		User user = (User)session.getAttribute("user"); 
		ArrayList <PracComplt> ps=(ArrayList)session.getAttribute("userPracSet");
		if(ps==null&&user!=null)
		{
			String uid=user.getUid();
			PracCompltDao pcDao = new PracCompltDaoImpl();
			ps = pcDao.select(uid);	
			Map<String, Integer> pcmp =getStrArrayMapResult(ps);
			session.setAttribute("userPracSet",ps);
			session.setAttribute("pcmp",pcmp);
		}
		chain.doFilter(request, response);
	}
	
	 private static Map<String, Integer> getStrArrayMapResult(ArrayList <PracComplt> ps) {  
	        Map<String, Integer> map = new HashMap<String, Integer>();  
	        for(int i = 0;i < ps.size(); i ++) {  
	            // 如果为空 说明是该键是第一次put进map  
	        	PracComplt pc =(ps.get(i)); 
	            String subject=pc.getSubject();
	            if (map.get(subject) == null) {  
	                map.put(subject, new Integer(1));  
	            } else {  
	                // 不为空则覆盖其键，并将其值递增加1 用以计算其出现的次数  
	                map.put(subject, map.get(subject) + 1);  
	            }  
	        }  
	        return map;  
	    }  


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
