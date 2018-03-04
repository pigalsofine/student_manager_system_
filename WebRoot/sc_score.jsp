<%@page import="java.lang.reflect.Array"%>
<%@page import="dao.Sc_CourseDao"%>
<%@page import="entity.Sc_Course"%>
<%@page import="entity.Tpc_info"%>
<%@page import="dao.Tpc_infoDao"%>
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

  </head>
  <body>
  <!-- START TOP -->
  <div id="top" class="clearfix">
  	<!-- Start App Logo -->
  	<div class="applogo">
  		<a href="" class="logo">欢迎你</a>
  	</div>
  	<a href="" class="btn btn-default">成绩</a>
  	 <ul class="top-right">
  	  <a href="servlet/exitServlet" class="btn btn-default">退出</a>
	</ul> 
  </div>
  <!-- END TOP -->
   			<% 
   				Sc_CourseDao sc_CourseDao = new Sc_CourseDao();
   				String sno = null;
   				ArrayList<Sc_Course> sc_Course_list = new ArrayList<Sc_Course>();
   				if((String)session.getAttribute("username")==null){
	           		 response.sendRedirect("servlet/exitServlet");//请求重定向
	           		 return ;
   				}else{
   					sno = (String)session.getAttribute("username");
   					sc_CourseDao = new Sc_CourseDao();
   					sc_Course_list = sc_CourseDao.getSc_Course_infos((String)session.getAttribute("username"));
   				}
			%>

<!-- //////////////////////////////////////////////////////////////////////////// --> 
<!-- START SIDEBAR -->
<div class="sidebar clearfix">

	<ul class="sidebar-panel nav">
	  <li><a href="#"><span class="icon color7"><i class="fa fa-flask"></i></span>学生学籍管理<span class="caret"></span></a>
	    <ul>
	      <li><a href="">修改密码</a></li>
	      <li><a href="student_baseinfo.jsp">个人信息</a></li>
	      <li><a href="Physical_examination.jsp">体检信息</a></li>
	      <li><a href="rewards_punishments.jsp">奖惩情况</a></li>
	    </ul>
	  </li>
	  <li><a href="#"><span class="icon color7"><i class="fa fa-flask"></i></span>成绩相关<span class="caret"></span></a>
	    <ul>
	      <li><a href="sc_score.jsp">成绩查询</a></li>
	    </ul>
	  </li>
	   <li><a href="#"><span class="icon color7"><i class="fa fa-flask"></i></span>课程信息<span class="caret"></span></a>
	    <ul>
	      <li><a href="student_find_course_info.jsp?grade_num=1">计划查询</a></li>
	      <li><a href="sc.jsp">个人课表</a></li>
	    </ul>
	  </li>
	</ul>
</div>
<div class="content">
<div class="container-padding">
  <!-- Start Row -->
  <div class="row">

    <!-- Start Panel -->
    <div class="col-md-12">
      <div class="panel panel-default">
       
        <div class="panel-body table-responsive">

            <table id="example2" class="table display">
                <thead>
                    <tr>
                        <th>课程号</th>
                        <th>课程名称</th>
                        <th>课程成绩</th>
                        <th>绩点</th>
                    </tr>
                </thead>
             
                <tfoot>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>学分:<%=sc_CourseDao.getTotal_credits(sno) %></th>
                        <th>平均成绩:<%=sc_CourseDao.getAvg_Search(sno) %>	</th>
                    </tr>
                </tfoot>
             
                <tbody>
                <%
             	for(int i=0;i<sc_Course_list.size();i++){
             	%>
                    <tr>
                        <td><%=sc_Course_list.get(i).getCno() %></td>
                        <td><%=sc_Course_list.get(i).getCname() %></td>
                        <td><%=sc_Course_list.get(i).getGrade() %></td>
                        <td><%=sc_Course_list.get(i).getCcredit() %></td>
                    </tr>
				<%} %>      
                </tbody>
            </table>
            

        </div>

      </div>
    </div>
    <!-- End Panel -->




<!-- END SIDEPANEL -->
<!-- //////////////////////////////////////////////////////////////////////////// --> 



<!-- ================================================
jQuery Library
================================================ -->
<script type="text/javascript" src="js/jquery.min.js"></script>

<!-- ================================================
Bootstrap Core JavaScript File
================================================ -->
<script src="js/bootstrap/bootstrap.min.js"></script>

<!-- ================================================
Plugin.js - Some Specific JS codes for Plugin Settings
================================================ -->
<script type="text/javascript" src="js/plugins.js"></script>

<!-- ================================================
Data Tables
================================================ -->
<script src="js/datatables/datatables.min.js"></script>



<script>
$(document).ready(function() {
    $('#example0').DataTable();
} );
</script>



<script>
$(document).ready(function() {
    var table = $('#example').DataTable({
        "columnDefs": [
            { "visible": false, "targets": 2 }
        ],
        "order": [[ 2, 'asc' ]],
        "displayLength": 25,
        "drawCallback": function ( settings ) {
            var api = this.api();
            var rows = api.rows( {page:'current'} ).nodes();
            var last=null;
 
            api.column(2, {page:'current'} ).data().each( function ( group, i ) {
                if ( last !== group ) {
                    $(rows).eq( i ).before(
                        '<tr class="group"><td colspan="5">'+group+'</td></tr>'
                    );
 
                    last = group;
                }
            } );
        }
    } );
 
    // Order by the grouping
    $('#example tbody').on( 'click', 'tr.group', function () {
        var currentOrder = table.order()[0];
        if ( currentOrder[0] === 2 && currentOrder[1] === 'asc' ) {
            table.order( [ 2, 'desc' ] ).draw();
        }
        else {
            table.order( [ 2, 'asc' ] ).draw();
        }
    } );
} );
</script>


</body>
</html>