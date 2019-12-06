<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<LINK REL="SHORTCUT ICON" HREF=image/sanpham/logoTittle.png">
<link href="stylesheet/login.css" rel="stylesheet">

</head>
<body>
<div class="form">
		<!--form login-->
		<form class="form-login" action="login" method="POST">
		<div class="#">
			<label>Login</label>
				<input type="text" class="tb-login" name="UserName" placeholder="UserName"/>
				<input type="password" class="tb-login" name="PassWord" placeholder="PassWord"/>
				<p class="p-login">You don't have account?<a onclick="removeLogin()" class="a-login"> Create Account!!!</a></p>
				<button type="submit" class="submit-login">Login</button>
		</div>
		</form>
		<!--form register-->
		<form class="form-register" action="dangki" method="POST">
			<label>Register</label>
			<input type="text" class="tb-register" name="UserName" placeholder="UserName"/>
			<input type="password" class="tb-register" name="PassWord" placeholder="PassWord"/>
			<input type="password" class="tb-register" name="ConfirmPass" placeholder="ConfirmPass"/>
			<input type="text" class="tb-register" name="Name" placeholder="Name"/>
			<input type="text" class="tb-register" name="Address" placeholder="Address"/>
			<input type="text" class="tb-register" name="Phone" placeholder="Phone"/>
			<input type="text" class="tb-register" name="Email" placeholder="Email"/>
			<p class="p-register">I have account!!! <a onclick="removeRegister()" class="a-register">Login</a></p>
			<button type="submit" class="submit-register">Register</button>
		</form>
	</div>
	<c:if test="${mess != null}">
		<script>alert("Tên đăng nhập hoặc mật khẩu không đúng")</script>
	</c:if>
	
	
	<c:if test="${checkuser != null && checkuser == 0}">
					<script>alert("Đăng kí tài khoản thành công!")</script>
				</c:if>
	<c:if test = "${checkuser != null && checkuser == 1}">
		<script>alert("Tài khoản đã có người sử dụng!!!")</script>
	</c:if>
	${checkuser}
</body>
		<script src="script/login.js"></script>
		<script src="script/adduser.js"></script>
</html>