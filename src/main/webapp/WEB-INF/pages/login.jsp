<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="stylesheet/login.css" rel="stylesheet">

</head>
<body>
<div class="super"></div>
	<div class="div-login">
		<h2> Đăng nhập</h2>
		<form action="login" method="POST">
		<div class="input-group">
			<input id="username" type="text" name="username" required/>
			<lable class="label" for="username">User name</lable>
		</div>
		<div class="input-group">
			<input id="matkhau" type="password" name="matkhau" required/>
			<lable class="label" for="matkhau">Password</lable>
		</div>
		<button class="btnLogin">Đăng nhập</button>
		</form>
		<p class="btnDangKi">Đăng ki tài khoản</p>
		<a class="btnBack" href="/BanHang">Trở về</a>
	</div>
	

	<div class="divDangki">
		<h2>Đăng kí tài khoản </h2>
		<button class="btnHuyDangKi">Thoát</button>
		<div class="contnet">
			<div class="chuahinhanh">
				<div class="lammo"></div>
			</div>
			<div class="formDangki">
				<form action="">
				
				</form>
			</div>
		</div>
	</div>
</body>
		<script src="script/login.js"></script>
		<script src="script/bootstrap.js"></script>
		<script src="script/jquery.js"></script>
</html>