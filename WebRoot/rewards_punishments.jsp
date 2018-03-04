<%@page import="entity.Awarding"%>
<%@page import="dao.AwardingDao"%>
<%@page import="entity.Punishment"%>
<%@page import="dao.PunishmentDao"%>
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
  	<a href="" class="btn btn-default">奖惩信息</a>
  	 <ul class="top-right">
  	  <a href="servlet/exitServlet" class="btn btn-default">退出</a>
	</ul> 
  </div>
  <!-- END TOP -->


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
   			<% 
   				PunishmentDao punishmentDao = null;
   				AwardingDao awardingDao = null;
   				ArrayList<Awarding> awarding_list = new ArrayList<Awarding>();
   				ArrayList<Punishment> punishment_list = null;
   				if((String)session.getAttribute("username")==null){
	           		 response.sendRedirect("servlet/exitServlet");//请求重定向
	           		 return ;
   				}else{
   					punishmentDao = new PunishmentDao();
   					punishment_list = punishmentDao.getPunishment_infos_with_sno((String)session.getAttribute("username"));
   					awardingDao = new AwardingDao();
   					awarding_list = awardingDao.getAwarding_infos_with_sno((String)session.getAttribute("username"));
   				
   				}
			%>
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
                        <th>获奖时间</th>
                        <th>奖项名称</th>
                        <th>成员学号</th>
                    </tr>
                </thead>
             	<%for(int  i=0;i<awarding_list.size();i++){ %>
                <tbody>
                    <tr>
                        <td><%=awarding_list.get(i).getAdate() %></td>
                        <td><%=awarding_list.get(i).getPrize() %></td>
                        <td><%=awarding_list.get(i).getSno() %></td>
                    </tr>       
                </tbody>
                <%}%>
            </table>

        </div>


      </div>
      <div class="panel panel-default">
       
        <div class="panel-body table-responsive">

            <table id="example3" class="table display">
                <thead>
                    <tr>
                        <th>惩罚时间</th>
                        <th>惩罚原因</th>
                    </tr>
                </thead>
            	 <% 
            	 	for(int i=0;i<punishment_list.size();i++){
            	 
            	 %>	
                <tbody>
                    <tr>
                        <td><%=punishment_list.get(i).getPdate() %></td>
                        <td><%=punishment_list.get(i).getPunish() %></td>
                    </tr>       
                </tbody>
                <%
                	}
                
                %>
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