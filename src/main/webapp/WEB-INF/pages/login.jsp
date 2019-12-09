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
		<form class="form-login" action="login" method="POST" onsubmit="return checklogin()">
		<div class="#">
			<label>Đăng nhập</label>
				<input type="text" class="tb-login" id="UserName-Login" name="UserName" placeholder="Tài khoản"/>
				<input type="password" class="tb-login" id="PassWord-Login" name="PassWord" placeholder="Mật khẩu"/>
				<p class="p-login">Bạn chưa có tài khoản?<a onclick="removeLogin()" class="a-login"> Đăng ký tài khoản</a></p>
				<button type="submit" class="submit-login">Đăng nhập</button>
		</div>
		</form>

		<!--form register-->
		<form class="form-register" action="dangki" method="POST" onsubmit="return register()">
			<label>Đăng ký</label>
			<input type="text" class="tb-register1" name="UserName" placeholder="Tài khoản"/>
				<p class="p-mess mess-username">(*)Thông tin cần chính xác</p>

			<input type="password" class="tb-register1" name="PassWord" placeholder="Mật khẩu"/>
				<p class="p-mess mess-pass">(*)Thông tin cần chính xác</p>
			<input type="password" class="tb-register1" name="ConfirmPass" placeholder="Xác nhận mật khẩu"/>
				<p class="p-mess mess-confirm">(*)Thông tin cần chính xác</p>

			<input type="text" class="tb-register1" name="Name" placeholder="Họ và tên"/>
				<p class="p-mess">(*)</p>
			<input type="text" class="tb-register" name="Address" placeholder="Địa chỉ"/>
			<input type="number" class="tb-register" name="Phone" placeholder="Số điện thoại"/>
			<input type="text" class="tb-register" name="Email" placeholder="Email"/>
				<p class="p-register">Tôi đã có tài khoản!!! <a onclick="removeRegister()" class="a-register">Đăng nhập</a></p>
			<button type="submit" class="submit-register">Đăng ký</button>
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
</body>
		<script src="script/login.js"></script>
		<script src="script/adduser.js"></script>
</html>