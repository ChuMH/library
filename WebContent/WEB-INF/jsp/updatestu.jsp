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
<title>Insert title here</title>	
			<link rel="stylesheet" href="css/amazeui.min.css">
		<link rel="stylesheet" href="css/admin.css">
		<link rel="stylesheet" href="css/app.css">
		<style>
			.admin-main{
				padding-top: 0px;
			}
		</style>
</head>
<body>
	
		<div class="am-cf admin-main">
			<!-- content start -->
			<div class="admin-content">
				<div class="admin-content-body">
					<div class="am-g">
						<form class="am-form am-form-horizontal" action="update/updateS.do" method="post" style="padding-top: 30px;">
							<input value="504" name="roleId" type="hidden">
							<div class="am-form-group">
							
								<label for="user-name" class="am-u-sm-3 am-form-label">
									学生姓名
								</label>
								
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入学生姓名" value="${stu.stu_name }" name="stu_name" type="text">
									<small id="helpRole">输入学生姓名。</small>
								</div>
							</div>
							
							<div class="am-form-group">
							
								<label for="user-name" class="am-u-sm-3 am-form-label">
									学生性别
								</label>
								
								<div class="am-u-sm-9">
									<input type="radio" name="stu_sex" value="男" checked>男
									<input type="radio" name="stu_sex" value="女">女
									<small id="helpRole">选择学生性别</small>
								</div>
							</div>
							
							
							<div class="am-form-group">
							
								<label for="user-name" class="am-u-sm-3 am-form-label">
									馆所选择
								</label>
								
								<div class="am-u-sm-9">
									<select name="stu_houseid">
									<c:forEach items="${houseList}" var="h">
										<option value="${h.house_id}">${h.house_name}</option>
									</c:forEach>
									</select>
									<small id="helpRole">请选择馆所。</small>
								</div>
							</div>	
							
							
							<div class="am-form-group">
							
								<label for="user-name" class="am-u-sm-3 am-form-label">
									学生学号
								</label>
								
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入学号" value="${stu.stu_no }" name="stu_no" type="text">
									<small id="helpRole">输入学生学号。</small>
								</div>
							</div>
							<div class="am-form-group">
							
								<label for="user-name" class="am-u-sm-3 am-form-label">
									学生登陆用户名
								</label>
								
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入登陆用户名" value="${stu.stu_username }" name="stu_username" type="text">
									<small id="helpRole">输入学生登陆用户名。</small>
								</div>
							</div>
							<div class="am-form-group">
							
								<label for="user-name" class="am-u-sm-3 am-form-label">
									学生登陆密码
								</label>
								
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入登陆密码" value="${stu.stu_password }" name="stu_password" type="text">
									<small id="helpRole">输入学生登陆密码。</small>
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input id="addRole" class="am-btn am-btn-success" value="提交" type="submit">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>