<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>学生任务</title>
		<link rel="stylesheet" href="css/amazeui.min.css" />
		<link rel="stylesheet" href="css/admin.css" />
</head>
<body>
	
	<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">查看任务</strong><small></small></div>
			</div>

			<hr>

			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							
						</div>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">

				</div>
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-input-group am-input-group-sm">
          </span>
					</div>
				</div>

			</div>
			<div class="am-g">
				<div class="am-u-sm-12">
					<form class="am-form">
						<table class="am-table am-table-striped am-table-hover table-main">
							<thead>
								<tr>
									<th class="table-check"><input type="checkbox"></th>
									<th class="table-title">下达教师</th>
									<th class="table-set">任务内容</th>
									<th class="table-set">下达时间</th>		
								</tr>
							</thead>
							<c:forEach items="${taskList}" var="task">
							<tbody>
								<tr>
									<td><input type="checkbox"></td>
									
									<td>${task.teacher.t_name}</td>
									<td>${task.information}</td>
									<td>${task.task_time}</td>
									<td>
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
												<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="javascript:return deleteTask(${task.task_id});"><span class="am-icon-trash-o"></span> 已完成</button>
											</div>
										</div>
									</td>
								</tr>
								
								</c:forEach>
								
							</tbody>
						</table>
						<div class="am-cf">
							共${totalDateCount}条任务
							<div class="am-fr">
								<ul class="am-pagination">
									<li class="am-disabled">
										<a href="${pageContext.request.contextPath }/select/showAllS.do?pageNo=${currentPage-1}">«</a>
									</li>
									<%int tpc = (Integer)session.getAttribute("tpc");int i = 1;while(i<=tpc){ %>
									<li class="am-active">
										<a href="${pageContext.request.contextPath }/select/showAllS.do?pageNo=<%=i%>"><%=i%></a>
									</li>
									<%i++;} %>
									<li>
										<a href="${pageContext.request.contextPath }/select/showAllS.do?pageNo=${currentPage+1}">»</a>
									</li>
								</ul>
							</div>
						</div>
						<hr>
					</form>
				</div>

			</div>
		</div>
		<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="myplugs/js/plugs.js"></script>
		<script>
			/* $( function(id){
				$(".btnedit").click(function() {

							$.jq_Panel({
								title: "修改链接",
								iframeWidth: 500,
								iframeHeight: 300,
								url: "t/GS.do?id="+id
							});
						});
						
				
			}) */
			function deleteTask(id){
				var msg = "您真的确定完成了吗？";
				if (confirm(msg)==true){
					window.location.href="${pageContext.request.contextPath}/delete/delTask.do?task_id="+id;
				}else{
				return false;
				}
				
			}
			function searchS(){
				var a=s.search.value;  
				window.location.href="${pageContext.request.contextPath}/select/searchS.do?search="+a;
			}

			function jtoAddS(){
				window.location.href="${pageContext.request.contextPath}/insert/jaddS.do";
			}
			function updateS(id){
				/* alert(id); */
				window.location.href="${pageContext.request.contextPath}/update/jupdateS.do?stu_id="+id;
			}
			
		</script>
</body>
</html>