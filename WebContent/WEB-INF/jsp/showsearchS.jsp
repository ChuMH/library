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
		<title>学生管理</title>
		<link rel="stylesheet" href="css/amazeui.min.css" />
		<link rel="stylesheet" href="css/admin.css" />
</head>
<body>
	
	<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">学生管理</strong><small></small></div>
			</div>

			<hr>

			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default"  onclick="jtoAddS()"><span class="am-icon-plus"></span> 新增</button>
						</div>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">

				</div>
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-input-group am-input-group-sm">
					<form name="s">
						<input type="text" class="am-form-field" name="search">
					</form>	
						<span class="am-input-group-btn">			
            <button class="am-btn am-btn-default" type="button" onclick="searchS()">搜索<tton>
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
									<th class="table-set">爱好</th>
								</tr>
							</thead>
							<c:forEach items="${slist}" var="s1">
							<tbody>
								<tr>
									<td><input type="checkbox"></td>
									
									<td>${s1.stu_name}</td>
									<td>${s1.stu_sex}</td>
									<td>${s1.house.house_name }</td>
									<td>${s1.stu_no}</td>
									<td>${s1.stu_hobby}</td>
									<td>
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
												<button type="button"  class="btnedit am-btn am-btn-default am-btn-xs am-text-secondary" onclick="javascript:return updateS(${s1.stu_id})"> <span class="am-icon-pencil-square-o"></span> 编辑</button>
												<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="javascript:return deleteS(${s1.stu_id});"><span class="am-icon-trash-o"></span> 删除</button>
											</div>
										</div>
									</td>
								</tr>
								
						</c:forEach>
					
							</tbody>
						</table>

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
			function deleteS(id){
				var msg = "您真的确定要删除吗？";
				if (confirm(msg)==true){
					window.location.href="${pageContext.request.contextPath}/delete/delS.do?stu_id="+id;
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