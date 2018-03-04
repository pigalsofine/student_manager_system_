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


public class Choose_FacultyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost");
		//…Ë÷√±‡¬Î∏Ò Ω∑¿÷π¬“¬Î
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		if (request.getParameter("username")!=null) {
			
			System.out.println(request.getParameter("username"));
		}else {
			System.out.println("no");
		}
	}

}
