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

/*
 * @模块路由
 */

public class ModuleSet extends HttpServlet {
	private NodeDao nodeDao = new NodeDaoImpl(); 
	private ArrayList<Node> NAV_KEY = new ArrayList();
    private String action_name ;
    private String module_name ;
    private String uri;
    
    public ModuleSet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		HttpSession session=request.getSession(true);
		
		action_name = request.getParameter("action_name");
		module_name = request.getParameter("module_name");

		session.setAttribute("action_name",action_name);
		session.setAttribute("module_name",module_name);

		
		NAV_KEY=nodeDao.getAllNav(); //获取全部菜单
		session.setAttribute("nav",NAV_KEY);
		session.setAttribute("nav_son",NAV_KEY);
		

		uri = "../" + module_name + "/" + action_name +".jsp";
		response.sendRedirect(uri);		
	}
}
