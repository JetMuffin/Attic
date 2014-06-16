package attic.web.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

/*
 ** @常量定义
 */

public class StaticWords extends HttpServlet {
	public static String __ROOT__;
    public static String __PUBLIC__;
    public static String __PLUGIN__;
    public static String __UPLOAD__;
    public static String __NAME__;

    public StaticWords() {
        super();
    }

    public void init() throws ServletException {  
		ServletContext application = this.getServletContext();
		
		__ROOT__ = "/Attic";
		__PUBLIC__ = __ROOT__ + "/public";
		__PLUGIN__	= __ROOT__ + "/public/plugins";
		__UPLOAD__ =  __ROOT__ + "/public/upload";
		__NAME__ = "在线练习系统";
		
		application.setAttribute("WEBROOT", __ROOT__);
		application.setAttribute("PUBLIC", __PUBLIC__);
		application.setAttribute("PLUGIN", __PLUGIN__);
		application.setAttribute("UPLOAD", __UPLOAD__);
		application.setAttribute("NAME", __NAME__);
    }  
}
