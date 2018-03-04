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
  	<a href="" class="btn btn-default">查询成绩</a>
  	 <ul class="top-right">
  	  <a href="servlet/exitServlet" class="btn btn-default">退出</a>
	</ul> 
  </div>
  <!-- END TOP -->

<%
	String discipline = "";
	if(session.getAttribute("username")==null
		||!session.getAttribute("username").equals("admin")
		||!session.getAttribute("username").equals("admin")){
		response.sendRedirect("servlet/exitServlet");//请求重定向
		
	}else {
		discipline = request.getParameter("discipline");
		System.out.print(discipline);
	}
%>
<!-- //////////////////////////////////////////////////////////////////////////// --> 
<!-- START SIDEBAR -->
<div class="sidebar clearfix">

	<ul class="sidebar-panel nav">
	  <li><a href="#"><span class="icon color7"><i class="fa fa-flask"></i></span>学生学籍管理<span class="caret"></span></a>
	    <ul>
	      <li><a href="manager_find_discipline_student_regiest.jsp?faname=建筑工程系">学籍注册</a></li>
	      <li><a href="transaction_find_class_student.jsp?faname=信息工程系&specialtyName=计算机001班">异动处理</a></li>
	    </ul>
	  </li>
	  <li><a href="#"><span class="icon color7"><i class="fa fa-flask"></i></span>基础数据<span class="caret"></span></a>
	    <ul>
	      <li><a href="manager_find_class_student_base_info.jsp?faname=信息工程系&specialtyName=计算机001班">学生信息</a></li>
	      <li><a href="manager_find_discipline_class.jsp?faname=信息工程系&specialtyName=计算机001班">班级信息</a></li>
	      <li><a href="">院系信息</a></li>
	      <li><a href="manager_find_course_info.jsp?grade_num=1">课程信息</a></li>
	    </ul>
	  </li>

	   <li><a href="#"><span class="icon color7"><i class="fa fa-flask"></i></span>成绩管理<span class="caret"></span></a>
	    <ul>
	      <li><a href="score_find_class_student.jsp?faname=信息工程系&specialtyName=计算机001班">成绩查询</a></li>
	      <li><a href="manager_change_score_choose.jsp">成绩修改</a></li>
	    </ul>
	  </li>
	  <li><a href="#"><span class="icon color7"><i class="fa fa-flask"></i></span>其他<span class="caret"></span></a>
	    <ul>
	      <li><a href="manager_find_rewards.jsp?faname=信息工程系&specialtyName=计算机001班">获奖情况</a></li>
	       <li><a href="manager_find_punish.jsp?faname=信息工程系&specialtyName=计算机001班">惩罚情况</a></li>
	      <li><a href="manager_find_checkup.jsp?faname=信息工程系&specialtyName=计算机001班">体检情况</a></li>
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

            <table id="example3" class="table display">
                <thead>
                    <tr>
					
                    	<th>年级</th>
                        <th>学号</th>
                        <th>课程号</th>
                        <th>课程名</th>
                        <th>成绩</th>
                        <th>绩点</th>
                    </tr>
                </thead>
                
                <%
                	String clsno = "";
                    if((String)session.getAttribute("clsno")!=null)
			        {
			             clsno = (String)session.getAttribute("clsno");
			             System.out.println(clsno);	
			      	}
			      	Tpc_infoDao tpc_infoDao = new Tpc_infoDao();
			      	ArrayList<Tpc_info> tpc_info_list = tpc_infoDao.getTpc_score_with_clsno(clsno);
			      	for(int i=0;i<tpc_info_list.size();i++){
                %>
                <tbody>
                
                    <tr>
        				<td><%=tpc_info_list.get(i).getGrade() %></td>
        				<td><%=tpc_info_list.get(i).getSno() %></td>
        				<td><%=tpc_info_list.get(i).getCno() %></td>
        				<td><%=tpc_info_list.get(i).getCname() %></td>
        				<td><%=tpc_info_list.get(i).getScore() %></td>
        				<td><%=tpc_info_list.get(i).getCcredit()%></td>

                    <tr>
                </tbody> 
				<%} %>
            </table>

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