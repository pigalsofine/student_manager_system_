package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Student_basic_infoDao;

public class Change_ResgisterServlet extends HttpServlet {

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
		String sno = null;
		System.out.println("int the post");
		HttpSession session = null;
		session = request.getSession();

        if((String)session.getAttribute("disciplineNo")!=null)
        {
             disciplineNo = (String)session.getAttribute("disciplineNo");
             System.out.println(disciplineNo);	
      	}
        if (request.getParameter("sno")!=null) {
        	sno = request.getParameter("sno");
        }else {
			System.out.println("sno is null");
		}
        System.out.println("sno is "+sno);
        new Student_basic_infoDao().setRegister_info(sno);
        response.sendRedirect("/student_manager_system/registered.jsp");//请求重定向
	}

}
