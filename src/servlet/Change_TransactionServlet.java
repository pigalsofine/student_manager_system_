package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClassDao;
import dao.Student_basic_infoDao;
import entity.Class_;

public class Change_TransactionServlet extends HttpServlet {

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
		String  newclsno = "";
		String  spiString = request.getParameter("specialtyName");

		newclsno = request.getParameter("clsno");
		String sno = request.getParameter("sno");
		new Student_basic_infoDao().change_classNo(sno, newclsno);
        //response.sendRedirect("/student_manager_system/registered.jsp");//请求重定向
        response.sendRedirect("/student_manager_system/manager_change_score_success.jsp");//请求重定向

	}
	
}
