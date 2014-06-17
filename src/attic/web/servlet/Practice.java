package attic.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import attic.web.dao.QuesDao;
import attic.web.dao.QuesDaoImpl;
import attic.web.model.Question;
/**
 * @获得习题库
 */

public class Practice extends HttpServlet {
	private ArrayList <Question> qs = new ArrayList();
    private QuesDao quesdao = new QuesDaoImpl();

    public Practice() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String subject = request.getParameter("subject");
			String unit_str = request.getParameter("unit");
			int unit = Integer.parseInt(unit_str);
			HttpSession session=request.getSession(true);
			
			qs = quesdao.select(subject, unit);

			//TODO 题库按序号排序
			/*Comparator comparator = new QComparator();
			Collections.sort(qs, comparator); */   
			
			session.setAttribute("queset",qs);
			session.setAttribute("subject",subject);
			session.setAttribute("unit",unit);
			String url = "unit.jsp?subject=" + subject + "&unit=" + unit;
			response.sendRedirect(url);
	}				
}

class QComparator implements Comparator<Question> {  
	  
    public int compare(Question q1, Question q2) {  
        if(q1.getNumber() > q2.getNumber())
        		return 1;
        else return -1;
    }   
} 
