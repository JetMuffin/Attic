package attic.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attic.web.dao.StuDao;
import attic.web.dao.StuDaoImpl;
import attic.web.dao.UserDao;
import attic.web.dao.UserDaoImpl;
import attic.web.model.Student;
import attic.web.model.User;

/**
 * @更新个人信息
 */

public class UpdateInfo extends HttpServlet {
	private UserDao userDao = new UserDaoImpl(); 
    private StuDao stuDao = new StuDaoImpl();
    private User entity = new User();  
    private Student stu = new Student();
    
    public UpdateInfo() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");  
	    request.setCharacterEncoding("utf-8"); 
		
		HttpSession session=request.getSession(true);
		stu = (Student)session.getAttribute("stu");
		entity = (User)session.getAttribute("user");
		
		String password = request.getParameter("password");
		password = MD5Util.MD5(password);
        String name = request.getParameter("name");
        String sex_str = request.getParameter("sex");
        int sex = Integer.parseInt(sex_str);
        String school = request.getParameter("school");
        String major = request.getParameter("major");
        String grade = request.getParameter("grade");
        String classes = request.getParameter("classes");
        
        stu.setName(name);
        stu.setClasses(classes);
        stu.setGrade(grade);
        stu.setMajor(major);
        stu.setSchool(school);
        stu.setSex(sex);
        
        //System.out.println(school);
        //System.out.println(grade);
        //System.out.println(major);
        entity.setPassword(password);
        
        if(userDao.update(entity)&&stuDao.update(stu))
        {
        	session.setAttribute("msg", "修改信息成功！");
        	response.sendRedirect("../../success.jsp");
        }
        else
        {
        	session.setAttribute("msg", "修改信息失败！");
        	response.sendRedirect("../../error.jsp");
        }
        
	}	

}
