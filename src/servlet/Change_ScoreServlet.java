package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Tpc_infoDao;

public class Change_ScoreServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in servlet/DoClass_base_info");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
		
		String cno = request.getParameter("cno");
		String sno = request.getParameter("sno");
		String score = request.getParameter("score");
		int intscore = Integer.parseInt(score);
		System.out.println(cno+" "+sno+" "+intscore);
		new Tpc_infoDao().change_score(sno, cno, intscore);
		
        response.sendRedirect("/student_manager_system/manager_change_score_success.jsp");//请求重定向

	}
	
}
