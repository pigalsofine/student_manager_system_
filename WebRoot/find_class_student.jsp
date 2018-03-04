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
  	<a href="" class="btn btn-default">学生基本信息</a>
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
	      <li><a href="registered.jsp">学籍注册</a></li>
	      <li><a href="Transaction_choose.jsp">异动处理</a></li>
	    </ul>
	  </li>
	  <li><a href="#"><span class="icon color7"><i class="fa fa-flask"></i></span>基础数据<span class="caret"></span></a>
	    <ul>
	      <li><a href="manager_student_info.jsp">学生信息</a></li>
	      <li><a href="manager_class_info.jsp">班级信息</a></li>
	      <li><a href="">院系信息</a></li>
	      <li><a href="manager_class_info.jsp">课程信息</a></li>
	    </ul>
	  </li>

	   <li><a href="#"><span class="icon color7"><i class="fa fa-flask"></i></span>成绩管理<span class="caret"></span></a>
	    <ul>
	      <li><a href="find_class_student.jsp">成绩查询</a></li>
	      <li><a href="manager_change_score_choose.jsp">成绩修改</a></li>
	    </ul>
	  </li>
	  <li><a href="#"><span class="icon color7"><i class="fa fa-flask"></i></span>其他<span class="caret"></span></a>
	    <ul>
	      <li><a href="manager_find_discipline_student.jsp">获奖情况</a></li>
	      <li><a href="manager_find_discipline_student.jsp">惩罚情况</a></li>
	      <li><a href="manager_find_discipline_student.jsp">体检情况</a></li>
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
					
                    	<th>院系</th>
                        <th>专业</th>
                        <th>班级</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                        	<div class="dropdown">
			                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
			                      请选择
			                      <span class="caret"></span>
			                    </button>
			                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">信息工程系</a></li>
			                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">建筑工程系</a></li>
			                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">化工系</a></li>
			                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">商学系</a></li>
			                    </ul>
                    		</div>
                     	</td>
                        <td>
                        	<div class="dropdown">
			                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
			                      请选择
			                      <span class="caret"></span>
			                    </button>
			                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
			                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
			                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
			                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
			                    </ul>
                    		</div>
                        </td>
                        <td>
                        	<div class="dropdown">
			                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
			                      请选择
			                      <span class="caret"></span>
			                    </button>
			                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
			                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
			                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
			                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
			                    </ul>
                    		</div>
                        </td> 
                    <tr><td></td><td></td><td></td></tr>
                    <<tr><td></td><td></td><td><a href="#" class="btn btn-rounded">确认</a></td></tr>
                    <tr><td></td><td></td><td></td></tr>
                </tbody> 

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