<%@page import="entity.Class_"%>
<%@page import="dao.ClassDao"%>
<%@page import="entity.Specialty"%>
<%@page import="dao.SpecialtyDao"%>
<%@page import="entity.Student_basic_info"%>
<%@page import="dao.Student_basic_infoDao"%>
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
  	<a href="" class="btn btn-default">异动处理</a>
  	 <ul class="top-right">
  	  <a href="servlet/exitServlet" class="btn btn-default">退出</a>
	</ul> 
  </div>
  <!-- END TOP -->
 <%
	String loginUser = "";
	if(session.getAttribute("username")==null
		||!session.getAttribute("username").equals("admin")
		||!session.getAttribute("username").equals("admin")){
		response.sendRedirect("servlet/exitServlet");//请求重定向
		
	}else {
				loginUser = session.getAttribute("username").toString();
	
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
					
                    	<th>原年级</th>
                        <th>原院系</th>
                        <th>原专业</th>
                        <th>原班级</th>
                    </tr>
                </thead>
                <% 
                	String sno = "";
                	if(request.getParameter("sno")!=null){
                		sno = request.getParameter("sno");
                	}
                	Student_basic_infoDao student_basic_infoDao = new Student_basic_infoDao();
                	Student_basic_info student_basic_info = student_basic_infoDao.getBasic_info(sno);
                	
                %>
                <tbody>
                    <tr>
        				<td><%=student_basic_info.getEnterYear() %></td>
        				<td><%=student_basic_info.getFaculty() %></td>
        				<td><%=student_basic_info.getSpecialtyName() %></td>
        				<td><%=student_basic_info.getClsname() %></td>
                    <tr>
                </tbody> 

            </table>

        </div>
    </div>
    <div class="panel panel-default">
       
        <div class="panel-body table-responsive">

            <table id="example3" class="table display">
                <thead>
                    <tr>
					
                    	<th>选择现年级</th>
                        <th>选择现院系</th>
                        <th>选择现专业</th>
                        <th>选择现班级</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
        				<td>

        					<div class="btn-group">
			                    <button type="button" class="btn btn-light">请选择</button>
			                    <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
			                      <span class="caret"></span>
			                      <span class="sr-only">Toggle Dropdown</span>
			                    </button>

			                    <ul class="dropdown-menu" role="menu">
			                      <li><a href="#">1</a></li>
			                      <li><a href="#">2</a></li>
			                      <li><a href="#">3</a></li>
			                      <li><a href="#">4</a></li>
			                    </ul>
		                  	</div>
        				</td>
        				<%
	                    	SpecialtyDao specialtyDao = new SpecialtyDao();
	                    	ArrayList<Specialty> specialty_list = specialtyDao.getAllFA();
	                    	String url4 = "";
	                    	String url3 = "";
			            %>
        				<td>
        					<div class="btn-group">
			                    <button type="button" class="btn btn-light">请选择</button>
			                    <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
			                      <span class="caret"></span>
			                      <span class="sr-only">Toggle Dropdown</span>
			                    </button>
			                    <ul class="dropdown-menu" role="menu">
			                      <%
			                      	for(int i=0;i<specialty_list.size();i++){
	                    			String url = "transaction.jsp?sno="+sno+"&faculty="
	                    			+specialty_list.get(i).getFaculty().toString();
			                      %>
			                      <li><a href=<%=url %>><%=specialty_list.get(i).getFaculty() %></a></li>
			                     <%
			                     	}
			                     %>
			                    </ul>
		                  	</div>

        				</td>
        				<td>
        					<div class="btn-group">
			                    <button type="button" class="btn btn-light">请选择</button>
			                    <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
			                      <span class="caret"></span>
			                      <span class="sr-only">Toggle Dropdown</span>
			                    </button>
			                    <ul class="dropdown-menu" role="menu">
			                      
			                      <% 
			                      	String faculty = "";
			                      	if(request.getParameter("faculty")!=null){
			                      		faculty = request.getParameter("faculty");
			                      		System.out.print(faculty); 	
			                      		specialty_list = specialtyDao.getSpe_accoding_fa(faculty);
			                      	
			                      	
			                      	
			                      	for(int i=0;i<specialty_list.size();i++){
			                      		String url2 = "transaction.jsp?sno="+sno+"&faculty="
			                      		+faculty+"&specialtyName="
			                      		+specialty_list.get(i).getSpecialtyName();
			                      %>
			                      <li><a href=<%=url2 %>>
			                      <%=specialty_list.get(i).getSpecialtyName() %></a></li>
													                  <% 
				                  	}} 	
				                  %>
			                    </ul>
		                  	</div>
        				</td>
        				<td>
        					<div class="btn-group">
			                    <button type="button" class="btn btn-light">请选择</button>
			                    <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
			                      <span class="caret"></span>
			                      <span class="sr-only">Toggle Dropdown</span>
			                    </button>
			                    <ul class="dropdown-menu" role="menu">
			                    			                      <% 
			                      	String specialtyName = "";
			                      	ClassDao classDao = new ClassDao();
			                      	ArrayList<Class_> class_list = new ArrayList<Class_>();
			                      	if(request.getParameter("specialtyName")!=null){
			                      		specialtyName = request.getParameter("specialtyName");
			                      		
			                      		class_list = classDao.getClass_accoding_clsName(specialtyName);

			                      	for(int i=0;i<class_list.size();i++){
			                      	url3 = "transaction.jsp?sno="+sno+"&faculty="
			                      		+faculty+"&specialtyName="+specialtyName+"&clsno="
			                      		+class_list.get(i).getClsno();
			                      	 
			                      %>
			                      <li><a role="menuitem" tabindex="-1" href=<%=url3 %>>
			                      <%=class_list.get(i).getClsno()+" "+class_list.get(i).getClsname() %></a></li>
													                  <% 
				                  	}	
				                  	}
				                  %>
			                      
			                   
			                    </ul>
		                  	</div>
        				</td>
        				
                    
                   	<tr><td></td><td></td><td></td><td></td></tr>
                   	<tr><td></td><td></td><td></td><td></td></tr>
                   	<tr><td></td><td></td><td></td>
                   		<td>
                   		<%
                   			//if(request.getParameter("classname")!=null)
                   		 		url4 = "servlet/Change_TransactionServlet?sno="+request.getParameter("sno")+
                   		 			"&faculty="+request.getParameter("faculty")+
                   		 			"&specialtyName="+request.getParameter("specialtyName")+
                   		 			"&clsno="+request.getParameter("clsno");
                   		 			
       							
                   		 %>
                   			<a href=<%=url4 %> class="btn btn-rounded">确认</a>
                   		</td>
                   	</tr>
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