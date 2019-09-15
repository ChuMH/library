<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
						<form class="am-form am-form-horizontal" action="insert/addA.do" method="post" style="padding-top: 30px;">
							<input value="504" name="roleId" type="hidden">
							<div class="am-form-group">
								<center><font color="red">${err}</font><br/></center>
								<label for="user-name" class="am-u-sm-3 am-form-label">
									管理员姓名
								</label>
								
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入管理员姓名" value="" name="admin_name" type="text">
									<small id="helpRole">输入管理员姓名。</small>
								</div>
							</div>

							<div class="am-form-group">
							
								<label for="user-name" class="am-u-sm-3 am-form-label">
									管理员登陆用户名
								</label>
								
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入管理员登陆用户名" value="" name="admin_username" type="text">
									<small id="helpRole">输入管理员登录用户名。</small>
								</div>
							</div>
							
							<div class="am-form-group">
							
								<label for="user-name" class="am-u-sm-3 am-form-label">
									管理员登录密码
								</label>
								
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入管理员登录密码" value="" name="admin_password" type="text">
									<small id="helpRole">管理员登录密码。</small>
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