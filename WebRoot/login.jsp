<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Kode is a Premium Bootstrap Admin Template, It's responsive, clean coded and mobile friendly">
  <meta name="keywords" content="bootstrap, admin, dashboard, flat admin template, responsive," />
  <title>Kode</title>

  <!-- ========== Css Files ========== -->
  <link href="css/root.css" rel="stylesheet">
  <style type="text/css">
    body{background: #F5F5F5;}
  </style>
  </head>
  <body>
      <% 
        String tips ="";
        if((String)session.getAttribute("username")!=null){
        	if(session.getAttribute("username").equals("admin")
        			){
                response.sendRedirect("/student_manager_system/manager_start.jsp");//请求重定向
        	}else{
                response.sendRedirect("/student_manager_system/student_start.jsp");//请求重定向
        	}
        	
      }
        if((String)session.getAttribute("loginError")!=null){
          tips = (String)session.getAttribute("loginError");
        }
      %>
    <div class="login-form">
      <form action="servlet/dologinServlet" method="post">
        <div class="form-area">
          <div class="group">
          
            <input type="text" class="form-control" name="username">
            <i class="fa fa-user"></i>
          </div>
          <div class="group">
            <input type="password" class="form-control" name="password">
            <i class="fa fa-key"></i>
          </div>
          <button type="submit" class="btn btn-default btn-block">登陆</button>
        </div>
      </form>
    </div>

</body>
</html>