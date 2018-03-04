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
import dao.PunishmentDao;
import dao.Student_basic_infoDao;
import entity.Awarding;

public class Add_CheckServlet extends HttpServlet {

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
		String four = "four"+String.valueOf(i);
		Check_upDao check_upDao = new Check_upDao();
		String sno = "";
		String h = "";
		String w = "";
		String tvc = "";
		while (request.getParameter(one)!=null
				&& request.getParameter(two)!=null
					&& request.getParameter(three)!=null
						&& request.getParameter(four)!=null) {
			i++;
			sno = request.getParameter(one);
			h = request.getParameter(two);
			w = request.getParameter(three);
			tvc = request.getParameter(four);
			check_upDao.add_punishment_info(sno, Integer.parseInt(h), 
					Integer.parseInt(w), Integer.parseInt(tvc));
			System.out.println(sno);
			System.out.println(h);
			System.out.println(w);
			System.out.println(tvc);
			one = "one"+String.valueOf(i);
			two = "two"+String.valueOf(i);
			three = "three"+String.valueOf(i);
			four = "four"+String.valueOf(i);
		}
        response.sendRedirect("/student_manager_system/manager_change_score_success.jsp");
	}

}
