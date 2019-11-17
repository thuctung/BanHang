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
		<img class="btnHuyDangKi" src="image/cross.png" width="20px" height="20px"/>
		<h2>Đăng kí tài khoản </h2>		
		<div class="contnet">
			<div class="chuahinhanh">
				<div class="lammo"></div>
			</div>
			<div class="formDangki">
				<form action="dangki" method="POST">
					<input  name ="taikhoan" placeholder="User Name" required/>
					<input  type ="password" name="password" placeholder="Password" required/>
					<input type="password" name ="confirmpass" placeholder="Confirm Password" required/>
					<input  name ="name" placeholder="Name" required/>
					<input  name ="phone" placeholder="Phone" required/>
					<input  name ="address" placeholder="Adress" required/>
					<input  name ="email" placeholder="Email" required/>
					<button class="btnRegister">Register</button>
				</form>
			</div>
		</div>
	</div>
	<c:if test="${mess != null}">
		<script>alert("Tên đăng nhập hoặc mật khẩu không đúng")</script>
	</c:if>
		<c:if test="${mess1 != null}">
		<script>alert("Tên đăng nhập đã có người sử dụng")</script>
	</c:if>
</body>
		<script src="script/login.js"></script>
</html>