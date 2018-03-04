package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DoClass_base_info extends HttpServlet {

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
		
		String disciplineNo = request.getParameter("disciplineNo");
		HttpSession session = null;
		session = request.getSession();
        session.setAttribute("disciplineNo",disciplineNo);
		System.out.println(disciplineNo);
        response.sendRedirect("/student_manager_system/manager_class_info.jsp");//请求重定向
	}
	
}
