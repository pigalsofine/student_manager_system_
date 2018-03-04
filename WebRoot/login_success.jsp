<%@ page language="java" import="java.util.* ,dao.*,entity.*,javax.servlet.http.HttpSession" contentType="text/html; charset=utf-8"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" href="src/semantic.min.css">
<script src="http://upcdn.b0.upaiyun.com/libs/jquery/jquery-2.0.2.min.js"></script>
<script src="src/semantic.min.js"></script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login_success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>欢迎登陆成功</h1>
    <%
		String loginUser = "";
		if(session.getAttribute("username")!=null){
			loginUser = session.getAttribute("username").toString();
		}else {
			response.sendRedirect("servlet/exitServlet");//请求重定向
		}
    %>
    
    <%!
    	HttpSession session = null;
    	void clean_username_session(){
    		if(session.getAttribute("username")!=null){
    			session.removeAttribute("username");
			}
    	}
    %>
    	<br>
    	<div class="ui form segment">
    	欢迎你<%=loginUser %>
    	<form action="servlet/exitServlet" method="post">
   			<table>
   				<tr>
    				<td c1olspan="2" >  <input type="submit" value="退出"></td>
    			</tr>
   			</table>
   		</form>
   		
   		<hr>
   		详细信息
   		<hr>
   	
   			
   		</table>
    </div>
    
  </body>
</html>
