package attic.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
@WebServlet("/GetAchieve")
public class GetAchieve extends HttpServlet {
	private ArrayList <PracComplt> ps = new ArrayList();
    private PracCompltDao pcDao = new PracCompltDaoImpl();
    
    public GetAchieve() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		User user=(User)session.getAttribute("user");
		String uid=user.getUid();
		
		ps = pcDao.select(uid);
		
		session.setAttribute("userPracSet",ps);
		response.sendRedirect("total.jsp");
	}
}
