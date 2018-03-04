package servlet;

import java.io.IOException;

import javax.lang.model.element.Element;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AwardingDao;
import dao.Check_upDao;
import dao.Student_basic_infoDao;
import entity.Awarding;

public class Add_AwardingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		String disciplineNo = null;

		System.out.println("int the post");
		int i=0;
		String one = "one"+String.valueOf(i);
		String two = "two"+String.valueOf(i);
		String three = "three"+String.valueOf(i);
		AwardingDao awardingDao = new AwardingDao();
		String sno = "";
		String pr = "";
		String ad = "";
		while (request.getParameter(one)!=null
				&& request.getParameter(two)!=null
					&& request.getParameter(three)!=null) {
			i++;
			sno = request.getParameter(one);
			pr = request.getParameter(two);
			ad = request.getParameter(three);
			awardingDao.add_awarding_info(sno, pr, ad);
			System.out.println(sno);
			System.out.println(pr);
			System.out.println(ad);
			one = "one"+String.valueOf(i);
			two = "two"+String.valueOf(i);
			three = "three"+String.valueOf(i);
		}
	    response.sendRedirect("/student_manager_system/manager_change_score_success.jsp");


	}
	
}
