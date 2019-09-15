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
		<title>待审核学生管理</title>
		<link rel="stylesheet" href="css/amazeui.min.css" />
		<link rel="stylesheet" href="css/admin.css" />
</head>
<body>
	
	<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">待审核学生管理</strong><small></small></div>
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
									
									<th class="table-title">姓名</th>
									<th class="table-set">性别</th>
									<th class="table-set">学院</th>
									<th class="table-set">学号</th>
								</tr>
							</thead>
							<c:forEach items="${bList}" var="b">
							<tbody>
								<tr>
									<td><input type="checkbox"></td>
									
									<td>${b.stu_name}</td>
									<td>${b.stu_sex}</td>
									<td>${b.house.house_name }</td>
									<td>${b.stu_no}</td>
									<td>
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
												<button type="button"  class="btnedit am-btn am-btn-default am-btn-xs am-text-secondary" onclick="javascript:return agreeS(${b.stu_id})"> <span class="am-icon-pencil-square-o"></span> 同意</button>
												<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="javascript:return refuseS(${b.stu_id});"><span class="am-icon-trash-o"></span> 拒绝</button>
											</div>
										</div>
									</td>
								</tr>
								
								</c:forEach>
								
							</tbody>
						</table>
						<div class="am-cf">
							共${totalDateCount}条数据
							<div class="am-fr">
								<ul class="am-pagination">
									<li class="am-disabled">
										<a href="${pageContext.request.contextPath }/select/showBadS.do?pageNo=${currentPage-1}">«</a>
									</li>
									<%int tpc = (Integer)session.getAttribute("tpc");int i = 1;while(i<=tpc){ %>
									<li class="am-active">
										<a href="${pageContext.request.contextPath }/select/showBadS.do?pageNo=<%=i%>"><%=i%></a>
									</li>
									<%i++;} %>
									
									<li>
										<a href="${pageContext.request.contextPath }/select/showBadS.do?pageNo=${currentPage+1}">»</a>
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
			function refuseS(id){
				var msg = "您真的确定要拒绝吗？";
				if (confirm(msg)==true){
					window.location.href="${pageContext.request.contextPath}/delete/refuseS.do?s_id="+id;
				}else{
				return false;
				}
				
			}
			function searchS(){
				var a=s.search.value;  
				window.location.href="${pageContext.request.contextPath}/t/search.do?search="+a;
			}
			function jtoAddS(){
				window.location.href="${pageContext.request.contextPath}/t/jaddS.do";
			}
			function agreeS(id){
				/* alert(id); */
				window.location.href="${pageContext.request.contextPath}/update/agreeS.do?s_id="+id;
			}
			
		</script>
</body>
</html>