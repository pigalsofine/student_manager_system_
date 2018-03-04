package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.AndOperator;

import dao.Student_basic_infoDao;
import dao.UserDao;
import entity.Student_basic_info;
import entity.User;


public class dologinServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		System.out.println("doget");
		UserDao userDao = new UserDao();
		//System.out.println(req.getParameter("username")+" "+req.getParameter("password"));
		User user = userDao.is_the_user(request.getParameter("username"), request.getParameter("password"));
		if (user!=null) {
			System.out.println(user.getUsername()+" "+user.getPassword());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost");
		boolean is_student = false; 
		Student_basic_infoDao student_basic_infoDao = new Student_basic_infoDao();
		//���ñ����ʽ��ֹ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		//System.out.println(req.getParameter("username")+" "+req.getParameter("password"));
		HttpSession session = null;
		//�ж��Ƿ��е�½��post����
		if (request.getParameter("username")!=null 
				&& request.getParameter("password")!=null) {
			//�ж��Ƿ��д��û�
			System.out.println(request.getParameter("username")+""+request.getParameter("password"));
			if (request.getParameter("username").equals( "admin")
					&& request.getParameter("password").equals("admin")) {
				session = request.getSession();
	            session.setAttribute("username","admin");
				System.out.println("admid");
	            response.sendRedirect("/student_manager_system/manager_start.jsp");//�����ض���
	            return;
			}
			is_student = student_basic_infoDao.is_student(request.getParameter("username"));
			if (!request.getParameter("password").equals(request.getParameter("username"))) {
				is_student = false;
			}
		}	          
		if (is_student==true) {
			session = request.getSession();
            session.setAttribute("username",request.getParameter("username"));
			
            response.sendRedirect("/student_manager_system/student_start.jsp");//�����ض���
            return;
		}else {
			//����û�������������򷵻ش���session
			session = request.getSession();
            session.setAttribute("loginError", "�����û���������");
            response.sendRedirect("/student_manager_system/login.jsp");//�����ض���
			return  ;
            //req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

}
