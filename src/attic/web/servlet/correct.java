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
import attic.web.dao.QuesDao;
import attic.web.dao.QuesDaoImpl;
import attic.web.model.PracComplt;
import attic.web.model.Question;
import attic.web.model.User;
	
/**
 * @自动批改
 */
@WebServlet("/correct")
public class correct extends HttpServlet {
	QuesDao qd = new QuesDaoImpl();
	PracCompltDao pcd = new PracCompltDaoImpl();
	PracComplt pc = new PracComplt();
	PracComplt pclast = new PracComplt();
	String answer;
	String answerSet="";
	String rightAnswer ;
	String rightAnswerSet="";
	String wrongAnswerSet="";
	boolean flag=true;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public correct() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		String subject = request.getParameter("subject");
		String unit_str = request.getParameter("unit");
		int unit = Integer.parseInt(unit_str);
		String num_str = request.getParameter("quenum");
		int num=Integer.parseInt(num_str);	
		int wrongnum=0,cornum=0,score=0,lastscore=0;
		ArrayList<Question> queSet=qd.select(subject,unit);
		ArrayList<Question> WrongSet = new ArrayList<Question>();
		Question q = new Question();
		User user=(User)session.getAttribute("user");
		String uid = user.getUid();
		
		int i,len;
		len=queSet.size();
		rightAnswerSet="";
		answerSet="";
		
		//答案匹配
		for(i=1;i<=len;i++)
			answerSet+=request.getParameter("question_"+i);
		for(i=0;i<len;i++)
			rightAnswerSet+=queSet.get(i).getAnswer();;	
		for(i=0;i<len;i++)
		{
			if(answerSet.charAt(i)!=rightAnswerSet.charAt(i))
				{
					wrongnum++;
					wrongAnswerSet+=answerSet.charAt(i);
					int id=queSet.get(i).getId();
					q=qd.selectById(id);
					WrongSet.add(q);
				}
		}
		
		cornum=len-wrongnum;
		score=cornum*100/len;
		
		//session存储
		session.setAttribute("rightanswer", rightAnswerSet);
		session.setAttribute("useranswer", answerSet);
		session.setAttribute("wrongset",WrongSet);
		session.setAttribute("wrongnum", wrongnum);
		session.setAttribute("cornum", cornum);
		session.setAttribute("score", score);
		session.setAttribute("wronganswer", wrongAnswerSet);
		session.setAttribute("wrongstatus",flag);
		
		//获取最高分信息
		pclast=pcd.selectUnit(uid,subject,unit);
		lastscore=pclast.getScore();
		
		//存储学生做题记录
		if(lastscore<score)
		{
			pc.setSubject(subject);
			pc.setUnit(unit);
			pc.setUid(uid);
			pc.setScore(score);
			pcd.insert(pc);
		}
		
		String url="report.jsp?subject="+subject+"&unit="+unit;
		response.sendRedirect(url);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
