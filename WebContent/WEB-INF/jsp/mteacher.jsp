<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理</title>
<link rel="stylesheet" href="css/amazeui.min.css" />
<link rel="stylesheet" href="css/admin.css" />
</head>
<body>

	<div class="admin-content-body">
		<div class="am-cf am-padding am-padding-bottom-0">
			<div class="am-fl am-cf">
				<strong class="am-text-primary am-text-lg">教师管理</strong><small></small>
			</div>
		</div>

		<hr>

		<div class="am-g">
			<div class="am-u-sm-12 am-u-md-6">
				<div class="am-btn-toolbar">
					<div class="am-btn-group am-btn-group-xs">
						<button type="button" class="am-btn am-btn-default"
							onclick="jtoAddT()">
							<span class="am-icon-plus"></span>新增
						</button>
					</div>
				</div>
			</div>
			<div class="am-u-sm-12 am-u-md-3"></div>
			<div class="am-u-sm-12 am-u-md-3">
				<div class="am-input-group am-input-group-sm">
					<form name="s">
						<input type="text" class="am-form-field" name="search">
					</form>
					<span class="am-input-group-btn">
						<button class="am-btn am-btn-default" type="button"
							onclick="searchT()">搜索</button>
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
								
								<th class="table-title">教师姓名</th>
								<th class="table-set">工号</th>
								<th class="table-set">管理馆所</th>
								
							</tr>
						</thead>
						<c:forEach items="${tList}" var="t">
						
							<tbody>
							
								<tr>
									<td><input type="checkbox"></td>
									
									<td>${t.t_name}</td>
									<td>${t.t_no}</td>
									<td>${t.house.house_name}</td>
									<td>
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
												<button type="button"
													class="btnedit am-btn am-btn-default am-btn-xs am-text-secondary"
													onclick="javascript:return updateT(${t.t_id})">
													<span class="am-icon-pencil-square-o"></span> 编辑
												</button>
												<button
													class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
													onclick="javascript:return deleteT(${t.t_id});">
													<span class="am-icon-trash-o"></span> 删除
												</button>
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
								<li class="am-disabled"><a
									href="${pageContext.request.contextPath }/select/showAllT.do?pageNo=${currentPage-1}">«</a>
								</li>
								<%
									int tpc = (Integer) session.getAttribute("tpc");
									int i = 1;
									while (i <= tpc) {
								%>
								<li class="am-active"><a
									href="${pageContext.request.contextPath }/select/showAllT.do?pageNo=<%=i%>"><%=i%></a>
								</li>
								<%
									i++;
									}
								%>
								<li><a
									href="${pageContext.request.contextPath }/select/showAllT.do?pageNo=${currentPage+1}">»</a>
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
			$( function(){
				$(".btnedit").click(function() {

							$.jq_Panel({
								title: "修改链接",
								iframeWidth: 500,
								iframeHeight: 300,
								url: "admin/jupdateT.do"
							});
						});
						
				
			})
			function jtoAddT(){
				window.location.href="${pageContext.request.contextPath}/insert/jaddT.do";
			}
			function deleteT(id){
				var msg = "您真的确定要删除吗？";
				if (confirm(msg)==true){
					window.location.href="${pageContext.request.contextPath}/delete/delT.do?t_id="+id;
				}else{
				return false;
				}
				
			}
			function searchT(){
				var a=s.search.value;  
				window.location.href="${pageContext.request.contextPath}/select/searchT.do?search="+a;
			}
			function updateT(id){
				window.location.href="${pageContext.request.contextPath}/update/jupdateT.do?t_id="+id;
			}
			
		</script>
</body>
</html>