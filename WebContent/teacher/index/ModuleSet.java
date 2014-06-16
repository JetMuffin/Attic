package attic.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import attic.web.model.Node;
import attic.web.dao.NodeDao;
import attic.web.dao.NodeDaoImpl;

@WebServlet("/ModuleSet")
public class ModuleSet extends HttpServlet {
	private NodeDao nodeDao = new NodeDaoImpl(); 
	private ArrayList<Node> NAV_KEY = new ArrayList();
    private String PAGE_NAME;
    
    public ModuleSet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int start = PAGE_NAME.lastIndexOf("/");
		PAGE_NAME = request.getServletPath();
		PAGE_NAME = PAGE_NAME.substring(1,start); 
		start = PAGE_NAME.lastIndexOf("/");
		PAGE_NAME = PAGE_NAME.substring(start+1); //获取当前模块名，待改善
		
		NAV_KEY=nodeDao.getAllNav();
		
		HttpSession session=request.getSession(true);
		session.setAttribute("module_name",PAGE_NAME);
		session.setAttribute("nav",NAV_KEY);
		session.setAttribute("nav_son",NAV_KEY);
		
		System.out.println("success!");
	}

}
